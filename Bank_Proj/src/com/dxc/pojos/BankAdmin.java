package com.dxc.pojos;

public class BankAdmin {
private int adminid;
private String adminpassword;


public BankAdmin() {
	super();
}
public BankAdmin(int adminid, String adminpassword) {
	super();
	this.adminid = adminid;
	this.adminpassword = adminpassword;
}
public int getAdminid() {
	return adminid;
}
public void setAdminid(int adminid) {
	this.adminid = adminid;
}
public String getAdminpassword() {
	return adminpassword;
}
public void setAdminpassword(String adminpassword) {
	this.adminpassword = adminpassword;
}
@Override
public String toString() {
	return "BankAdmin [adminid=" + adminid + ", adminpassword=" + adminpassword + "]";
}

}
