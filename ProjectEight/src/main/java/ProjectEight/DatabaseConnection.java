package ProjectEight;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	 private static final String URL = "jdbc:mysql://localhost:3306/carpool_db";
	    private static final String USER = "root";
	    private static final String PASSWORD = "Surya@1998";

	    public static Connection getConnection() throws SQLException {
	        try {
	            Class.forName("com.mysql.jdbc.Driver");
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        }
	        return DriverManager.getConnection(URL, USER, PASSWORD);
	    }

}
