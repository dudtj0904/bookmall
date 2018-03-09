package com.bookmall.dao.test;

import java.util.ArrayList;
import java.util.List;

import com.bookmall.dao.BookDao;
import com.bookmall.vo.Book;

public class BookDaoTest {

	public static void main(String[] args) {
		insertTest();
		getListTest();
	}

	public static void getListTest() {
		List<Book> list = new ArrayList<>();
		
		BookDao dao = new BookDao();
		
		list = dao.getList();
		for(Book book : list) {
			System.out.println(book);
		}
	}
	public static void insertTest() {
		Book book = new Book("쉽게 배우는 Java", 23500, 5);
		
		BookDao dao = new BookDao();
		boolean result = dao.insert(book);
		if(result == false) System.out.println("insert 실패");
	}
}
