package util;

// ※ 싱글톤(Singleton) 디자인 패턴을 이용한 Database 연결 객체 생성 전용 클래스
//	→ DB 연결 과정이 가장 부하가 크기 때문에 한 번 연결된 객체를 계속 사용하는 것이 좋다.

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConn 
{

	private static Connection dbConn;
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException
	{
		if (dbConn == null) 
		{
			String url = "jdbc:oracle:thin@localhost:1521:xe";
			String user = "scott";
			String pwd = "tiger";
			// 로그인
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// OracleDriver 클래스에 대한 객체 생성
			// forName : JDBC 드라이버를 로딩할 때 사용
			// Driver는 클래스db 형태로 존재하며 일반적으로 Jar파일로 존재
			
			dbConn = DriverManager.getConnection(url, user, pwd);
			// DriverManager : 데이터베이스 드라이버들을 로딩하고 연결에 관해 책임지는 클래스
			// 오라클 서버 실제 연결
		} 
		return dbConn;
	}
	
	// getConnection() 메소드 오버로딩 -> 연결
	public static Connection getConnection(String url, String user, String pwd) throws ClassNotFoundException, SQLException
	{
		if(dbConn == null)
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			dbConn = DriverManager.getConnection(url, user, pwd);
		}
		return dbConn;
	}
	
	public static void close() throws SQLException
	{
		if(dbConn != null)
		{
			if(!dbConn.isClosed())
				// "!" -> 닫혀있지 않다면
			{
				dbConn.close();
				// 연결 객체의 close() 메소드를 통해 연결 종료
			}
		}
		
		dbConn = null;
		// 연결 객체 초기화
	}
}
