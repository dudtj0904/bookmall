package com.bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bookmall.frame.Dao;
import com.bookmall.vo.Member;

public class MemberDao extends Dao<Member>{
	
	@Override
	public boolean insert(Member member) {
		boolean result = false;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();
			
			String sql = "insert into member values(null, ?, ?, password(?), ?)";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, member.getName());
			pstmt.setString(2, member.getEmail());
			pstmt.setString(3, member.getPassword());
			pstmt.setString(4, member.getPhone());
			
			int cnt = pstmt.executeUpdate();
			
			result = (cnt == 1);
			
		} catch(SQLException e) {
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
	}//insert()
	
	public Member get(int no) {
		Member member = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
			conn = getConnection();
			
			String sql = "select * from member where no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				member = new Member(rset.getInt(1), rset.getString(2),rset.getString(3),
						rset.getString(5));
			}
		} catch(SQLException e) {
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
		return member;
	}
	
	@Override
	public List<Member> getList() {
		List<Member> list = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
			conn = getConnection();
			
			String sql = "select * from member";
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			Member member = null;
			
			while(rset.next()) {
				int no = rset.getInt(1);
				String name = rset.getString(2);
				String email = rset.getString(3);
				String phone = rset.getString(5);
				
				member = new Member(no, name, email, phone);
				list.add(member);
			}
			
		} catch(SQLException e) {
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
	}// getList()

}
