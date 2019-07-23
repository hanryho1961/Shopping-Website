package connected;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
	private static final String JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static final String DB_URL = "jdbc:sqlserver://localhost:1433;databaseName=SHOPPING;user=sa;password=HoXuanHoa1612";
	private static Connection conn;
	
	public Connect() {
		conn = null;
	}
	
	public static boolean connect() {
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL);
			return true;
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}
	
	public static Connection getConnection() {
		if (conn == null) {
			connect();
		}
		return conn;
	}
	
	public static void close() {
		try {
			if (conn != null) {
				conn.close();
			}	
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}	
	}
	
	public static void main(String[] args) {
		if (connect()) {
			System.out.println("Welcome to Database");
		} else {
			System.out.println("Fail to connect to Database");
		}
	}

}
