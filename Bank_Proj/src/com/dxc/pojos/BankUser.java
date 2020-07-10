package com.dxc.pojos;

public class BankUser {
private int accno;
private String name;
private double balance;

public BankUser(double d) {
	super();
}

public BankUser(int accno, String name, double balance) {
	super();
	this.accno = accno;
	this.name = name;
	this.balance = balance;
}

public int getAccno() {
	return accno;
}

public void setAccno(int accno) {
	this.accno = accno;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public double getBalance() {
	return balance;
}

public void setBalance(double balance) {
	this.balance = balance;
}

@Override
public String toString() {
	return "BankUser [accno=" + accno + ", name=" + name + ", balance=" + balance + "]";
}
public void show() {
	System.out.println(accno);
	System.out.println(name);
	System.out.println(balance);
}

}
