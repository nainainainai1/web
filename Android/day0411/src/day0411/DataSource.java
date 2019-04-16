package day0411;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

//定义一个工具用于获取数据库连接对象
public class DataSource {

	// jdbc:mysql://ip地址:端口号/数据库名
	static String url = "jdbc:mysql://localhost:3306/sql?useUnicode=true&characterEncoding=utf8";
	static String user = "root";
	static String password = "root";

	// 在一使用这个类的时候先执行这里面的代码
	static {
		// 1、加载mysql驱动类
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	// 定义一个静态方法用于获取数据库连接
	public static Connection getConnection() {
		// 2、获取数据库链接,使用驱动管理者DriverManager的getConnection方法来获取数据库链接Connection
		try {
			Connection connection = DriverManager.getConnection(url, user, password);
			//如果没有出现异常就返回已经获取了的连接对象
			return connection;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//如果出现异常就返回空
		return null;
	}
}
	