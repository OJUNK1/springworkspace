<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<sec:csrfMetaTags />
<title>Insert title here</title>
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.min.js"></script>
</head>
<body>
	<h1>톱 페이지입니다.</h1>
	<ul>
		<li><a href="user/user.jsp">일반 사용자용 페이지로</a></li>
		<sec:authorize access="hasRole('ROLE_ADMIN')">
			<li><a href="admin/admin.jsp">관리자 전용 페이지로</a></li>
		</sec:authorize>
	</ul>
	<sec:authorize access="isAuthenticated()">
		<form action="logout" method="post">
			<button>로그아웃</button>
		</form>
	</sec:authorize>
	<script>
		$.ajax('boardUpdate', {
			type:'post',
			contentType: 'application/json',
			data : JSON.stringify({'bno' : '002'}),
			beforeSend : function(xhr) {
				let header = $('meta[name="_csrf_header"]').attr('content');
				let token  = $('meta[name="_csrf"]').attr('content');
				
				xhr.setRequestHeader(header,token);
			}
		})
		.done(result => console.log(result))
		.fail(reject => console.log(reject));	
	</script>
</body>
</html>