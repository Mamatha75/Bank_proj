package com.dxc.dao;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.dxc.pojos.BankAdmin;
import com.dxc.pojos.BankUser;

public class AdminDaoImpl {
private static Connection conn;

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
	public boolean invalidAdmin(int adminid,String adminpassword) {
		
		 try
			{
          Statement stmt = conn.createStatement();
			 ResultSet rset = stmt.executeQuery("select * from bankadmin");
			 while(rset.next())
			    {
			   if(adminid==rset.getInt(1) && adminpassword.equals(rset.getString(2)))
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

	public void addUser(BankUser bu) {
		try {
			PreparedStatement pstmt=conn.prepareStatement("insert into bankuser values(?,?,?)");
			pstmt.setInt(1,bu.getAccno());
			pstmt.setString(2,bu.getName());
			pstmt.setDouble(3,bu.getBalance());
			pstmt.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	public boolean customerfind(int accno) {
		try {
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery("select * from bankuser");
			while(rs.next())
			{
				if(accno==rs.getInt(1))
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

	public void updatecust(BankUser s) {
		try {
			PreparedStatement pstmt=conn.prepareStatement("update bankuser set name=?, balance=? where accno=?");
			pstmt.setString(1, s.getName());
			pstmt.setDouble(2, s.getBalance());
			pstmt.setInt(3, s.getAccno());
			pstmt.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	public boolean removecustomer(int accno) {
		boolean status=false;
		try {
			PreparedStatement pstmt=conn.prepareStatement("delete from bankuser where accno=?");
			pstmt.setInt(1, accno);
			pstmt.execute();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return !status;
	}

	
	  public List<Integer> getcustbalance(int accno) {
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

	public boolean searchdetailsfind(int accno) {
		try {
			PreparedStatement stmt=conn.prepareStatement("select * from bankuser");
			ResultSet rs=stmt.executeQuery();
			while(rs.next())
			{
				if(accno==rs.getInt(1))
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

	public List<BankUser> searchdetails(int accno) {
		  System.out.println("search details"); 
		  List<BankUser> list = new ArrayList<>(); 
		  try {
			  PreparedStatement pstmt =conn.prepareStatement("select accno,name,balance from bankuser");
			 
		  ResultSet rset = pstmt.executeQuery();
		  System.out.println("---------------------------");
		  
		  while(rset.next()) {
				if(accno==rset.getInt(1)) {
					list.add(new BankUser(rset.getInt(1),rset.getString(2),rset.getDouble(3)));
				}
			  
			  }
		  
		  }
		     catch (Exception e) { 
		            e.printStackTrace();
		      } 
		  return list;
		  
		  
		  
		  
	}

	public List<BankUser> getAllUsers() {
		List<BankUser> list=new ArrayList<>();
		try {
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery("select * from BankUser");
			while(rs.next())
			{
				list.add(new BankUser(rs.getInt(1),rs.getString(2),rs.getDouble(3)));
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}


	
		
	}

	





	


