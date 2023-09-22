<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
		<div>   <!-- 날짜 처리 방법 -->
			<label>hire_date : <input type="date" name="hireDate" 
				value='<fmt:formatDate value="${empInfo.hireDate }" pattern="yyyy-MM-dd" />' readonly></label>
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
		// ajax 요즘 많이 쓰는 ajax 방식.  보낼 데이터를 꺼내는 방법 등, 별도의 함수를 적극적으로 사용해서 분리하기. 
		$('form > button[type="button"]').on('click', empUpdateHandler);

		function empUpdateHandler(event) {
			// 보낼 데이터
			let objData = getEmpInfo();
			for (let field in objData) { // for in을 사용하는 경우 객체 내부의 순환을 이루고 싶을 때, 무조건 사용. for in 에는 대괄호[]를 사용. 배열은 for of, 기본 for문 사용이 가능함.
				console.log(objData[field]);     // 1)변수에 필드명을 담아서 사용하는 경우, 
				// console.log(objData.employeeId); // 2)필드명을 문자열로 접근해야하는 경우: 특수문자사용(-), 영어를 제외한 한글 / objData.employeeId = objData['employeeId']
			}

			$.ajax('empUpdate', {
				type: 'post',
				contentType: 'application/json',
				data: JSON.stringify(objData)
			})
				.done(result => { // .done = .success, done 은 연속적으로 사용이 가능. 
					let message = '결과: ' + result['결과'] + ', ' + ', 대상 사원번호: ' + result['사원번호'];
					alert(message);
					console.log(message);
				})
				.fail(reject => console.log(reject)); // .fail = .error
		}

		function getEmpInfo() {
			let formData = $('form').serializeArray(); //serializeArray() ->  form 요소들(input, textarea, select)을 이름을 key로, 값을 value로 하는 배열로 인코딩 !! 배열임..

			let formObj = {};

			$.each(formData, function (idx, obj) {
				formObj[obj.name] = obj.value;   // 넘어온 배열의 name 속성이 필드의 값이 되어야 하기 때문에 formObj[obj.name]	
			})

			return formObj;
		}
	</script>

</html>