package day0409;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class test2 {

	public static void main(String[] args) {
		//1������mysql������
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		//jdbc:mysql://ip��ַ:�˿ں�/���ݿ���
		String url = "jdbc:mysql://localhost:3306/java1731?useUnicode=true&characterEncoding=utf8";
		String user = "root";
		String password = "root";
		//2����ȡ���ݿ�����,ʹ������������DriverManager��getConnection��������ȡ���ݿ�����Connection
		try {
			Connection connection = DriverManager.getConnection(url, user, password);
			System.out.println(connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}

