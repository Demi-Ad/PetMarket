<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<html class="h-100">
<c:import url="include/head.jsp">
    <c:param name="title" value="index"/>
</c:import>
<body class="d-flex flex-column h-100">
<c:import url="include/header.jsp"/>
<main class="flex-shrink-0 mt-5">
    <div class="container">

        <div class="d-flex align-items-start justify-content-between">
            <div class="nav flex-column nav-pills me-3" id="v-pills-tab" role="tablist" aria-orientation="vertical">
                <button class="nav-link active" id="v-pills-home-tab" data-bs-toggle="pill" data-bs-target="#v-pills-id" type="button" role="tab" aria-controls="v-pills-home" aria-selected="true">아이디찾기</button>
                <button class="nav-link" id="v-pills-profile-tab" data-bs-toggle="pill" data-bs-target="#v-pills-password" type="button" role="tab" aria-controls="v-pills-profile" aria-selected="false">비밀번호찾기</button>
            </div>
            <div class="tab-content flex-fill" id="v-pills-tabContent">
                <div class="tab-pane fade show active ms-3" id="v-pills-id" role="tabpanel" aria-labelledby="v-pills-home-tab">
                    <div class="input-group">
                        <label for="emailInput" class="input-group-text">Email</label>
                        <input type="text" name="accountId" class="form-control" id="emailInput" required>
                        <button class="btn btn-outline-secondary" type="button" id="findEmailBtn">찾기</button>
                    </div>
                    <p class="text-muted mt-1">가입하신 이메일을 입력해주세요</p>

                    <div id="idResult">

                    </div>
                </div>

                <div class="tab-pane fade" id="v-pills-password" role="tabpanel" aria-labelledby="v-pills-profile-tab">
                    <div class="ms-3">
                        <div class="row">
                            <div class="input-group">
                                <label for="idInput" class="input-group-text">ID</label>
                                <input type="text" name="accountId" class="form-control" id="idInput" required>
                            </div>

                            <div class="col-6 mt-3">
                                <label for="questions" class="form-label">비밀번호 찾기 질문</label>
                                <select class="form-select" name="questions" id="questions" required>
                                    <option>당신이 가장 존경하는 선생님은 누구입니까?</option>
                                </select>
                            </div>

                            <div class="col-6 mt-3">
                                <label for="answer" class="form-label">비밀번호 찾기 답변</label>
                                <input class="form-control" name="answer" type="text" id="answer">
                            </div>
                            <div class="col-12">
                                <button class="btn btn-outline-primary mt-3" id="passwordBtn">임시 비밀번호 생성</button>
                            </div>
                        </div>
                        <div id="passwordResult" class="d-flex justify-content-center">

                        </div>
                    </div>

                </div>
            </div>
        </div>

    </div>
</main>
<c:import url="include/footer.jsp"/>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<script src="<c:url value="/resources/js/forgot.js"/>"></script>
</body>
</html>
