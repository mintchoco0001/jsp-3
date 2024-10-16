<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model1.board2.BoarderDTO"%>
<%@ page import="model1.board2.BoarderDAO"%>

<%
String num = request.getParameter("num");
BoarderDAO dao = new BoarderDAO(application);
dao.updateVisitCount(num);
BoarderDTO dto = dao.selectView(num);
dao.close();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="Common/Link.jsp" />

	<h1>회원제 게시판 - 상세보기</h1>

	<form action="WriteProcess">
		<input type="hidden" name="num" value="<%=num%>">
		<table border="1" width="90%">
			<tr>
				<td>번호</td>
				<td><%=dto.getPostdate()%></td>
				<td>작성자</td>
				<td><%=dto.getId()%></td>
			</tr>
			<tr>
				<td>작성일</td>
				<td><%=dto.getPostdate()%></td>
				<td>조회수</td>
				<td><%=dto.getVisitcount()%></td>
			</tr>
			<tr>
				<td>제목</td>
				<td colspan="1"><%=dto.getTitle()%></td>
			</tr>
			<tr>
				<td>내용</td>
				<td colspan="3" height="100"><%=dto.getContent()%></td>
			</tr>
			<tr>
				<td colspan="4" align="center">
					<%
					if (session.getAttribute("UserId") != null 
					&& session.getAttribute("UserId").toString().equals(dto.getId())) {
					%>
					<button type="button"
						onclick="location.href='Edit.jsp?num=<%=dto.getNum()%>';">수정하기</button>
					<button type="button" onclick="location.href='delete.jsp?num=<%=dto.getNum()%>';">삭제하기</button> <%
 }
 %>
					<button type="button" onclick="location.href='List.jsp'">목록보기</button>
				</td>
			</tr>

		</table>
	</form>

</body>
</html>