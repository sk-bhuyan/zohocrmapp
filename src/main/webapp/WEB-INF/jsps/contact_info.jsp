<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Contact Info</title>
</head>
<body>
	<h2>Contact Details</h2>
	First Name : ${contact.firstName}<br>
	Last Name : ${contact.lastName}<br>
	Email : ${contact.email}<br>
	Mobile : ${contact.mobile}<br>
	Source : ${contact.source}<br>
	
	<form action="sendEmail" method="post">
		<input type="hidden" name="email" value="${contact.email}"/>
		<input type="submit" value="Send Email"/>
	</form>
	
	<form action="convertlead" method="post">
		<input type="hidden" name="id" value="${lead.id}"/>
		<input type="submit" value="convert"/>
	</form>
</body>
</html>