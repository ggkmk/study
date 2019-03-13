// Database 에 Access 하는 기능
// DBConn 활용

// 데이터를 입력하는 기능 -> insert

// 대상 테이블의 레코드 카운팅 기능 -> count

// 대상 테이블의 데이터를 조회하는 기능 -> select

package test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import util.DBConn;

public class MemberDAO
{

		private Connection conn;
		
		public MemberDAO() throws ClassNotFoundException, SQLException
		{
			conn = DBConn.getConnection();
		}
		
		// 메소드 정의 -> 데이터를 입력하는 기능 -> insert
		public int add(MemberDTO dto) throws SQLException
		{
			// 반환할 결과값을 담아낼 변수 (적용된 행의 갯수)
			int result = 0;
			
			// 작업 객체 생성
			Statement stmt = conn.createStatement();
			// Statement란?
			// 데이터베이스로 쿼리를 담아서 보내는 그릇
			// -> 작업객체에 쿼리를 실어 데이터베이스로 보내버리면
			// 그 내용이 데이터베이스에서 처리된다
			// 이 때 사용되는 것이 Statement이다.
			
			// 쿼리문 준비
			String sql = String.format("INSERT INTO TBL_MEMBER(SID, NAME, TEL)"
									+ " VALUES(MEMBEREQ.NEXTVAL, %s, %s), "
									+ " dto.getName(), dto.getTel()");
			
			result = stmt.executeUpdate(sql);
			// executeUpdate() 메소드
			// -> 특정 내용을 데이터베이스에 적용해야 하는 경우
			
			// 최종 결과값 반환
			return result;
		}
		
		// 메소드 정의 -> 대상 테이블의 레코드 카운팅 기능
		public int count() throws SQLException
		{
			// 결과값으로 반환하게 될 변수 선언 및 초기화
			int result = 0;
			
			// 작업 객체 생성
			Statement stme = conn.createStatement();
			
			// 쿼리문 준비
			String sql = "SELECT COUNT(*) AS COUNT FROM TBL_MEMBER";
			
			// 쿼리문 실행
			ResultSet rs = stme.executeQuery(sql);
			// executeQuery() 메소드
			// -> 데이터베이스로부터 질의 결과를 가져와야 하는경우
			
			// ResultSet 처리 -> 반복문 구성
			while (rs.next())
				result = rs.getInt("COUNT");
				// = rs.getInt(1)
				// ※ 컬럼 인덱스는 1부터 시작
			
			rs.close();
			
			//최종 결과값 반환
			return result;
			
		} // end count
		
		public ArrayList<MemberDTO> list() throws SQLException
		{
			ArrayList<MemberDTO> result = new ArrayList<MemberDTO>();
			
			Statement stmt = conn.createStatement();
			
			String sql = "SELECT SID, NAME, TEL FROM TBL_MEMBER ORDER BY 1";
			
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next())
			{
				MemberDTO dto = new MemberDTO();
				dto.setSid(rs.getString("SID"));
				dto.setName(rs.getString("NAME"));
				dto.setTel(rs.getString("TEL"));
				
				result.add(dto);
			}
			
			rs.close();
			stmt.close();
			return result;
		}
		
		// 데이터베이스 연결 종료
		public void close() throws SQLException
		{
			DBConn.close();
		}
}
