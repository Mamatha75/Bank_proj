package com.dxc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dxc.pojos.BankAdmin;
import com.dxc.pojos.BankUser;
import com.dxc.service.AdminServiceImpl;

@WebServlet("/cust")
public class AdminServlet extends HttpServlet {
	AdminServiceImpl adminservice = new AdminServiceImpl();

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// response.getWriter().println("aaa");
		String message;
		String action = "";
		String temp = request.getParameter("btn");
		if (temp != null)
			action = request.getParameter("btn");
		HttpSession session = request.getSession();
		if (action.equals("admin_login")) {
			int adminid = Integer.parseInt(request.getParameter("adminid"));
			String adminpassword = request.getParameter("adminpassword");

			boolean b = adminservice.invalidAdmin(adminid, adminpassword);
			session.setAttribute("adminid", adminid);
			session.setAttribute("adminpassword", adminpassword);
			if (b == true) {

				/*
				 * message="admin login successfully!"; session.setAttribute("message",
				 * message);
				 */
				response.sendRedirect("adminmenu.jsp");
			} else {
				message = "admin login unsuccessfully!";
				session.setAttribute("message", message);
				response.sendRedirect("view.jsp");
			}
		} else if (action.equals("add_user")) {
			int accno = Integer.parseInt(request.getParameter("accno"));
			String name = request.getParameter("name");
			double balance = Double.parseDouble(request.getParameter("balance"));
			BankUser bu = new BankUser(accno, name, balance);
			adminservice.addUser(bu);
			/*
			 * session.setAttribute("accno", accno); session.setAttribute("name", name);
			 * session.setAttribute("balance", balance);
			 */

			message = "add user successfully!";
			session.setAttribute("message", message);
			response.sendRedirect("view.jsp");
		} 
		
		  else if (action.equals("updatecustfind")) 
		  { int accno =Integer.parseInt(request.getParameter("accno"));
		  session.setAttribute("accno", accno);
		   boolean find =adminservice.customerfind(accno); 
		   if (find == true) {
		  response.sendRedirect("updatecust.jsp");
		   } 
		   else 
		   {
		    message = "Student not found!"; 
		    session.setAttribute("message", message);
		  response.sendRedirect("view.jsp"); 
		  } } 
		 else if (action.equals("updatecust"))
		 { 
		 int accno = (int) session.getAttribute("accno"); 
		  String name =request.getParameter("name");
		  double balance =Double.parseDouble(request.getParameter("balance")); 
		  BankUser s = new BankUser(accno, name, balance);
		    adminservice.updatecust(s); 
		   message = "customer updated!"; 
		   session.setAttribute("message", message);
		 response.sendRedirect("view.jsp"); }
		
	else if (action.equals("getbalance")) {
			
			  int accno=Integer.parseInt(request.getParameter("accno")); 
			  List<Integer> list=adminservice.getcustbalance(accno); 
			  session.setAttribute("list",list);
			  response.sendRedirect("displaybalance.jsp");
		}

		else if (action.equals("remove")) {
			int accno = Integer.parseInt(request.getParameter("accno"));
			// session.setAttribute("accno",accno);
			boolean removestatus = adminservice.removecustomer(accno);
			if (removestatus == true) {
				message = "customer Removed!";
			} else {
				message = "customer not present!";
			}
			message = "customer Removed!";
			session.setAttribute("message", message);
			response.sendRedirect("view.jsp");
		}
		else if(action.equals("searchfind")) {
			
			 int accno = Integer.parseInt(request.getParameter("accno"));
			// session.setAttribute("accno", accno); 
			 boolean b = adminservice.searchdetailsfind(accno); 
			 if (b == true) { 
				
			     List<BankUser> list=adminservice.searchdetails(accno);
			     session.setAttribute("list",list);
			    
			    response.sendRedirect("searchdetails.jsp");
			     }
			 else { 
				 message = "search  unsuccessfully!";
				 session.setAttribute("message", message);
				    response.sendRedirect("view.jsp");
			 }
			
			 }
		else {
			List<BankUser> list=adminservice.getAllUsers();
			session.setAttribute("list", list);
			response.sendRedirect("showallusers.jsp");
			
			
		}
		}
		
		}
	

