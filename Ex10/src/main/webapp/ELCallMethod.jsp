<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="common.MyELClass"%>
<%
	MyELClass myclass = new MyELClass();
	pageContext.setAttribute("myclass", myclass);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>당신의 성별은? ${myclass.getGender("201225-3564544") }</h3>
	
	<h3> 구구단 출력하기</h3>
	${MyELClass.showGugudan(9)}
</body>
</html>