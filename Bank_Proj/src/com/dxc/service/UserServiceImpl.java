package com.dxc.service;

import java.util.List;

import com.dxc.dao.AdminDaoImpl;
import com.dxc.dao.UserDaoImpl;
import com.dxc.pojos.BankUser;
import com.dxc.pojos.LoginBankUser;
import com.dxc.pojos.TransactionDetails;

public class UserServiceImpl {
	UserDaoImpl dao=new UserDaoImpl();
	public boolean invalidUser(int userid, String userpassword) {
		return dao.invalidUser(userid,userpassword);
	}
	public double deposit(int accno, double balance) {
		return dao.deposit(accno,balance);
	}
	
	public List<Integer> checkbal(int accno) {
		return dao.checkbal(accno);
	}

	public double withdraw(int accno, double balance) {
		return dao.withdraw(accno,balance);
	}
	public boolean changefind(int userid) {
		
		return dao.changefind(userid);
	}
	public void changepass(LoginBankUser s) {
		dao.changepass(s);
		
	}
	public double withrawmoney(int accno, double balance) {
		return dao.withrawmoney(accno,balance);
	}
	public double withdrawmoney1(int accno, double balance) {
		return dao.withdrawmoney1(accno,balance);
	}
	public List<TransactionDetails> transactionDetails() {
		return dao.transactionDetails();
	}
	
	
}
