package com.dxc.pojos;

public class TransactionDetails {
private int accno;
private String transaction;
private double transactionbal;
public TransactionDetails() {
	super();
}
public TransactionDetails(int accno, String transaction, double transactionbal) {
	super();
	this.accno = accno;
	this.transaction = transaction;
	this.transactionbal = transactionbal;
}
public int getAccno() {
	return accno;
}
public void setAccno(int accno) {
	this.accno = accno;
}
public String getTransaction() {
	return transaction;
}
public void setTransaction(String transaction) {
	this.transaction = transaction;
}
public double getTransactionbal() {
	return transactionbal;
}
public void setTransactionbal(double transactionbal) {
	this.transactionbal = transactionbal;
}

}
