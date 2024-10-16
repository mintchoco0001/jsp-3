<%@page import="model1.board2.BoarderDTO"%>
<%@page import="model1.board2.BoarderDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="IsLogedIn.jsp"%>

<%
String num = request.getParameter("num");
String title = request.getParameter("title");
String content = request.getParameter("content");

BoarderDTO dto = new BoarderDTO();
dto.setNum(num);
dto.setTitle(title);
dto.setContent(content);

BoarderDAO dao = new BoarderDAO(application);
int affected =dao.updateEdit(dto);
dao.close();

if(affected == 1){
	response.sendRedirect("View.jsp?num="+dto.getNum());
}else{
	JSFunction.alertBack("수정하기에 실패하였습니다.", out);
}


%>
