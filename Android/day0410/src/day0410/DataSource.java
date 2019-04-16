package day0410;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSource {
	// jdbc:mysql://ip��ַ:�˿ں�/���ݿ���
		static String url = "jdbc:mysql://localhost:3306/sql?useUnicode=true&characterEncoding=utf8";
		static String user = "root";
		static String password = "root";
		static {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
	public static Connection getConnection() {
		try {
			Connection connection = DriverManager.getConnection(url, user, password);
			//���û�г����쳣�ͷ����Ѿ���ȡ�˵����Ӷ���
			return connection;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
