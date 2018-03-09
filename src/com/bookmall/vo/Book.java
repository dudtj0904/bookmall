package com.bookmall.vo;

public class Book {
	private int no;
	private String bookname;
	private int price;
	private int categoryNo;
	
	public Book() {
		// TODO Auto-generated constructor stub
	}

	public Book(String bookname, int price, int categoryNo) {
		super();
		this.bookname = bookname;
		this.price = price;
		this.categoryNo = categoryNo;
	}

	public Book(int no, String bookname, int price, int categoryNo) {
		super();
		this.no = no;
		this.bookname = bookname;
		this.price = price;
		this.categoryNo = categoryNo;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getcategoryNo() {
		return categoryNo;
	}

	public void setcategoryNo(int categoryNo) {
		this.categoryNo = categoryNo;
	}

	@Override
	public String toString() {
		return "Book [no=" + no + ", bookname=" + bookname + ", price=" + price + ", categoryNo=" + categoryNo + "]";
	}
	
}
