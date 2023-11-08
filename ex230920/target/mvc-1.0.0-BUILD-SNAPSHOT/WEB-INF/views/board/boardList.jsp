<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>

<head>
<meta charset="UTF-8">
<title>게시판 목록</title>
</head>

<body>
	<div align="center">
		<table>
			<thead>
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>작성일</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${boards }" var="b">
					<tr>
						<td>${b.bno }</td>
						<td>${b.title }</td>
						<td>${b.writer }</td>
						<td><fmt:formatDate value="${b.regdate }"
								pattern="yyyy년MM월dd일" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<script>
		// 		$('tbody > tr').on('click', selectBoardInfo);     <<<<<<<<<<<<<<<<  JQUERY  >>>>>>>>>>>>>>>>> 

		// 		function selectBoardInfo() {
		// 			let boardNo = $(this).children().first().text();
		// 			location.href = 'boardInfo?bno=' + boardNo;
		// 		}

		document.querySelectorAll('tbody > tr').forEach(function(tag) {
			tag.addEventListener('click', function(e) {
				let bno = e.currentTarget.firstElementChild.textContent;

				location.href = 'boardInfo?bno=' + bno;
			})
		})
	</script>
</body>

</html>