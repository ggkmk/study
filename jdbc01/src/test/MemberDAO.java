// Database �� Access �ϴ� ���
// DBConn Ȱ��

// �����͸� �Է��ϴ� ��� -> insert

// ��� ���̺��� ���ڵ� ī���� ��� -> count

// ��� ���̺��� �����͸� ��ȸ�ϴ� ��� -> select

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
		
		// �޼ҵ� ���� -> �����͸� �Է��ϴ� ��� -> insert
		public int add(MemberDTO dto) throws SQLException
		{
			// ��ȯ�� ������� ��Ƴ� ���� (����� ���� ����)
			int result = 0;
			
			// �۾� ��ü ����
			Statement stmt = conn.createStatement();
			// Statement��?
			// �����ͺ��̽��� ������ ��Ƽ� ������ �׸�
			// -> �۾���ü�� ������ �Ǿ� �����ͺ��̽��� ����������
			// �� ������ �����ͺ��̽����� ó���ȴ�
			// �� �� ���Ǵ� ���� Statement�̴�.
			
			// ������ �غ�
			String sql = String.format("INSERT INTO TBL_MEMBER(SID, NAME, TEL)"
									+ " VALUES(MEMBEREQ.NEXTVAL, %s, %s), "
									+ " dto.getName(), dto.getTel()");
			
			result = stmt.executeUpdate(sql);
			// executeUpdate() �޼ҵ�
			// -> Ư�� ������ �����ͺ��̽��� �����ؾ� �ϴ� ���
			
			// ���� ����� ��ȯ
			return result;
		}
		
		// �޼ҵ� ���� -> ��� ���̺��� ���ڵ� ī���� ���
		public int count() throws SQLException
		{
			// ��������� ��ȯ�ϰ� �� ���� ���� �� �ʱ�ȭ
			int result = 0;
			
			// �۾� ��ü ����
			Statement stme = conn.createStatement();
			
			// ������ �غ�
			String sql = "SELECT COUNT(*) AS COUNT FROM TBL_MEMBER";
			
			// ������ ����
			ResultSet rs = stme.executeQuery(sql);
			// executeQuery() �޼ҵ�
			// -> �����ͺ��̽��κ��� ���� ����� �����;� �ϴ°��
			
			// ResultSet ó�� -> �ݺ��� ����
			while (rs.next())
				result = rs.getInt("COUNT");
				// = rs.getInt(1)
				// �� �÷� �ε����� 1���� ����
			
			rs.close();
			
			//���� ����� ��ȯ
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
		
		// �����ͺ��̽� ���� ����
		public void close() throws SQLException
		{
			DBConn.close();
		}
}
