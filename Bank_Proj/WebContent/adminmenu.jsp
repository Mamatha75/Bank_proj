<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
body{
font-family:times;

}
header{
color:blue;
padding:0px 10px;

}
div.nav ul{
list-style-type:none;


overflow:hidden;
}

.nav li a{
text-decoration:none;
padding:0px 0px;

color:black;
}
.nav a:hover{
color:red;

}
</style>
</head>

<body><center>
<header>

<h2> ADMIN MENU</h2>
</header>
<div class="nav">
<ul>

              <li> <a href="adduser.jsp"><h4>Add Customer</h4></a></li>
				
				<li> <a href="searchcust.jsp"><h4>Search Customer </h4></a></li>
				
			   <li>  <a href="updatecustfind.jsp"><h4>update Customer find</h4></a></li>
			     
				
				<li> <a href="getcustbal.jsp"><h4>Get Customer Balance</h4></a></li>
				
				<li> <a href="removecust.jsp"><h4>Delete Customer</h4></a></li>
				
				<li> <a href="cust"><h4>Show All Customers</h4></a></li>
				</ul>
</div>
</center>
</body>
</html>