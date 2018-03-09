package com.bookmall.dao.test;

import java.util.ArrayList;
import java.util.List;

import com.bookmall.dao.CategoryDao;
import com.bookmall.vo.Category;

public class CategoryDaoTest {
	
	public static void main(String[] args) {
		System.out.println("CategoryDaoTest");
		insertTest();
		getListTest();
	}
	
	public static void getListTest() {
		List<Category> list = new ArrayList<>();
		
		CategoryDao dao = new CategoryDao();
		
		list = dao.getList();
		for(Category cate : list) {
			System.out.println(cate);
		}
	}
	public static void insertTest() {
		Category cate = new Category("에세이");
		
		CategoryDao dao = new CategoryDao();
		boolean result = dao.insert(cate);
		if(result == false) System.out.println("insert 실패");
	}
}
