package com.bookmall.dao.test;

import java.util.ArrayList;
import java.util.List;

import com.bookmall.dao.MemberDao;
import com.bookmall.vo.Member;

public class MemberDaoTest {

	public static void main(String[] args) {
		System.out.println("MemberDao Test");
		
		insertTest();
		getListTest();
	}
	
	public static void getListTest() {
		List<Member> list = new ArrayList<>();
		
		MemberDao dao = new MemberDao();
		
		list = dao.getList();
		for(Member member : list) {
			System.out.println(member);
		}
	}
	public static void insertTest() {
		Member member = new Member("±è¹Î¼®", "word245@naver.com", "werfdf", "010-1254-5532");
		
		MemberDao dao = new MemberDao();
		boolean result = dao.insert(member);
		if(result == false) System.out.println("insert ½ÇÆÐ");
	}

}
