package com.bookmall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bookmall.frame.Dao;
import com.bookmall.vo.Order;
import com.bookmall.vo.OrderBook;

public class OrderBookDao extends Dao<OrderBook> {

	@Override
	public boolean insert(OrderBook obook) {
		boolean result = false;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			
			String sql = "insert into order_book values(?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, obook.getOrderNo());
			pstmt.setInt(2, obook.getBookNo());
			pstmt.setInt(3, obook.getAmount());
			pstmt.setInt(4, obook.getPrice()*obook.getAmount());
			
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
	
	public List<OrderBook> getList(int order_no) {
		List<OrderBook> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		try {
			conn = getConnection();
			
			String sql = "select * from order_book where order_no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, order_no);
			rset = pstmt.executeQuery();
			OrderBook ob = null;
			while(rset.next()) {
				ob = new OrderBook(rset.getInt(1), rset.getInt(2), rset.getInt(3), rset.getInt(4));
				list.add(ob);
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
	public List<OrderBook> getList() {
		List<OrderBook> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		try {
			conn = getConnection();
			
			String sql = "select * from order_book";
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			OrderBook ob = null;
			while(rset.next()) {
				ob = new OrderBook(rset.getInt(1), rset.getInt(2), rset.getInt(3), rset.getInt(4));
				list.add(ob);
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
