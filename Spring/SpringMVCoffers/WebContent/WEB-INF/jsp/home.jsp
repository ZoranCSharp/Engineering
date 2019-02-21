<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>HOME</title>
</head>
<body style="background-color: red; color:yellow;">
	<h1 style="text-align:center;">
		HELLO WORLD!
	</h1>	
	<a  href="${pageContext.request.contextPath}/offers"><button style="width:200px;height:100px;margin-left:43.5%;background-color: yellow; color:black;">Show</button></a>
	<br/>
	<br/>
	<br/>
	<br/>
	<br/>
	<br/>
	<a  href="${pageContext.request.contextPath}/createoffer"><button style="width:200px;height:100px;margin-left:43.5%;background-color: yellow; color:black;">Create Offer</button></a>
</body>
</html>