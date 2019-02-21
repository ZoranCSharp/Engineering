<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CREATE OFFER</title>
</head>
<body style="background-color: red; color:yellow;">

<form action="${pageContext.request.contextPath}/docreate" method="post">
	<table border="1px" style="width:30%;" >
		<tr>
			<td>Id:</td>
			<td><input style="width:100%;" name="id" type="text"/><td>
		</tr>
		<tr>
			<td>Name:</td>
			<td><input style="width:100%;" name="name" type="text"/></td>
		</tr>
		<tr>
			<td>Email:</td>
			<td><input style="width:100%;" name="email" type="text"/></td>
		</tr>
		<tr>
			<td>Offer:</td>
			<td><input style="width:100%;" name="text" type="text"/></td>
		</tr>
		<tr>				
			<td><input style="width:100%;" type="submit" value="Create new offer"></td>			
		</tr>
	</table>
</form>

</body>
</html>