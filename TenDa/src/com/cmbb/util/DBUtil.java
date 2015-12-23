package com.cmbb.util;

import java.sql.*;

public class DBUtil {
	
	private static String url = "jdbc:sqlserver://localhost:1433;databasename=tedda";
	private static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	
	
	public static Connection getConnection(){
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, "sa", "111111");	
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return con;

	}
	
	public static void closeAll(Connection con,Statement stmt,ResultSet rs){
		
			try {
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
				if(con!=null) con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	public static void bindParams(PreparedStatement pst,Object[] params){
		for(int i=0;i<params.length;i++){
			try {
				pst.setObject(i+1, params[i]);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
}
