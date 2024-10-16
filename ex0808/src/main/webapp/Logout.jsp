<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	// 세션 제거 1번째 방법 : 직접 삭제하는 방법
	session.removeAttribute("UserId");
	session.removeAttribute("UserName");
	
	// 세션 제거 2번째 방법 : 전체 세션 삭제하는 방법
	session.invalidate();
	
	response.sendRedirect("LoginForm.jsp");
%>