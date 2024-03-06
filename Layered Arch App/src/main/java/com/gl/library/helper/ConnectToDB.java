package com.gl.library.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * HELPER class to handle DACONNECTIVITY with 'sample' Data Base in MYSQL
 * @author sangeeta jadhav
 *
 */
public class ConnectToDB {

	//New instance of connection
	private static Connection connection=null;
	
	//Opening connection with MYSQL database
	public static Connection createConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","root");
		return connection;
	}
	
	//Closing connection
	public static void closeConnection() throws SQLException {
		connection.close();
	}
}
