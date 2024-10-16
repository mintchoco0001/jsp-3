<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
int num1 = 3;
pageContext.setAttribute("num2", 4);
pageContext.setAttribute("num3", "5");
pageContext.setAttribute("num4", "8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>변수 출력</h3>
	<h3>스크립틀릿에 선언한 변수 : ${num1}</h3>
	<h3>페이지 영역에 저장한 변수 : ${num2}</h3>
	<h3>변수 할당 및 출력 : ${num1=7}</h3>


	num1=${num1 }, num2=${num2 }, num3=${num3 }, num4=${num4 }


	<h3>산술 연산자</h3>
	<h3>num1 + num2 : ${num1 + num2 }</h3>
<%-- 	<h3>num1 + 문자 : ${num1 + "삽입" }</h3> --%>

<h3>비교 연산자</h3>
<h3>num4>num3 : ${num4 gt num3}</h3>
</body>
</html>