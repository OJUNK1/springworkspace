<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원 정보 조회</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
</head>
<body>
	<div>
		<form action="getEmp" method="">
			<!--form action은 mapping annotation, 즉 @GetMapping("getEmp") 중 getEmp이다. -->
			<label>사원번호<input type="number" name="employeeId"></label>
			<button type="submit">검색</button>
		</form>
	</div>
	<div>
		<table>
			<tr>
				<th>사원번호</th>
				<td>${empInfo.employeeId }</td>
			</tr>
			<tr>
				<th>이름</th>
				<td>${empInfo.lastName }</td>
			</tr>
			<tr>
				<th>업무</th>
				<td>${empInfo.jobId }</td>
			</tr>
		</table>
	</div>
	<hr>
	<form>
		<table>
			<tr>
				<th>성</th>
				<td><input type="text" name="lastName"></td>
			</tr>
			<tr>
				<th>이메일</th>
				<td><input type="text" name="email"></td>
			</tr>
			<tr>
				<th>입사일</th>
				<td><input type="text" name="hireDate"></td>
			</tr>
			<tr>
				<th>업무</th>
				<td><input type="text" name="jobId"></td>
			</tr>
		</table>
		<button type="submit">등록</button>
	</form>
	<script>
		$('form:eq(1)').on('submit', function(e) {
			e.preventDefault(); // a 태그나 submit 태그는 누르게 되면 href 를 통해 이동하거나 , 창이 새로고침하여 실행됩니다. preventDefault 를 통해 이러한 동작을 막아줄 수 있습니다.
			
		let formData = $('form:eq(1)').serializeArray(); //JSON 문자열로 인코딩할 준비가 된 객체의 JavaScript 배열을 만듭니다.
		});
		
		/*
			Event Object 
			- 메소드
			1) preventDefault() : 해당 이벤트에 기본으로 설정된 동작을 막음. ex) form 태그 submit, a 태그 클릭
			2) stopPropagation() : 이벤트 버블링을 막음. 캡처링 : DOM 구조에서 이벤트를 위에서부터 찾아가는 것 , 버블링 : 이벤트가 실제 발생하고 그 흐름이 역으로 다시 올라가는 것
								   즉, 하위요소에서 발생한 이벤트가 위로 쭉 올라가는 것. tr 이벤트 - td - th - table - body - html 까지..
								   ex) tr 태그 안에 checkbox가 있는 경우. 각 tr이 checkbox 있을 때. ??????????????????????
			- 필드
			1) target
			2) currentTarget
		*/
	</script>
</body>
</html>