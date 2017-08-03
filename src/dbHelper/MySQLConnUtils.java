package dbHelper;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
 

public class MySQLConnUtils {
	public static Connection getMySQLConnection() throws ClassNotFoundException, SQLException {

		String hostName = "node57667-datnv.jelastic.tsukaeru.net";//node57667-datnv.jelastic.tsukaeru.net 
		String dbName = "fpttest";
		String userName = "root";
		String password = "ZELkbf20699";//ZELkbf20699
		return getMySQLConnection(hostName, dbName, userName, password);
	}

	public static Connection getMySQLConnection(String hostName, String dbName, String userName, String password)
			throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");

		String connectionURL = "jdbc:mysql://" + hostName + ":3306/" + dbName;

		Connection conn = DriverManager.getConnection(connectionURL, userName, password);
		return conn;
	}
}
