package day0410;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DataTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection connection = DataSource.getConnection();
		try {
			//2��sql������:ͨ�����Ӷ���connection��createStatement����������һ��sql������Statement
			Statement statement = connection.createStatement();
			//3��ͨ��������statement��executeUpdate������ִ��sql���
			statement.executeUpdate("insert into user values(4,'wwwwww');");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
