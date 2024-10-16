<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*"%>
    <%@ page import="common.Lunch"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		List<Object> lunch = new ArrayList<Object>();
	lunch.add(new Lunch("볶음밥", 7000));
	lunch.add(new Lunch("탕수육", 30000));
	session.setAttribute("Menu", lunch);
	%>
	
	<ul>
		<li>메뉴 1 : ${Menu[0].menu }, ${Menu[0].price }</li>
		<li>메뉴 2 : ${Menu[1].menu }, ${Menu[1].price }</li>
	</ul>
</body>
</html>