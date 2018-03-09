package com.bookmall.vo;

public class OrderBook {
	private int orderNo;
	private int bookNo;
	private int amount;
	private int price;
	
	public OrderBook() {
		// TODO Auto-generated constructor stub
	}

	
	public OrderBook(int orderNo, int bookNo, int amount) {
		super();
		this.orderNo = orderNo;
		this.bookNo = bookNo;
		this.amount = amount;
	}


	public OrderBook(int orderNo, int bookNo, int amount, int price) {
		super();
		this.orderNo = orderNo;
		this.bookNo = bookNo;
		this.amount = amount;
		this.price = price;
	}

	public int getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}

	public int getBookNo() {
		return bookNo;
	}

	public void setBookNo(int bookNo) {
		this.bookNo = bookNo;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "OrderBook [orderNo=" + orderNo + ", bookNo=" + bookNo + ", amount=" + amount + ", price=" + price + "]";
	}

	
}
