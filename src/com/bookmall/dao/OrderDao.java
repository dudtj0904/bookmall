package com.bookmall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bookmall.frame.Dao;
import com.bookmall.vo.Order;
import com.bookmall.vo.OrderBook;

public class OrderDao extends Dao<Order> {

	@Override
	public boolean insert(Order order) {
		boolean result = false;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			
			Date date = new Date();
			SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
			String sysdate = format.format(date);
			String orderNo = "BM"+sysdate;
			
			String sql = "insert into orders values (null, ?, ?, ?, sysdate(), ?)";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, orderNo);
			pstmt.setInt(2, order.getTotalPrice());
			pstmt.setString(3, order.getDelivery());
			pstmt.setInt(4, order.getMemberNo());
			
			int cnt = pstmt.executeUpdate();
			
			result = (cnt==1);
			if(result) {
				OrderBookDao obDao = new OrderBookDao();
				OrderBook ob = new OrderBook(4, 1, 1, 8000);
				result = obDao.insert(ob);
				
				OrderBook ob2 = new OrderBook(4, 2, 1, 13500);
				result = obDao.insert(ob2);
			} else {
				return result;
			}
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
	
	// overload
	public List<Order> getList(int no) {
		List<Order> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		try {
			conn = getConnection();
			
			String sql = "select * from orders where member_no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			rset = pstmt.executeQuery();
			Order order = null;
			while(rset.next()) {
				order = new Order(rset.getInt(1), rset.getString(2), rset.getInt(3), rset.getString(4), rset.getString(5), rset.getInt(6));
				list.add(order);
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
	public List<Order> getList() {
		List<Order> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		try {
			conn = getConnection();
			
			String sql = "select * from orders";
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			Order order = null;
			while(rset.next()) {
				order = new Order(rset.getInt(1), rset.getString(2), rset.getInt(3), rset.getString(4), rset.getString(5), rset.getInt(6));
				list.add(order);
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
