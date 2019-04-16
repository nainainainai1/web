package day0411;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataTest2 {

	public static void main(String[] args) {
		Connection connection = DataSource.getConnection();
		try {
			Statement statement = connection.createStatement();
			//int result = statement.executeUpdate("insert into user values(2,'super')");
			//int result = statement.executeUpdate("update user set name='admin' where id=2;");
			//int result = statement.executeUpdate("delete from user where id=2;");
			//System.out.println(result);
			ResultSet resultset = statement.executeQuery("select * from user;");
			while(resultset.next()){
				int id =resultset.getInt("id");
				String name = resultset.getString("name");
				System.out.println(id+" "+name);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
