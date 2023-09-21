<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서대여</title>
<style>
table, th, td {
	border: 1px solid black;
}
</style>
</head>
<body>
<div align="center">
		<h2 style="margin: 20px;">도서별 대여매출현황</h2>
		<table>
			<thead>
				<tr style="text-align: center;">
					<th width="120px">도서번호</th>
					<th width="250px">도서명</th>
					<th width="80px">대여총계</th>
					<th width="150px">대여횟수</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${rents }" var="r">
					<tr>
						<td style="text-align: center;">${r.bookNo }</td>
						<td>${r.bookName }</td>
						<td style="text-align: right;">${r.priceAll }</td>
						<td style="text-align: right;">${r.rentAll }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>