<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
pageContext.setAttribute("num1", 9);
pageContext.setAttribute("num2", "10");
pageContext.setAttribute("nullStr", null);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>num1+num2 : ${num1+num2 }</h3>
	<h3>nullStr + 10 : ${ nullStr+10 }</h3>
</body>
</html>