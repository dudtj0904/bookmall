package com.bookmall.dao.test;

import java.util.ArrayList;
import java.util.List;

import com.bookmall.dao.CartDao;
import com.bookmall.vo.Cart;

public class CartDaoTest {

	public static void main(String[] args) {
		//insertTest();
		getListTest();
	}
	
	public static void getListTest() {
		List<Cart> list = new ArrayList<>();
		
		CartDao dao = new CartDao();
		
		list = dao.getList();
		for(Cart cart : list) {
			System.out.println(cart);
		}
	}
	public static void insertTest() {
		Cart cart = new Cart(1, 1, 2);
		
		CartDao dao = new CartDao();
		boolean result = dao.insert(cart);
		if(result == false) System.out.println("insert ½ÇÆÐ");
	}
}
