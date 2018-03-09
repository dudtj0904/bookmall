package com.bookmall.vo;

public class Category {
	private int no;
	private String category;
	
	public Category() {
		// TODO Auto-generated constructor stub
	}

	public Category(String category) {
		super();
		this.category = category;
	}

	public Category(int no, String category) {
		super();
		this.no = no;
		this.category = category;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Category [no=" + no + ", category=" + category + "]";
	}
	
	
	
}
