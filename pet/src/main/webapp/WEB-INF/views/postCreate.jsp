<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<html class="h-100">
<c:import url="include/head.jsp">
	<c:param name="title" value="index" />
</c:import>
<body class="d-flex flex-column h-100">
	<c:import url="include/header.jsp" />

	<main class="flex-shrink-0">
		<div class="container">
			
			<form method="post" action="/post/create" enctype="multipart/form-data">
			<div class="form-floating mb-3">
				<input type="text" class="form-control" id="floatingInput"
					placeholder="제목" name="postTitle"> <label
					for="floatingInput">제목</label>
			</div>

			<div class="form-floating mb-5">
				<textarea class="form-control" placeholder="Leave a comment here"
					id="floatingTextarea" name="postContent" rows="10" style="height: 300px"></textarea>
				<label for="floatingTextarea">내용</label>
			</div>
			
			<br/>
			
			<div class="mb-3">
				<label for="formFile" class="form-label">대표이미지</label> <input
					class="form-control" type="file" id="formFile" required accept="image/*"
					name="postImg">
			</div>

			<select class="form-select mb-3" aria-label="Default select example" name="postCategory">
				<option value="1">포유류</option>
				<option value="2">파충류</option>
				<option value="3">조류</option>
				<option value="4">기타</option>

			</select>
			
			<div class="d-flex justify-content-between">
				<button type="button" class="btn btn-outline-danger">취소</button>
				<button type="submit" class="btn btn-outline-primary">작성</button>
			</div>
			</form>
			


		</div>
	</main>
	<c:import url="include/footer.jsp" />
</body>
</html>
