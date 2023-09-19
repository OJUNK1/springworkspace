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
		<button type="button" id="selectDelete">선택삭제</button>
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
					<%-- <tr onclick="location.href='empInfo?employeeId=${emp.employeeId}'"> --%>
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


					$('tbody > tr').on('click', function (e) {
						if (e.target.tagName != 'TD') return; // target = 실제 이벤트가 발생한 대상. 실제 이벤트가 발생한 대상이 td가 아닌 경우 동작하지 않음. 함수 안에서 return은 강제 종료를 의미

						//let empId = e.currentTarget.firstElementChild.nextElementSibling.textContent;
						let empId = $(e.currentTarget).find('td:eq(1)').text(); // e.currentTarget : tbody > tr.
						location.href = 'empInfo?employeeId=' + empId;
					});

					// 단건 삭제
					<!-- $('button:contains("삭제")');  text 값에 "삭제" 가 있는 건을 다 들고 옴. -->
					$('tr button').on('click', empInfoDel); // > 은 자식요소를 찾을 때 사용. button은 td의 자식이므로 tr button으로 하는 것.

					function empInfoDel(event) {
						let trTag = event.currentTarget.closest('tr');      // handler가 등록되는 곳이 tr button임. 따라서 button - currentTarget
						let empId = $(trTag).children().eq(1).text();       //  closest = 현재 위치에서 가장 가까운 element 하나만 찾아내는 것

						$.ajax('empDelete?employeeId=' + empId)
							.done(result => {
								console.log(result);

								// 화면에서 삭제 대상을 바로 지우는 방법.
								let deletedId = result.list[0]; // result는 배열로 넘어옴.
								$('tbody > tr > td:nth-of-type(2)').each(function (idx, tag) { // 모든 행의 두번째값을 가져오는 태그가 $('tbody > tr > td:nth-of-type(2)')
									if (tag.textContent == deletedId) {
										$(tag).parent().remove(); // $(tag).parent() = tr
									}
								})
							})
							.fail(reject => console.log(reject));
					};

					// 선택 삭제
					$('#selectDelete').on('click', empListDelete);

					function empListDelete(event) {
						// 선택한 사원번호를 가지는 배열
						let empIdList = getEmpList();
						// ajax
						$.ajax('empDelete', {
							type: 'post',
							contentType: 'application/json',
							data: JSON.stringify(empIdList)
						})
							.done(result => {
								location.href='empList'; // 이러한 방식으로 강제로 empList 페이지로 전환. 비동기통신 ajax 쓰는 의미 퇴색. 
							})
							.fail(reject => console.log(reject));
					}

					function getEmpList() { //*****  [] -> 속성attribute검사할 때 사용
						let checkedTag = $('tbody input[type="checkbox"]:checked');

						let empList = [];
						checkedTag.each(function(idx, inTag) {
							let empId = $(inTag).parent().next().text(); // next = 바로 다음. inTag.parent() = td
							empList.push(empId);
						});
						
						return empList;
					};
				</script>
</body>

</html>