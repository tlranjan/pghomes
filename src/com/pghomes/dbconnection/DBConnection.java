package com.pghomes.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection implements DBProp{
	public static Connection getDBConnection() {
		Connection con = null;
		try {
			Class.forName(driverCls);
			con = DriverManager.getConnection(url, username, dbPassword);
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "india123");
			//"jdbc:oracle:thin:@<host>:<port>:<dbName>","userName", "password"
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	public static void closeConnection(Connection con, Statement stmt){
		if(stmt != null){
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(con != null){
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
