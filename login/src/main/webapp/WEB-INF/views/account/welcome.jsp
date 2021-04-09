<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Assignment 2 - Welcome!</title>
<style>
body {
	margin-top: 20px;
	text-align: center;
}

.button {
	border: none;
	color: white;
	padding: 15px 32px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 16px;
	margin: 4px 2px;
	cursor: pointer;
	background-color: #4CAF50;
	margin-top: 30px;
}

p {
	margin-top: 50px;
}
</style>
</head>
<body>
	<h3>Successful login</h3>
	<p>Welcome to Group 26 Assignment 2</p>
	<button class="button">
		<s:a namespace="/account" action="logout"
			style="text-decoration: none; color:white;">Logout</s:a>
	</button>

</body>
</html>