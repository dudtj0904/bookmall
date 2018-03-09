package com.bookmall.frame;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public abstract class Dao<T> {

	public abstract boolean insert(T t);
	public abstract List<T> getList();
	
	protected Connection getConnection() throws SQLException{
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost/bookmall";
			conn = DriverManager.getConnection(url, "bookmall", "bookmall");
		} catch (ClassNotFoundException e) {
			System.out.println("����̹� �ε� ����: " + e);
		} 
		return conn;
	}//getConnction()
}
