<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="common.Person"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		List<Object> aList = new ArrayList<Object>();
		aList.add("청해진");
		aList.add(new Person("장보고",28));
		pageContext.setAttribute("Ocean", aList);
	%>
	<ul>
		<li>첫번째 요소 : ${ Ocean[0]}</li>
		<li>두번째 요소 : ${ Ocean[1].name}, ${Ocean[1].age}</li>

	</ul>

</body>
</html>