<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전체 사원 명단</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
</head>
<body>
	<div align="center">
		<table>
			<thead>
				<tr>
					<th>Check</th>
					<th>employee_id</th>
					<th>first_name</th>
					<th>last_name</th>
					<th>email</th>
					<th>hire_date</th>
					<th>job_id</th>
					<th>salary</th>
					<th>Delete</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${empList }" var="emp">
					<%--  <tr onclick="location.href='empInfo?employeeId=${emp.employeeId}'" >  --%>
					<tr>
						<td><input type="checkbox"></td>
						<td>${emp.employeeId }</td>
						<td>${emp.firstName }</td>
						<td>${emp.lastName }</td>
						<td>${emp.email }</td>
						<td><fmt:formatDate value="${emp.hireDate }"
								pattern="yyyy-MM-dd" /></td>
						<td>${emp.jobId }</td>
						<td>${emp.salary }</td>
						<td><button type="button">삭제</button></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

	<script>
		let message = [
						<c:forEach begin="1" end="5">
							`${result}`, // `` 안에 ${result} 하면 자바스크립트에서 el태그 사용 가능함.
						</c:forEach>
					];
		
		if(message.length > 0) alert(message.toString());
	
		$('tbody > tr').on('click', function(e) {
			if(e.target.tagName != 'TD') return; // target = 실제 이벤트가 발생한 대상. 실제 이벤트가 발생한 대상이 td가 아닌 경우 동작하지 않음. 함수 안에서 return은 강제 종료를 의미
			
		  //let empId = e.currentTarget.firstElementChild.nextElementSibling.textContent;
			let empId = $(e.currentTarget).find('td:eq(1)').text(); // e.currentTarget : tbody > tr.
			location.href = 'empInfo?employeeId=' + empId;
			
		});
	</script>
</body>
</html>