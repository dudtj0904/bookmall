package com.bookmall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bookmall.frame.Dao;
import com.bookmall.vo.Book;
import com.bookmall.vo.Category;

public class BookDao extends Dao<Book> {

	@Override
	public boolean insert(Book book) {
		boolean result = false;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			
			String sql = "insert into book values(null, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, book.getBookname());
			pstmt.setInt(2, book.getPrice());
			pstmt.setInt(3, book.getcategoryNo());
			
			int cnt = pstmt.executeUpdate();
			
			result = (cnt==1);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn != null) conn.close();
				if(pstmt != null) pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}

	@Override
	public List<Book> getList() {
		List<Book> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		try {
			conn = getConnection();
			
			String sql = "select * from book";
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			Book book = null;
			while(rset.next()) {
				book = new Book(rset.getInt(1), rset.getString(2),
						rset.getInt(3), rset.getInt(4));
				list.add(book);
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
	}

}
