<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>


<div class="modal fade" tabindex="-1" id="noteModal">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title">쪽지보내기</h5>
				<button type="button" class="btn-close" data-bs-dismiss="modal" id="modalClose"
					aria-label="Close"></button>
			</div>

			<div class="modal-body">
				<div class="mb-3">
					<label for="recipient" class="form-label">받는사람</label>
					<input type="text" class="form-control" id="recipient" value="${param.recipient}" disabled>
				</div>
				<div class="mb-3">
					<label for="noteTitle" class="form-label">제목</label>
					<input class="form-control" id="noteTitle">
				</div>
				
				<div class="mb-3">
					<label for="noteContent" class="form-label">내용</label>
					<textarea class="form-control" id="noteContent"
						rows="3"></textarea>
				</div>
				
			</div>
			<div class="modal-footer">
				<button type="button" id="noteBtn" class="btn btn-primary">전송하기</button>
			</div>
		</div>
	</div>
</div>
<script>
	document.querySelector("#noteBtn").addEventListener("click",(e) => {
		const recipientId = document.querySelector("#recipient").value
		const title = document.querySelector("#noteTitle").value
		const content = document.querySelector("#noteContent").value

		const body = {
			recipientId,
			title,
			content
		}

		if (recipientId && title && content) {
			fetch("/noteCreate",{
				method: "POST",
				headers: {
					"Content-Type":"application/json"
				},
				body: JSON.stringify(body)
			}).then(async res => {
				if (res.status === 200) {
					alert("정상적으로 전송 되었습니다")
					document.querySelector("#modalClose").click()
				} else {
					const reason = await res.json();
					throw new Error(reason);
				}
			}).catch(e => {
				alert(e.reason)
			})
		} else {
			alert("빈 칸이 존재합니다")
		}
	})
</script>
