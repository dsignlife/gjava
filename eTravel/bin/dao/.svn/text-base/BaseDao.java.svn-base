package dao;

import java.sql.*;
public class BaseDao {


	public Connection getConnection() {
		
		Connection conn = null;
		String url = "jdbc:mysql://db.student.chalmers.se:3306/";
		String dbName = "abdoli";
		String driver = "com.mysql.jdbc.Driver";
		String userName = "abdoli"; 
		String password = "kgcH8v7c";

		try {
			Class.forName(driver).newInstance();
			conn = DriverManager.getConnection(url+dbName,userName,password);
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return conn;
		
	}
}
