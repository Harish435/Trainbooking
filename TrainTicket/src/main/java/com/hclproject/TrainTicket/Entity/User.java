package com.hclproject.TrainTicket.Entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long uid;
	@NotNull(message = "First name is mandatory.")
	private String userName;
	
	private String passWord;
	@Email
	@NotEmpty
	private String email;
	
	private String phoneNumber;
	
	private int age;
	
	private String role;
	
	/*@OneToMany(targetEntity=Train.class,cascade=CascadeType.ALL)
	@JoinColumn(name="t_fk",referencedColumnName="uid")*/
	
	
	public User() {
	}


	public Long getUid() {
		return uid;
	}


	public void setUid(Long uid) {
		this.uid = uid;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPassWord() {
		return passWord;
	}


	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}

	public User(@NotNull(message = "First name is mandatory.") String userName, String passWord, @Email @NotEmpty String email, String phoneNumber, int age, String role) {
		this.userName = userName;
		this.passWord = passWord;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.age = age;
		this.role = role;
	}

	public User(Long uid, @NotNull(message = "First name is mandatory.") String userName, String passWord, @Email @NotEmpty String email, String phoneNumber, int age, String role) {
		this.uid = uid;
		this.userName = userName;
		this.passWord = passWord;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.age = age;
		this.role = role;
	}
}
