package day0411;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

//����һ���������ڻ�ȡ���ݿ����Ӷ���
public class DataSource {

	// jdbc:mysql://ip��ַ:�˿ں�/���ݿ���
	static String url = "jdbc:mysql://localhost:3306/sql?useUnicode=true&characterEncoding=utf8";
	static String user = "root";
	static String password = "root";

	// ��һʹ��������ʱ����ִ��������Ĵ���
	static {
		// 1������mysql������
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	// ����һ����̬�������ڻ�ȡ���ݿ�����
	public static Connection getConnection() {
		// 2����ȡ���ݿ�����,ʹ������������DriverManager��getConnection��������ȡ���ݿ�����Connection
		try {
			Connection connection = DriverManager.getConnection(url, user, password);
			//���û�г����쳣�ͷ����Ѿ���ȡ�˵����Ӷ���
			return connection;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//��������쳣�ͷ��ؿ�
		return null;
	}
}
	