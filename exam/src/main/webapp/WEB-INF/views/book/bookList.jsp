<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서 조회</title>
<style>
table, th, td {
	border: 1px solid black;
}
</style>
</head>
<body>
	<div align="center">
		<h2 style="margin: 20px;">도서 조회/수정</h2>
		<table>
			<thead>
				<tr>
					<th width="120px">도서번호</th>
					<th width="250px">도서명</th>
					<th width="80px">표지</th>
					<th width="150px">출판일자</th>
					<th width="120px">금액</th>
					<th width="120px">출판사</th>
					<th width="400px">도서소개</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${books }" var="b">
					<tr>
						<td>${b.bookNo }</td>
						<td>${b.bookName }</td>
						<td><img style="width:50px; height:50px;"
							src="<c:url value="/resources/images/${b.bookCoverImg }"/>"></td>
						<td><fmt:formatDate value="${b.bookDate }"
								pattern="yyyy/MM/dd" /></td>
						<td><fmt:formatNumber value="${b.bookPrice }" pattern="#,###" /></td>
						<td>${b.bookPublisher }</td>
						<td>${b.bookInfo }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>