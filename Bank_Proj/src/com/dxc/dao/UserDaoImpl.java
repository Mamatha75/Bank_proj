package com.dxc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dxc.pojos.BankUser;
import com.dxc.pojos.LoginBankUser;
import com.dxc.pojos.TransactionDetails;

public class UserDaoImpl {
	private static Connection conn;
	TransactionDetails t=new TransactionDetails();
int count=0,b,var;
	static
	{
		try                 
		  {
		  Class.forName("com.mysql.jdbc.Driver");
		  System.out.println("Driver loaded...");
		  
		  conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mamatha","root","Root");
		  System.out.println("Connected to database...");
		  }
		  catch(Exception e)
	          {
			  e.printStackTrace();	
	          }		
	}
	public boolean invalidUser(int userid, String userpassword) {
		System.out.println("search details"); 
		 try
			{
       Statement stmt = conn.createStatement();
			 ResultSet rset = stmt.executeQuery("select * from loginbankuser");
			 while(rset.next())
			    {
			   if(userid==rset.getInt(1) && userpassword.equals(rset.getString(2)))
			   {
				   return true;
				}
				}
				}
			catch (Exception e) 
				{
				System.out.println("Invalid details Occured!!!");
				e.printStackTrace();
				}
				return false;
	}
	public double deposit(int accno, double balance) {
		double balance1=0;
		String s="deposit";
		try {
			PreparedStatement pstmt=conn.prepareStatement("select * from bankuser where accno=?");
			pstmt.setInt(1, accno);
			ResultSet rset =pstmt.executeQuery();
			rset.next();
			balance1=rset.getDouble(3);
			System.out.println("before balance-" +balance1);
			balance1=balance1+balance;
			System.out.println("after balance-" +balance1);
			System.out.println("--------------------------");
			PreparedStatement pstmt1=conn.prepareStatement("update bankuser set balance=? where accno=?");
			pstmt1.setDouble(1, balance1);
			pstmt1.setInt(2,accno);
			pstmt1.executeUpdate();
			
			
			PreparedStatement pstmt2=conn.prepareStatement("insert into transactiondetails values(?,?,?)");
			pstmt2.setInt(1, accno);
			pstmt2.setString(2, s);
			pstmt2.setDouble(3, balance);
			pstmt2.executeUpdate();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return balance1;
	}
	public List<Integer> checkbal(int accno) {
		  System.out.println("enter getbalane"); 
		  List<Integer> list = new ArrayList<>(); 
		  int balance=0;
		  try {
			  PreparedStatement pstmt =conn.prepareStatement("select balance from bankuser where accno=?");
			  pstmt.setInt(1,accno);
		  ResultSet rset = pstmt.executeQuery();
		  System.out.println("---------------------------");
		  
		  while(rset.next()) {
			 balance=rset.getInt(1);
			 list.add(balance);
		  
		  }
		  
		  }
		     catch (Exception e) { 
		            e.printStackTrace();
		      } 
		return list;
	}
	public double withdraw(int accno, double balance) {
		String s="withdraw";
		double balance1=0;
		try {
			PreparedStatement pstmt=conn.prepareStatement("select * from bankuser where accno=?");
			pstmt.setInt(1, accno);
			ResultSet rset =pstmt.executeQuery();
			rset.next();
			balance1=rset.getDouble(3);
			System.out.println("before balance-" +balance1);
			balance1=balance1-balance;
			System.out.println("after balance-" +balance1);
			System.out.println("--------------------------");
			PreparedStatement pstmt1=conn.prepareStatement("update bankuser set balance=? where accno=?");
			pstmt1.setDouble(1, balance1);
			pstmt1.setInt(2,accno);
			pstmt1.executeUpdate();
			System.out.println("withdraw cmplted");
			
			PreparedStatement pstmt2=conn.prepareStatement("insert into transactiondetails values(?,?,?)");
			pstmt2.setInt(1, accno);
			pstmt2.setString(2, s);
			pstmt2.setDouble(3, balance);
			pstmt2.executeUpdate();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return balance1;

		
	}
	public boolean changefind(int userid) {
		try {
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery("select * from loginbankuser");
			while(rs.next())
			{
				if(userid==rs.getInt(1))
				{
					return true;
				}
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}
	public void changepass(LoginBankUser s) {
		
		try {
			PreparedStatement pstmt=conn.prepareStatement("update loginbankuser set userpassword=? where userid=?");
			pstmt.setString(1,s.getUserpassword());
			pstmt.setInt(2,s.getUserid());
		
			pstmt.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	public double withrawmoney(int accno, double balance) {
		
	String s="withdraw";
		double balance1=0;
		try {
			PreparedStatement pstmt=conn.prepareStatement("select * from bankuser where accno=?");
			pstmt.setInt(1, accno);
			ResultSet rset =pstmt.executeQuery();
			rset.next();
			balance1=rset.getDouble(3);
			System.out.println("before balance-" +balance1);
			balance1=balance1-balance;
			System.out.println("after balance-" +balance1);
			System.out.println("--------------------------");
			PreparedStatement pstmt1=conn.prepareStatement("update bankuser set balance=? where accno=?");
			pstmt1.setDouble(1, balance1);
			pstmt1.setInt(2,accno);
			pstmt1.executeUpdate();
			
			PreparedStatement pstmt2=conn.prepareStatement("insert into transactiondetails values(?,?,?)");
			pstmt2.setInt(1, accno);
			pstmt2.setString(2, s);
			pstmt2.setDouble(3, balance);
			pstmt2.executeUpdate();
			System.out.println("deposite cmplted");
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return balance1;
	}
	public double withdrawmoney1(int accno, double balance) {
		
	String s="deposite";
		double balance2=0;
		try {
			PreparedStatement pstmt=conn.prepareStatement("select * from bankuser where accno=?");
			pstmt.setInt(1, accno);
			ResultSet rset =pstmt.executeQuery();
			rset.next();
			balance2=rset.getDouble(3);
			System.out.println("before balance-" +balance2);
			balance2=balance2+balance;
			System.out.println("after balance-" +balance2);
			
			PreparedStatement pstmt1=conn.prepareStatement("update bankuser set balance=? where accno=?");
			pstmt1.setDouble(1, balance2);
			pstmt1.setInt(2,accno);
			pstmt1.executeUpdate();
			
			PreparedStatement pstmt2=conn.prepareStatement("insert into transactiondetails values(?,?,?)");
			pstmt2.setInt(1, accno);
			pstmt2.setString(2, s);
			pstmt2.setDouble(3, balance);
			pstmt2.executeUpdate();
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return balance2;
	}
	public List<TransactionDetails> transactionDetails() 
	{
	    List<TransactionDetails> list=new ArrayList<TransactionDetails>();
			try {
				PreparedStatement pstmt=conn.prepareStatement("select * from transactiondetails");
				
				ResultSet rs=pstmt.executeQuery();
				while(rs.next())
				{					
				  
					list.add(new TransactionDetails(rs.getInt(1),rs.getString(2),rs.getDouble(3)));
				}
				
			
						
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return list;
	}

}



	

	


