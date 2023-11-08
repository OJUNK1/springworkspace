<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정</title>
</head>

<body>
	<div align="center">
		<form>
			<table>
				<tr>
					<th>번호</th>
					<td><input type="text" name="bno" value="${boards.bno }" readonly></td>
				</tr>
				<tr>
					<th>제목</th>
					<td><input type="text" name="title" value="${boards.title }"></td>
				</tr>
				<tr>
					<th>작성자</th>
					<td><input type="text" name="writer" value="${boards.writer }"></td>
				</tr>
				<tr>
					<th>내용</th>
					<td><textarea name="contents">${boards.contents }</textarea></td>
				</tr>
				<tr>
					<th>첨부파일</th>
					<td><input type="text" name="image" value="${boards.image }"></td>
				</tr>
				<tr>
					<th>수정일</th>
					<!-- input type가 date 일 때, 바꾸는법 -->
					<td><input type="date" name="updatedate"
						value='<fmt:formatDate value="${boards.updatedate }" pattern="yyyy-MM-dd" />'></td>
				</tr>
			</table>
			<button type="button"
				onclick="location.href='boardInfo?bno=${boards.bno}'">취소</button>
			<button type="button" id="updateBtn">수정</button>
		</form>
	</div>
	<script>
		$('#updateBtn').on('click', updateBoard);
		
		function updateBoard(e) {
			let updateData = getBoardInfo();
			
			$.ajax('boardUpdate', {
				type : 'post',
				contentType : 'application/json',
				data : JSON.stringify(updateData)				
			})
			.done(result => {
				if(result['result']) {
					alert('정상적으로 수정되었습니다.');
				} else {
					alert('입력한 데이터를 확인해주세요.');
				}
			})
			.fail(reject => console.log(reject));
		}
		
		function getBoardInfo() {
			let formData = $('form').serializeArray(); //serializeArray() ->  form 요소들(input, textarea, select)을 이름을 key로, 값을 value로 하는 배열로 인코딩 !! 배열임..

			let formObj = {};

			$.each(formData, function (idx, obj) {
				// 각 입력태그 -> 하나의 필도로 변환
				formObj[obj.name] = obj.value;   // 넘어온 배열의 name 속성이 필드의 값이 되어야 하기 때문에 formObj[obj.name]	
			});

			return formObj;
		}
	</script>
</body>
</html>