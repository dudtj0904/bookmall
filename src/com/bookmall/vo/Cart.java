package com.bookmall.vo;

public class Cart {
	private int no;
	private int amount;
	private int memberNo;
	private int bookNo;
	
	private String bookname;
	private int price;
	private String name; //구매자이름
	
	public Cart() {
	}

	public Cart(int amount, int memberNo, int bookNo) {
		super();
		this.amount = amount;
		this.memberNo = memberNo;
		this.bookNo = bookNo;
	}

	// 출력용
	public Cart(int amount, String bookname, int price, String name) {
		super();
		this.amount = amount;
		this.bookname = bookname;
		this.price = price;
		this.name = name;
	}

	

	public Cart(int no, String bookname, int amount, int price, int memberNo, int bookNo, String name) {
		super();
		this.no = no;
		this.amount = amount;
		this.memberNo = memberNo;
		this.bookNo = bookNo;
		this.bookname = bookname;
		this.price = price;
		this.name = name;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getmemberNo() {
		return memberNo;
	}

	public void setmemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public int getbookNo() {
		return bookNo;
	}

	public void setbookNo(int bookNo) {
		this.bookNo = bookNo;
	}
	
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	@Override
	public String toString() {
		return "Cart [no=" + no + ", amount=" + amount + ", memberNo=" + memberNo + ", bookNo=" + bookNo + ", bookname="
				+ bookname + ", price=" + price + ", name=" + name + "]";
	}

	
	
}
