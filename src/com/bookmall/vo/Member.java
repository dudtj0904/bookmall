package com.bookmall.vo;

public class Member {
	private int no;
	private String name;
	private String email;
	private String password;
	private String phone;
	
	public Member() {
		// TODO Auto-generated constructor stub
	}

	public Member(String name, String email, String password, String phone) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.phone = phone;
	}

	
	public Member(int no, String name, String email, String phone) {
		super();
		this.no = no;
		this.name = name;
		this.email = email;
		this.phone = phone;
	}

	public Member(int no, String name, String email, String password, String phone) {
		super();
		this.no = no;
		this.name = name;
		this.email = email;
		this.password = password;
		this.phone = phone;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Member [no=" + no + ", name=" + name + ", email=" + email  + ", phone="
				+ phone + "]";
	}
	
}
