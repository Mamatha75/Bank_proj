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
<h2>TRANSACTION DETAILS</h2>

<table border="1" style="padding: 0px;">

<tr>
<th>AccountNumber</th>
<th>Account Type</th>
<th>Amount</th>

</tr>

<c:forEach var="TransactionDetails" items="${list}">
<table>
<tr>
<td><h5><c:out value="${TransactionDetails.getAccno()}"></c:out></h5></td>
<td><h5><c:out value="${TransactionDetails.getTransaction()}"></c:out></h5></td>
<td><h5><c:out value="${TransactionDetails.getTransactionbal()}"></c:out></h5></td>
</tr>
</table>
</c:forEach>
</body>
</html>