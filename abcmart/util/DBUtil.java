package com.abcmart.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	 private static String url="jdbc:oracle:thin:@localhost:1521:XE";
	 private static String username="c##j2ee";
	 private static String password="j2ee123"; 
	 
	 static public Connection getOracleDBConnection() {
		 Connection con = null;
		 try {
			 con = DriverManager.getConnection(url,username,password);
		 }
		 catch(SQLException e) {
			 e.printStackTrace();
		 }
		 return con;
	 }

}
