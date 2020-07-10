package com.dxc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dxc.pojos.BankUser;
import com.dxc.pojos.LoginBankUser;
import com.dxc.pojos.TransactionDetails;
import com.dxc.service.AdminServiceImpl;
import com.dxc.service.UserServiceImpl;

@WebServlet("/c1")
public class UserServlet extends HttpServlet {
	Scanner sc=new Scanner(System.in);
	UserServiceImpl userservice = new UserServiceImpl();
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String message;
		String action = "";
		String temp = request.getParameter("btn");
		if (temp != null)
			action = request.getParameter("btn");
		HttpSession session = request.getSession();
		
		if (action.equals("userlogin")) {
			System.out.println("hello");
			int userid = Integer.parseInt(request.getParameter("userid"));
			String userpassword = request.getParameter("userpassword");
            boolean b = userservice.invalidUser(userid, userpassword);
			session.setAttribute("userid", userid);
			session.setAttribute("userpassword", userpassword);
			if (b) {
                 response.sendRedirect("usermenu.jsp");
			} else {
				message = "user login unsuccessfully!";
				session.setAttribute("message", message);
				response.sendRedirect("view.jsp");
			}
		}
		else if(action.equals("deposite")) {
			int accno = Integer.parseInt(request.getParameter("accno"));
			double balance = Double.parseDouble(request.getParameter("balance"));
		double bal=userservice.deposit(accno,balance);
		PrintWriter pw=response.getWriter();
		pw.println("after deposit balance is=" +bal);
		
		}
		else if(action.equals("withdraw")) {
			int accno = Integer.parseInt(request.getParameter("accno"));
			double balance = Double.parseDouble(request.getParameter("balance"));
		double bal=userservice.withdraw(accno,balance);
		PrintWriter pw=response.getWriter();
		pw.println("after deposit balance is=" +bal);
		
		}
		else if(action.equals("check")) {
			 int accno=Integer.parseInt(request.getParameter("accno")); 
			 List<Integer> list=userservice.checkbal(accno);
			 session.setAttribute("list",list);
			  response.sendRedirect("displaybalance.jsp");
			 
		}
		 else if (action.equals("changepass")) 
		  { System.out.println("cahnge pass");
			 int userid =Integer.parseInt(request.getParameter("userid"));
		  session.setAttribute("userid", userid);
		   boolean find =userservice.changefind(userid); 
		   if (find == true) {
		  response.sendRedirect("changepass1.jsp");
		   } 
		   else 
		   {
		    message = "user not found!"; 
		    session.setAttribute("message", message);
		  response.sendRedirect("view.jsp"); 
		  } } 
		 else if (action.equals("changepass1"))
		 { 
			 System.out.println("cahnge passmmmmmmmm");
		 int userid = (int) session.getAttribute("userid"); 
		  String userpassword =request.getParameter("userpassword");
		
		  LoginBankUser s = new LoginBankUser(userid, userpassword);
		  userservice.changepass(s); 
		   message = "password updated!"; 
		   session.setAttribute("message", message);
		 response.sendRedirect("view.jsp"); 
		 
		 }
	else if(action.equals("transfermoney")){
		int accno = Integer.parseInt(request.getParameter("accno"));
		double balance = Double.parseDouble(request.getParameter("balance"));
		session.setAttribute("balance", balance);
	double bal=userservice.withrawmoney(accno,balance);
	
	  PrintWriter pw=response.getWriter(); 
	  pw.println("  withdraw balance is=" +bal);
	 System.out.println("moneyyyy");
	  response.sendRedirect("transfer1.jsp"); 
	 }
	 else if (action.equals("transfermoney1"))
	 { 
		
	  int accno = Integer.parseInt(request.getParameter("accno"));
	  double balance=(double)session.getAttribute("balance");
		double bal=userservice.withdrawmoney1(accno,balance);
		PrintWriter pw=response.getWriter();
		pw.println("transfer balance is=" +bal);
		
		}
	 else {
		
		 List<TransactionDetails> list=userservice.transactionDetails();
		 session.setAttribute("list", list);
		
		 response.sendRedirect("transactiondetails.jsp");
			System.out.println("---------------------");
	 }
		 
	 }
	}
		
		
	  
	



