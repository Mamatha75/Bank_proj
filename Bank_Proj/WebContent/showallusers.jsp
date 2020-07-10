<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
table,tr,td{
border:1px solid black;
width:40%;
text-align:center;
}
</style>
</head>
<body>
<center>
<c:forEach var="BankUser" items="${list}">
<table>
<tr>
<td><h5><c:out value="${BankUser.getAccno()}"></c:out></h5></td>
<td><h5><c:out value="${BankUser.getName()}"></c:out></h5></td>
<td><h5><c:out value="${BankUser.getBalance()}"></c:out></h5></td>
</tr>
</table>
</c:forEach>
</center>
</body>
</html>