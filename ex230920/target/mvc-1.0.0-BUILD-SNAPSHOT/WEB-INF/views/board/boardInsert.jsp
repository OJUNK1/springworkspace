<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
.dz-message:hover {
	background: #e9ecef;
}

.dz-message {
	text-align: center;
	padding: 1.5rem;
	display: block;
	font-size: .875rem;
	font-weight: 500;
	opacity: 1;
	cursor: pointer;
	border-radius: 0.5rem;
	background: #fff;
	border: 1px dashed #dee2e6;
	transition: all .35s ease;
	color: rgba(108, 117, 125, 0.5);
}

button:not(:disabled), [type="button"]:not(:disabled), [type="reset"]:not(:disabled),
	[type="submit"]:not(:disabled) {
	cursor: pointer;
}

.btn-options {
	color: #6c757d;
	padding: 0;
	background: none;
	border: none;
	cursor: pointer;
	display: flex;
	align-items: center;
}

a {
	color: #007bff;
	text-decoration: none;
	background-color: transparent;
}

.list-group-activity span {
	margin-right: 0.25rem;
}

.text-small {
	font-size: .875rem;
	line-height: 1.3125rem;
}

}
html, body {
	color: #2C2C2C;
	font-size: 15px;
	letter-spacing: -.01em;
}

.flex-column, body, .card--summary__theme-action, .hero, .profile__hero
	{
	-webkit-box-orient: vertical !important;
	-webkit-box-direction: normal !important;
	-ms-flex-direction: column !important;
	flex-direction: column !important;
}
</style>
<meta charset="UTF-8">
<title>게시글 등록</title>
</head>
<body>
	<div align="center">
		<div class="col">
			<ul class="d-none dz-template">
				<li class="list-group-item dz-preview dz-file-preview">
					<div class="media align-items-center dz-details">
						<ul class="avatars">
							<li>
								<div class="avatar bg-primary dz-file-representation">
									<i class="material-icons">attach_file</i>
								</div>
							</li>
							<li><img alt="David Whittaker"
								src="assets/img/avatar-male-4.jpg" class="avatar"
								data-title="David Whittaker" data-toggle="tooltip"></li>
						</ul>
						<div
							class="media-body d-flex justify-content-between align-items-center">
							<div class="dz-file-details">
								<a href="#" class="dz-filename"> <span data-dz-name=""></span>
								</a> <br> <span class="text-small dz-size" data-dz-size=""></span>
							</div>
							<img alt="Loader" src="assets/img/loader.svg" class="dz-loading">
							<div class="dropdown">
								<button class="btn-options" type="button" data-toggle="dropdown"
									aria-haspopup="true" aria-expanded="false">
									<i class="material-icons">more_vert</i>
								</button>
								<div class="dropdown-menu dropdown-menu-right">
									<a class="dropdown-item" href="#">Download</a> <a
										class="dropdown-item" href="#">Share</a>
									<div class="dropdown-divider"></div>
									<a class="dropdown-item text-danger" href="#" data-dz-remove="">Delete</a>
								</div>
							</div>
							<button class="btn btn-danger btn-sm dz-remove" data-dz-remove="">
								Cancel</button>
						</div>
					</div>
					<div class="progress dz-progress">
						<div class="progress-bar dz-upload" data-dz-uploadprogress=""></div>
					</div>
				</li>
			</ul>
			<form class="dropzone dz-clickable"
				action="https://mediumra.re/dropzone/upload.php">
				<span class="dz-message">Drop files here or click here to
					upload</span>
			</form>


		</div>
		<form name="insertForm" action="boardInsert" method="post">
			<table>
				<tr>
					<th>글번호</th>
					<td><input type="text" name="bno" value="${bno }" readonly></td>
				</tr>

				<tr>
					<th>제목</th>
					<td><input type="text" name="title"></td>
					<!-- 필수값에 required 설정 대신 js로-->
				</tr>
				<tr>
					<th>작성자</th>
					<td><input type="text" name="writer"></td>
					<!-- 필수값에 required 설정 대신 js로-->
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

			if (title.val() == '') {
				alert('제목이 입력되지 않았습니다.');
				title.focus();
				return;
			}

			if (writer.val() == '') {
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