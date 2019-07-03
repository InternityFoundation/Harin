package com.harinmehta.jdbc.entity;

import javax.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "phone_no")
	private long phoneNo;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "experience")
	private int exp;
	
	public Employee() {
		
	}

	public Employee(String name, String address, long phoneNo, String email, int exp) {
		this.name = name;
		this.address = address;
		this.phoneNo = phoneNo;
		this.email = email;
		this.exp = exp;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", address=" + address + ", phoneNo=" + phoneNo + ", email="
				+ email + ", exp=" + exp + "]";
	}
	
	

}
