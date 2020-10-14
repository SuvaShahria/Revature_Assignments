package com.app.models;

public class Account {
	private int accountId; 
	private int userId;
	private User user;
	private float balance;  
	private AccountStatus status;
	private AccountType type;
	private int statusId; 
	private int typeId;
	
	
	public Account() {
		super();
	}	

	public Account(int userId, AccountType type) {
		super();
		this.userId = userId;
		this.type = type;
	}
	
	public Account(int accountId, AccountStatus status) {
		super();
		this.accountId = accountId;
		this.status = status;
	}
	
	public Account(int accountId, int userId, User user, float balance, AccountStatus status, AccountType type,
			int statusId, int typeId) {
		super();
		this.accountId = accountId;
		this.userId = userId;
		this.user = user;
		this.balance = balance;
		this.status = status;
		this.type = type;
		this.statusId = statusId;
		this.typeId = typeId;
	}

	public Account(int accountId, int userId, User user, float balance, AccountStatus status, AccountType type) {
		super();
		this.accountId = accountId;
		this.userId = userId;
		this.user = user;
		this.balance = balance;
		this.status = status;
		this.type = type;
	}

	public Account(int userId, float balance, AccountStatus status, AccountType type) {
		super();
		this.userId = userId;
		this.balance = balance;
		this.status = status;
		this.type = type;
	}

	public int getAccountId() {
		return accountId;
	}



	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}



	public int getUserId() {
		return userId;
	}



	public void setUserId(int userId) {
		this.userId = userId;
	}



	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}



	public float getBalance() {
		return balance;
	}



	public void setBalance(float balance) {
		this.balance = balance;
	}



	public AccountStatus getStatus() {
		return status;
	}



	public void setStatus(AccountStatus status) {
		this.status = status;
	}



	public AccountType getType() {
		return type;
	}



	public void setType(AccountType type) {
		this.type = type;
	}



	public int getStatusId() {
		return statusId;
	}



	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}



	public int getTypeId() {
		return typeId;
	}



	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}



	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", userId=" + userId + ", user=" + user + ", balance=" + balance
				+ ", status=" + status + ", type=" + type + ", statusId=" + statusId + ", typeId=" + typeId + "]";
	} 
	
	

}
