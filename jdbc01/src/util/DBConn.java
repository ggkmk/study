package util;

// �� �̱���(Singleton) ������ ������ �̿��� Database ���� ��ü ���� ���� Ŭ����
//	�� DB ���� ������ ���� ���ϰ� ũ�� ������ �� �� ����� ��ü�� ��� ����ϴ� ���� ����.

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
			// �α���
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// OracleDriver Ŭ������ ���� ��ü ����
			// forName : JDBC ����̹��� �ε��� �� ���
			// Driver�� Ŭ����db ���·� �����ϸ� �Ϲ������� Jar���Ϸ� ����
			
			dbConn = DriverManager.getConnection(url, user, pwd);
			// DriverManager : �����ͺ��̽� ����̹����� �ε��ϰ� ���ῡ ���� å������ Ŭ����
			// ����Ŭ ���� ���� ����
		} 
		return dbConn;
	}
	
	// getConnection() �޼ҵ� �����ε� -> ����
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
				// "!" -> �������� �ʴٸ�
			{
				dbConn.close();
				// ���� ��ü�� close() �޼ҵ带 ���� ���� ����
			}
		}
		
		dbConn = null;
		// ���� ��ü �ʱ�ȭ
	}
}
