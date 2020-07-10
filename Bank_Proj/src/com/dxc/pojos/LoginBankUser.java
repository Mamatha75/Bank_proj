package com.dxc.pojos;

public class LoginBankUser {
	private int userid;
	private String userpassword;
	
	
	public LoginBankUser() {
		super();
	}

	public LoginBankUser(int userid, String userpassword) {
		super();
		this.userid = userid;
		this.userpassword = userpassword;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getUserpassword() {
		return userpassword;
	}

	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}

	@Override
	public String toString() {
		return "LoginBankUser [userid=" + userid + ", userpassword=" + userpassword + "]";
	}
	
}
