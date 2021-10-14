package com.project.store.model;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(name="EMAIL")
	private String email;

	@Column(name="NAME")
	private String name;
	
	@Column(name = "SURNAME")
	private String surname;
	
	@Column(name = "PASSWORD")
	private String password;
	
	@Column(name = "PHONE")
	private Integer phone;
	
	@Column(name = "ADDRESS")
	private String address;
	
	@Column (name = "SEX")
	private Integer sex;

	public void setEmail(String email) {
		this.email = email;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setPhone(Integer phone) {
		this.phone = phone;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public void setRole_id(Integer role_id) {
		this.role_id = role_id;
	}

	@Column (name = "ROLE_ID")
	private Integer role_id;

	public Long getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	public String getPassword() {
		return password;
	}

	public Integer getPhone() {
		return phone;
	}

	public String getAddress() {
		return address;
	}

	public Integer getSex() {
		return sex;
	}

	public String getRoleName(){
		switch (role_id){
			case 1:
				return "Admin";
			case 2:
				return "User";
			case 3:
				return "Manager";
			default:
				return "Nan";
		}
	}

	public Integer getRole_id() {
		return role_id;
	}
}
