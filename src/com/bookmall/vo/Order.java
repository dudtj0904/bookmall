package com.bookmall.vo;

public class Order {
	private int no;
	private String orderNo;
	private int totalPrice;
	private String delivery;
	private String orderDate;
	private int memberNo;
	
	public Order() {
		// TODO Auto-generated constructor stub
	}

	public Order(int totalPrice, String delivery, int memberNo) {
		super();
		this.totalPrice = totalPrice;
		this.delivery = delivery;
		this.memberNo = memberNo;
	}

	public Order(int no, int totalPrice, String delivery, int memberNo) {
		super();
		this.no = no;
		this.totalPrice = totalPrice;
		this.delivery = delivery;
		this.memberNo = memberNo;
	}
	

	public Order(int no, String orderNo, int totalPrice, String delivery, String orderDate, int memberNo) {
		super();
		this.no = no;
		this.orderNo = orderNo;
		this.totalPrice = totalPrice;
		this.delivery = delivery;
		this.orderDate = orderDate;
		this.memberNo = memberNo;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getDelivery() {
		return delivery;
	}

	public void setDelivery(String delivery) {
		this.delivery = delivery;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	
	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	@Override
	public String toString() {
		return "Order [no=" + no + ", orderNo=" + orderNo + ", totalPrice=" + totalPrice + ", delivery=" + delivery
				+ ", orderDate=" + orderDate + ", memberNo=" + memberNo + "]";
	}

	
	
}
