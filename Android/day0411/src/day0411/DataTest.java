package day0411;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DataTest {

	public static void main(String[] args) {
		//1��ͨ��������DataSource�ľ�̬����getConnection����ȡ���ݿ�����Connection
		Connection connection = DataSource.getConnection();
		try {
			//2��sql������:ͨ�����Ӷ���connection��createStatement����������һ��sql������Statement
			Statement statement = connection.createStatement();
			//3��ͨ��������statement��executeUpdate������ִ��sql���
			statement.executeUpdate("insert into user values(3,'super');");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
