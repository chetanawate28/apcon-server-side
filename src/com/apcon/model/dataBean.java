package com.apcon.model;

public class dataBean {
	public String name,email,dob,mbnum;
	public int Id;
	
	public dataBean( int id,String name, String email, String dob, String mbnum) {
		super();
		this.name = name;
		this.email = email;
		this.dob = dob;
		this.mbnum = mbnum;
		Id = id;
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
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	
	public String getMbnum() {
		return mbnum;
	}
	public void setMbnum(String mbnum) {
		this.mbnum = mbnum;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	
	
}
