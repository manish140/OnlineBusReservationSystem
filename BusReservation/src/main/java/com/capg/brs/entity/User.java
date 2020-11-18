package com.capg.brs.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="WalletUserDetails")
public class User {
	@Id
	private int userId;
	private String userName;
	private String phoneNumber;
	private String password;
	private String loginName;
	//one to one relationship between WalletUser and WalletAccount
	@OneToOne(mappedBy="walletUser",cascade=CascadeType.ALL,fetch = FetchType.LAZY,orphanRemoval=true)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	
	}
	public boolean existById(int userId2) {
		// TODO Auto-generated method stub
		return false;
	}
	public User getOne(int userId2) {
		// TODO Auto-generated method stub
		return null;
	}
	


}