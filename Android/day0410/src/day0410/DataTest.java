package day0410;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DataTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection connection = DataSource.getConnection();
		try {
			//2、sql语句对象:通过连接对象connection的createStatement方法来创建一个sql语句对象Statement
			Statement statement = connection.createStatement();
			//3、通过语句对象statement的executeUpdate方法来执行sql语句
			statement.executeUpdate("insert into user values(4,'wwwwww');");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
