<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 등록</title>
</head>
<body>
	<div align="center">
		<form name="insertForm" action="boardInsert" method="post">
			<table>
				<tr>
					<th>글번호</th>
					<td><input type="text" name="bno" value="${bno }" readonly></td>
				</tr>
				
				<tr>
					<th>제목</th>
					<td><input type="text" name="title"></td> <!-- 필수값에 required 설정 대신 js로-->
				</tr>
				<tr>
					<th>작성자</th>
					<td><input type="text" name="writer"></td> <!-- 필수값에 required 설정 대신 js로-->
				</tr>
				<tr>
					<th>내용</th>
					<td><textarea name="contents"></textarea></td>
				</tr>
				<tr>
					<th>첨부파일</th>
					<td><input type="text" name="image"></td>
				</tr>
			</table>
			<button type="button" onclick="location.href='boardList'">홈</button>
			<button type="button">등록</button>
		</form>
	</div>
	<script>
		$('[name="insertForm"]').on('submit', function(e) {
			e.preventDefault();
			
			let title = $('[name="title"]');
			let writer = $('[name="writer"]');
			
			if(title.val() == '') {
				alert('제목이 입력되지 않았습니다.');
				title.focus();
				return;
			}
			
			if(writer.val() == '') {
				alert('작성자가 입력되지 않았습니다.');
				writer.focus();
				return;
			}
			
			alert('게시글이 등록되었습니다.');
			insertForm.submit();
		})		
	</script>
</body>
</html>