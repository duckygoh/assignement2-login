<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Assignment 2 - Welcome!</title>
</head>
<body>

	<h3>Successful login</h3>
	Welcome ${sessionScope.username }
	<br>
	<s:a namespace="/account" action="logout">Logout</s:a>

</body>
</html>