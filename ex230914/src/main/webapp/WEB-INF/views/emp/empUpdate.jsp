<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원 정보 수정</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
</head>
<body>
	<form>
		<!-- ajax 사용하므로 form action, method 필요 없음. -->
		<div>
			<label>employee_id : <input type="number" name="employeeId"
				value="${empInfo.employeeId }" readonly></label>
		</div>
		<div>
			<label>first_name : <input type="text" name="firstName"
				value="${empInfo.firstName }"></label>
		</div>
		<div>
			<label>last_name : <input type="text" name="lastName"
				value="${empInfo.lastName }" readonly></label>
		</div>
		<div>
			<label>email : <input type="text" name="email"
				value="${empInfo.email }"></label>
		</div>
		<div>
			<label>hire_date : <input type="date" name="hireDate"
				value="${empInfo.hireDate }" readonly></label>
		</div>
		<div>
			<label>salary : <input type="number" name="salary"
				value="${empInfo.salary }"></label>
		</div>
		<button type="button">수정</button>
		<button type="reset">취소</button>
	</form>
</body>
<script>
	$('form:eq(0)').on('submit', function(e) {
			
	$.ajax('empUpdate', {
			type : 'post',
			contentType : 'application/json',
			data : JSON.stringfy()
		})
		.done(data => {
			console.log(data);
		})
		.fail(reject => console.log(reject));
	});
</script>
</html>