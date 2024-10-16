<%@page import="membership.memberDTO"%>
<%@page import="membership.memberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
String userId = request.getParameter("user_id");
String userPwd = request.getParameter("user_pw");

String oracleDriver = application.getInitParameter("OracleDriver");
String oracleURL = application.getInitParameter("OracleURL");
String oracleId = application.getInitParameter("OracleId");
String oraclePw = application.getInitParameter("OraclePw");

memberDAO dao = new memberDAO(oracleDriver, oracleURL, oracleId, oraclePw);
memberDTO memberDTO = dao.getMemberDTO(userId, userPwd);
dao.close();

if (memberDTO.getId() != null) {
	session.setAttribute("UserId", memberDTO.getId());
	session.setAttribute("UserName", memberDTO.getName());
	response.sendRedirect("LoginForm.jsp");
} else {
	request.setAttribute("LoginErMsg", "로그인 오류입니다.");
	request.getRequestDispatcher("LoginForm.jsp").forward(request, response);
}
%>