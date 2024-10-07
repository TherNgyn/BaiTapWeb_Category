package vn.iostar.config;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.mysql.cj.jdbc.DatabaseMetaData;

public class DBConnection {
	private static Connection con = null;
	private static String USERNAME = "root";
	private static String PASSWORD = "root";
	private static String URL = "jdbc:mysql://localhost:3306/login_register";

	public static Connection getDatabaseConnection() throws IOException {
		con = null;
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			con = (Connection) DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (SQLException ex) {
			Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
		}
		return (con);
	}
	public static void main(String[] args) {
		try {
			Connection c = getDatabaseConnection();
			if(c!=null) {
				System.out.println("ok");
			}
			else {
				System.out.println("wrong");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
