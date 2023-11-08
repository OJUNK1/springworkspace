<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 상세보기</title>
</head>

<body>
	<div align="center">
		<table>
			<tr>
				<th>번호</th>
				<td>${boards.bno }</td>
			</tr>
			<tr>
				<th>제목</th>
				<td>${boards.title }</td>
			</tr>
			<tr>
				<th>작성자</th>
				<td>${boards.writer }</td>
			</tr>
			<tr>
				<th>내용</th>
				<td width="2" height="3">${boards.contents }</td>
			</tr>
			<tr>
				<th>첨부파일</th>
				<c:choose>
					<c:when test="${not empty boards.image }">
						<td><img
							src="<c:url value="/resources/image/${boards.image }"/>"></td>
					</c:when>
					<c:otherwise>
						<td>${boards.image }</td>
					</c:otherwise>
				</c:choose>

			</tr>
			<tr>
				<th>작성일</th>
				<td><fmt:formatDate value="${boards.updatedate }"
						pattern="yyyy/MM/dd" /></td>
			</tr>
		</table>
		<button type="button" onclick="location.href='boardList'">홈</button>
		<button type="button" id="update"
			onclick="location.href='boardUpdate?bno=${boards.bno}'">수정</button>
		<button type="button" id="delete" onclick="location.href='boardDelete?bno=${boards.bno}'">삭제</button>
	</div>
</body>
</html>