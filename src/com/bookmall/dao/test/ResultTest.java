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
			System.out.print("\n관리자 [0] 고객 [1] 종료 [2] : ");
			int who = scanner.nextInt();
			
			if(who == 0) {
				manageProgram();
			}else if(who == 1) {
				memberProgram();
			}else if(who == 2) {
				break;
			}else {
				System.out.println("[0] [1] [2] 중 입력하세요.");
			}
			
			
		}//while
	}//main
	public static void memberProgram() {
		while(true) {
			Scanner scanner = new Scanner(System.in);
			
			System.out.print("\n고객 번호를 입력하세요(0:quit) : ");
			int no = scanner.nextInt();
			if(no==0) {
				System.out.println("종료.");
				break;
			}
			Member member = memberDao.get(no);
			if(member == null) {
				System.out.println("고객 번호가 없습니다.");
				continue;
			}
			
			List<Cart> cartList = cartDao.getList(no);
			System.out.println("====member info====");
			System.out.println(member);
			System.out.println("===================");
			System.out.println("====cart list====");
			if(cartList.size()==0) {
				System.out.println("cart 비어있음.");
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
				System.out.println("order 비어있음.");
			} else {
				for(Order order : list) {
					System.out.println(order);
					
					System.out.println("----order book list----");
					List<OrderBook> olist = new ArrayList<>();
					
					olist = orderbookDao.getList(order.getNo());
					if(olist.size()==0) {
						System.out.println("order_book 비어있음.");
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
			System.out.println("member 없음.");
			return;
		}
		for(Member member : memberList) {
			System.out.println(member);
		}
		System.out.println("===================");
		System.out.println("====cart list====");
		List<Cart> cartList = cartDao.getList();
		if(cartList.size() == 0) {
			System.out.println("cart 없음.");
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
			System.out.println("order 비어있음.");
		} else {
			for(Order order : list) {
				System.out.println(order);
				
				System.out.println("----order book list----");
				List<OrderBook> olist = new ArrayList<>();
				
				olist = orderbookDao.getList(order.getNo());
				if(olist.size()==0) {
					System.out.println("order_book 비어있음.");
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
		System.out.println("=========통계=========");
		System.out.println("회원 리스트 - "+ memberList.size() +"명");
		System.out.println("상품 리스트 - "+ bookList.size() +"개");
		System.out.println("카테고리 리스트 - "+ cateList.size() +"개");
		System.out.println("카트 리스트 - "+ cartList.size() +"개");
		System.out.println("주문 리스트 - "+ list.size() +"개");
		System.out.println("주문 도서 리스트 - "+ count +"개");
		
		System.out.println("=====================");
	}//manageProgram()

}
