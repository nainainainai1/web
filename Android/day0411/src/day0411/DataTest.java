package day0411;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DataTest {

	public static void main(String[] args) {
		//1、通过工具类DataSource的静态方法getConnection来获取数据库连接Connection
		Connection connection = DataSource.getConnection();
		try {
			//2、sql语句对象:通过连接对象connection的createStatement方法来创建一个sql语句对象Statement
			Statement statement = connection.createStatement();
			//3、通过语句对象statement的executeUpdate方法来执行sql语句
			statement.executeUpdate("insert into user values(3,'super');");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
