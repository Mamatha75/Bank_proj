package com.dxc.service;

import java.util.List;

import com.dxc.dao.AdminDaoImpl;
import com.dxc.pojos.BankAdmin;
import com.dxc.pojos.BankUser;

public class AdminServiceImpl {
AdminDaoImpl dao=new AdminDaoImpl();

public boolean invalidAdmin(int adminid, String adminpassword) {
	
	return dao.invalidAdmin(adminid, adminpassword);
}

public void addUser(BankUser bu) {
	dao.addUser(bu);
	
}

public boolean customerfind(int accno) {
	return dao.customerfind(accno);
}

public void updatecust(BankUser s) {
	dao.updatecust(s);
	
}

public boolean removecustomer(int accno) {
	return dao.removecustomer(accno);
}

public List<Integer> getcustbalance(int accno) {
	
	return dao.getcustbalance(accno);
}

public boolean searchdetailsfind(int accno) {
	
	return dao.searchdetailsfind(accno);
}

public List<BankUser> searchdetails(int accno) {
	return dao.searchdetails(accno);
}

public List<BankUser> getAllUsers() {
	return dao.getAllUsers();
}

}
