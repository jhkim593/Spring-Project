package com.myboot01.web.vo;

public class MemberVO {

	private String id;
	private String name;
	private String pw;
	private String address;
	private int age;
	
	
	
	
	
	public MemberVO() {
		super();
	}
	
	public MemberVO(String id, String pw ,String name) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		
	}
	
	public MemberVO(String id, String name, String pw, String address, int age) {
		super();
		this.id = id;
		this.name = name;
		this.pw = pw;
		this.address = address;
		this.age = age;
	}
  
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}

	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", name=" + name + ", pw=" + pw + ", address=" + address + ", age=" + age + "]";
	}
	
	

}
