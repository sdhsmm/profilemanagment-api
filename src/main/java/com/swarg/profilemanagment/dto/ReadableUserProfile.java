package com.swarg.profilemanagment.dto;

public class ReadableUserProfile {

	Long id;
	String name;
	String email;
	String phoneNo;
	String address;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "ReadableUserProfile [id=" + id + ", name=" + name + ", email=" + email + ", phoneNo=" + phoneNo + ", address=" + address + "]";
	}

}
