package com.bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bookmall.frame.Dao;
import com.bookmall.vo.Category;

public class CategoryDao extends Dao<Category>{
	
	@Override
	public boolean insert(Category cate) {
		boolean result = false;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();
			
			String sql = "insert into category values(null, ?)";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, cate.getCategory());
			int cnt = pstmt.executeUpdate();
			
			result = (cnt == 1);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn != null) conn.close();
				if(pstmt != null) pstmt.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}// insert()

	@Override
	public List<Category> getList() {
		List<Category> list = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		try {
			conn = getConnection();
			
			String sql = "select * from category";
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			Category cate = null;
			while(rset.next()) {
				cate = new Category(rset.getInt(1), rset.getString(2));
				list.add(cate);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn != null) conn.close();
				if(pstmt != null) pstmt.close();
				if(rset != null) rset.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		return list;	
	}//getList()
	
}
