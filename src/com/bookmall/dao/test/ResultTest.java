package com.bookmall.dao.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.bookmall.dao.BookDao;
import com.bookmall.dao.CartDao;
import com.bookmall.dao.CategoryDao;
import com.bookmall.dao.MemberDao;
import com.bookmall.dao.OrderBookDao;
import com.bookmall.dao.OrderDao;
import com.bookmall.vo.Book;
import com.bookmall.vo.Cart;
import com.bookmall.vo.Category;
import com.bookmall.vo.Member;
import com.bookmall.vo.Order;
import com.bookmall.vo.OrderBook;

public class ResultTest {
		
	public static MemberDao memberDao = new MemberDao();
	public static CartDao cartDao = new CartDao();
	public static BookDao bookDao = new BookDao();
	public static CategoryDao categoryDao = new CategoryDao();
	public static OrderDao orderDao = new OrderDao();
	public static OrderBookDao orderbookDao = new OrderBookDao();
	
	public static void main(String[] args) {
		while(true) {
			Scanner scanner = new Scanner(System.in);
			System.out.print("\n������ [0] �� [1] ���� [2] : ");
			int who = scanner.nextInt();
			
			if(who == 0) {
				manageProgram();
			}else if(who == 1) {
				memberProgram();
			}else if(who == 2) {
				break;
			}else {
				System.out.println("[0] [1] [2] �� �Է��ϼ���.");
			}
			
			
		}//while
	}//main
	public static void memberProgram() {
		while(true) {
			Scanner scanner = new Scanner(System.in);
			
			System.out.print("\n�� ��ȣ�� �Է��ϼ���(0:quit) : ");
			int no = scanner.nextInt();
			if(no==0) {
				System.out.println("����.");
				break;
			}
			Member member = memberDao.get(no);
			if(member == null) {
				System.out.println("�� ��ȣ�� �����ϴ�.");
				continue;
			}
			
			List<Cart> cartList = cartDao.getList(no);
			System.out.println("====member info====");
			System.out.println(member);
			System.out.println("===================");
			System.out.println("====cart list====");
			if(cartList.size()==0) {
				System.out.println("cart �������.");
			} else {
				for(Cart cart : cartList) {
					System.out.println(cart);
				}
			}
			System.out.println("=================");
			System.out.println("====book list====");
			List<Book> bookList = new ArrayList<>();
					
			bookList = bookDao.getList();
			for(Book book : bookList) {
				System.out.println(book);
			}
			System.out.println("=================");
			System.out.println("====order list====");
			List<Order> list = new ArrayList<>();
			
			list = orderDao.getList(no);
			if(list.size()==0) {
				System.out.println("order �������.");
			} else {
				for(Order order : list) {
					System.out.println(order);
					
					System.out.println("----order book list----");
					List<OrderBook> olist = new ArrayList<>();
					
					olist = orderbookDao.getList(order.getNo());
					if(olist.size()==0) {
						System.out.println("order_book �������.");
					} else {
						for(OrderBook orderBook : olist) {
							System.out.println(orderBook);
						}
					}
					System.out.println("-----------------------\n");
				}
			}
			System.out.println("==================");
		}
	}// memberProgram()
	
	public static void manageProgram() {
		System.out.println("====member info====");
		List<Member> memberList = memberDao.getList();
		if(memberList.size()==0) {
			System.out.println("member ����.");
			return;
		}
		for(Member member : memberList) {
			System.out.println(member);
		}
		System.out.println("===================");
		System.out.println("====cart list====");
		List<Cart> cartList = cartDao.getList();
		if(cartList.size() == 0) {
			System.out.println("cart ����.");
		} else {
			for(Cart cart : cartList) {
				System.out.println(cart);
			}
		}
		System.out.println("=================");
		System.out.println("====book list====");
		List<Book> bookList = new ArrayList<>();
				
		bookList = bookDao.getList();
		for(Book book : bookList) {
			System.out.println(book);
		}
		System.out.println("=================");
		System.out.println("====category list====");
		List<Category> cateList = new ArrayList<>();
					
		cateList = categoryDao.getList();
		for(Category cate : cateList) {
			System.out.println(cate);
		}
		System.out.println("=====================");
		System.out.println("====order list====");
		List<Order> list = new ArrayList<>();
		
		list = orderDao.getList();
		int count = 0;
		if(list.size()==0) {
			System.out.println("order �������.");
		} else {
			for(Order order : list) {
				System.out.println(order);
				
				System.out.println("----order book list----");
				List<OrderBook> olist = new ArrayList<>();
				
				olist = orderbookDao.getList(order.getNo());
				if(olist.size()==0) {
					System.out.println("order_book �������.");
				} else {
					for(OrderBook orderBook : olist) {
						System.out.println(orderBook);
						count++;
					}
				}
				System.out.println("-----------------------\n");
			}
		}
		System.out.println("==================");
		System.out.println("=========���=========");
		System.out.println("ȸ�� ����Ʈ - "+ memberList.size() +"��");
		System.out.println("��ǰ ����Ʈ - "+ bookList.size() +"��");
		System.out.println("ī�װ� ����Ʈ - "+ cateList.size() +"��");
		System.out.println("īƮ ����Ʈ - "+ cartList.size() +"��");
		System.out.println("�ֹ� ����Ʈ - "+ list.size() +"��");
		System.out.println("�ֹ� ���� ����Ʈ - "+ count +"��");
		
		System.out.println("=====================");
	}//manageProgram()

}
