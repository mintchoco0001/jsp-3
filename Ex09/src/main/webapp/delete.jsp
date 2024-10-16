<%@page import="model1.board2.BoarderDTO"%>
<%@page import="model1.board2.BoarderDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="IsLogedIn.jsp"%>

<%
	String num = request.getParameter("num");
	BoarderDAO dao = new BoarderDAO(application);
	BoarderDTO dto = dao.selectView(num);
	
	String sessionId = (String)session.getAttribute("UserId");
	if(!sessionId.equals(dto.getId())){
		JSFunction.alertBack("작성자 본인만 삭제 가능합니다.", out);
		return;
		
	}else{
		dao.deletePost(num);
		JSFunction.alertLocation("게시글이 삭제되었습니다.", "List.jsp", out);
	}
	dao.close();
%>
