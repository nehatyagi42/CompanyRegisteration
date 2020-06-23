package com.rtpl.register.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employeeRegister")
public class EmployeeRegister {
	/*
	 * firstName: "", lastName: "", password: '', gender: "", address: "",
	 */
	
	 @Id
	 @Column(name="id")
	 private int id;
	 
	 @Column(name = "firstName")
	 private String firstName;
	 
	 public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	@Column(name = "lastName")
	 private String lastName;
	 
	 @Column(name = "password")
	 private String password;
	 
	 @Column(name = "gender")
	 private String gender;
	 
	 @Column(name = "address")
	 private String address;
	 
	 public EmployeeRegister() {
		 
	 }
	 
	 
	

	public EmployeeRegister(int id, String firstName, String lastName, String password, String gender, String address) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.gender = gender;
		this.address = address;
	}

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}


	 
	 
	 
}
