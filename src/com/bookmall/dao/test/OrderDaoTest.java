package com.bookmall.dao.test;

import java.util.ArrayList;
import java.util.List;

import com.bookmall.dao.OrderDao;
import com.bookmall.vo.Order;

public class OrderDaoTest {
	
	public static void main(String[] args) {
		//getListTest();
		insertTest();
	}
	
	public static void getListTest() {
		List<Order> list = new ArrayList<>();
		
		OrderDao dao = new OrderDao();
		
		list = dao.getList();
		for(Order order : list) {
			System.out.println(order);
		}
	}
	
	public static void insertTest() {
						//totalprice delivery meberno
		Order order = new Order(21500, "수원시 장안구", 8);
		
		OrderDao dao = new OrderDao();
		boolean result = dao.insert(order);
		if(result == false) System.out.println("insert 실패");
	}
	
}
