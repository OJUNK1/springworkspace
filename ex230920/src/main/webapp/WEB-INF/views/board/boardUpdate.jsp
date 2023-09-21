<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
	<div align="center">
		<form>
			<table>
				<tr>
					<th>번호</th>
					<td><input type="text" value="${boards.bno }"></td>
				</tr>
				<tr>
					<th>제목</th>
					<td><input type="text" value="${boards.title }"></td>
				</tr>
				<tr>
					<th>작성자</th>
					<td><input type="text" value="${boards.writer }"></td>
				</tr>
				<tr>
					<th>내용</th>
					<td><input type="text" value="${boards.contents }"></td>
				</tr>
				<tr>
					<th>수정일</th>
					<td><fmt:formatDate value="${boards.updatedate }"
							pattern="yyyy년MM월dd일" /></td>
				</tr>
			</table>
			<button type="button" onclick="location.href='boardList'">홈</button>
			<button type="button" id="update">수정</button>
		</form>
	</div>
	<script>
		$('#update').on('click', updateBoard);
		
		function updateBoard(e) {
			let objData = getBoardInfo();
			for (let field in objData) {
				console.log(objData[field]);
			}
			
			$.ajax('boardUpdate', {
				type : 'post',
				contentType : 'application/json',
				data : JSON.stringify(objData)				
			})
			.done(result => {
				alert(result);
			})
			.fail(reject => console.log(reject));
		}
		
		function getBoardInfo() {
			
		}
	</script>
</body>
</html>