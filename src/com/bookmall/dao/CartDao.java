package com.bookmall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bookmall.frame.Dao;
import com.bookmall.vo.Cart;

public class CartDao extends Dao<Cart> {

	@Override
	public boolean insert(Cart cart) {
		boolean result = false;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			
			String sql = "insert into cart values(null, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, cart.getAmount());
			pstmt.setInt(2, cart.getmemberNo());
			pstmt.setInt(3, cart.getbookNo());
			
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
	public List<Cart> getList(int no) {
		List<Cart> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		try {
			conn = getConnection();
			
			String sql = "select b.no, b.bookname, c.amount, b.price*c.amount, c.member_no, c.book_no, m.name" +
						" from book b, cart c, member m" +
						" where b.no=c.book_no and m.no=c.member_no and c.member_no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			rset = pstmt.executeQuery();
			Cart cart = null;
			while(rset.next()) {
				cart = new Cart(rset.getInt(1), rset.getString(2), rset.getInt(3),
						rset.getInt(4), rset.getInt(5), rset.getInt(6), rset.getString(7));
				list.add(cart);
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
	@Override
	public List<Cart> getList() {
		List<Cart> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		try {
			conn = getConnection();
			
			String sql = "select c.no, b.bookname, c.amount, b.price*c.amount, c.member_no, c.book_no, m.name" +
						" from book b, cart c, member m" +
						" where b.no=c.book_no and m.no=c.member_no";
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			Cart cart = null;
			while(rset.next()) {
				cart = new Cart(rset.getInt(1), rset.getString(2), rset.getInt(3),
						rset.getInt(4), rset.getInt(5), rset.getInt(6), rset.getString(7));
				list.add(cart);
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
