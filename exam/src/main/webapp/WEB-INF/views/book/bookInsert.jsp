<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table, th, td {
	border: 1px solid black;
}

th {
	background-color: aqua;
	width: 100px;
	text-align: center;
}
</style>
</head>
<body>
	<div align="center">
		<form name="insertForm" action="bookInsert" method="post">
			<table border="1" style="width: 800px;">
				<tr>
					<th>도서번호</th>
					<td><input type="text" name="bookNo" value="${bookNo }"
						style="width:300px;" readonly></td>
				</tr>

				<tr>
					<th>도서명</th>
					<td><input type="text" name="bookName" style="width:300px;"></td>

				</tr>
				<tr>
					<th>도서표지</th>
					<td><input type="text" name="bookCoverImg" style="width:500px;"></td>
				</tr>
				<tr>
					<th>출판일자</th>
					<td><input type="text" name="bookDate" style="width:300px;" placeholder="yyyy/MM/dd"></td>
				</tr>
				<tr>
					<th>금액</th>
					<td><input type="text" name="bookPrice" style="width:300px;"></td>
				</tr>
				<tr>
					<th>출판사</th>
					<td><input type="text" name="bookPublisher" style="width:300px;"></td>
				</tr>
				<tr>
					<th>도서소개</th>
					<td><textarea name="bookInfo" rows="4" cols="50"></textarea></td>
				</tr>
			</table>
			<div style="margin: 15px;">
			<button type="submit">등록</button>
			<button type="button" onclick="location.href='bookList'">조회</button>
			</div>
		</form>
	</div>

	<script>
		$('[name="insertForm"]').on('submit', function(e) {
			e.preventDefault();

			let bookName = $('[name="bookName"]');

			if (bookName.val() == '') {
				alert('도서명이 입력되지 않았습니다.');
				bookName.focus();
				return;
			}

			alert('도서등록이 완료 되었습니다.');
			insertForm.submit();
		})
	</script>
</body>
</html>