<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Assignment 2 - Login</title>
</head>
<body>

	<h3>Login</h3>
	${errorMessage }
	<s:form method="post" namespace="/account" action="login">
		<s:textfield label="Username" name="account.username"></s:textfield>
		<s:password label="Password" name="account.password"></s:password>
		<s:submit value="Login" align="left"></s:submit>
	</s:form>

</body>
</html>