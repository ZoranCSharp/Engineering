<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>OFFERS</title>
</head>
<body style="background-color: red; color: yellow;">

	<c:forEach var="offer" items="${offers}">
		<p style="text-align: center;">
			<c:out value="${offer}"></c:out>
	</c:forEach>


	<a href="${pageContext.request.contextPath}/"> <br /> <br />
		<br /> <br /> <br />
		<button
			style="width: 200px; height: 100px; margin-left: 5%; background-color: yellow; color: black;">Back</button></a>



</body>
</html>