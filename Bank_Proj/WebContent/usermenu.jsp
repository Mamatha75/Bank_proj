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
</head>
<body>
<center>

<header>

<h2> CUSTOMER MENU</h2>
</header>
<div class="nav">
<ul>
               <li> <a href="deposit.jsp"><h4>deposit money in Customer</h4></a></li>
				
				<li> <a href="transfer.jsp"><h4>transfer money from Customer </h4></a><li> 
				
			    <li> <a href="withdraw.jsp"><h4>withdraw money from Customer</h4></a><li> 
			     
				<li> <a href="checkbalance.jsp"><h4>check Balance</h4></a><li> 
				
				<li> <a href="c1"><h4>print minimum stmt</h4></a><li> 
				
				<li> <a href="changepass.jsp"><h4>change password</h4></a><li> 
							</ul>
</div>
				</center>
</body>
</html>