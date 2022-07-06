<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>


<div class="modal fade" tabindex="-1" id="exampleModal">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title">쪽지보내기</h5>
				<button type="button" class="btn-close" data-bs-dismiss="modal"
					aria-label="Close"></button>
			</div>

			<div class="modal-body">
				<div class="mb-3">
					<label for="exampleFormControlInput1" class="form-label">받는사람</label>
					<input type="email" class="form-control" id="recipient" value=<c:out value=${param.recipient}/>>
				</div>
				<div class="mb-3">
					<label for="exampleFormControlTextarea1" class="form-label">제목</label>
					<textarea class="form-control" id="exampleFormControlTextarea1"
						rows="3"></textarea>
				</div>
				
				<div class="mb-3">
					<label for="exampleFormControlTextarea1" class="form-label">내용</label>
					<textarea class="form-control" id="exampleFormControlTextarea1"
						rows="3"></textarea>
				</div>
				
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-primary">전송하기</button>
			</div>
		</div>
	</div>
</div>
