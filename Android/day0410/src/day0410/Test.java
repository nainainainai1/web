package day0410;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Test {

	public static void main(String[] args) {
		//1、加载mysql驱动类
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		//jdbc:mysql://ip地址:端口号/数据库名
		String url = "jdbc:mysql://localhost:3306/sql?useUnicode=true&characterEncoding=utf8";
		String user = "root";
		String password = "root";
		//2、获取数据库链接,使用驱动管理者DriverManager的getConnection方法来获取数据库链接Connection
		try {
			Connection connection = DriverManager.getConnection(url, user, password);
			System.out.println(connection);
			Statement statement = connection.createStatement();
			statement.executeUpdate("insert into user values(2,'superadmin');");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
