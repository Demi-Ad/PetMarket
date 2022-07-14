<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<html class="h-100">
<c:import url="../include/head.jsp">
    <c:param name="title" value="index"/>
</c:import>
<body class="d-flex flex-column h-100">
<c:import url="include/header.jsp"/>
<main class="flex-shrink-0 mt-5">
    <div class="container">
        <div class="row g-5">
            <div class="col-md-6 col-lg-8 offset-md-3 offset-lg-2">
                <h4 class="mb-3">회원가입</h4>
                <form class="needs-validation" id="form" action="<c:url value="/register"/>"
                      method="post" accept-charset="UTF-8"
                      enctype="multipart/form-data">
                    <div class="row g-3">

                        <div class="col-12">
                            <div class="input-group">
                                <label for="id" class="input-group-text">ID</label>
                                <input type="text" name="accountId" class="form-control" id="id" placeholder="아이디는 3글자 이상 20글자 이하입니다" required="">
                                <button class="btn btn-outline-secondary" type="button" id="checkId">확인</button>
                            </div>
                        </div>

                        <div class="col-12">
                            <label for="password" class="form-label">비밀번호</label>
                            <div class="input-group has-validation">
                                <input type="password" name="accountPassword" class="form-control" id="password" placeholder="비밀번호는 3글자 이상 20글자 이하입니다" required>
                            </div>
                        </div>

                        <div class="col-12">
                            <label for="passwordCheck" class="form-label">비밀번호 확인</label>
                            <div class="input-group has-validation">
                                <input type="password" class="form-control" id="passwordCheck" required>
                            </div>
                        </div>

                        <div class="col-12">
                            <div class="input-group">
                                <label for="email" class="input-group-text">Email</label>
                                <input type="email" name="accountEmail" class="form-control" id="email" placeholder="you@example.com">
                                <button class="btn btn-outline-secondary" type="button" id="emailCheck">확인</button>
                            </div>
                        </div>


                        <div class="col-12">
                            <label for="country" class="form-label">지역</label>
                            <select class="form-select" name="accountLocation" id="country" required>
                                <option>서울 특별시</option>
                            </select>
                        </div>

                        <div class="col-6">
                            <label for="questions" class="form-label">비밀번호 찾기 질문</label>
                            <select class="form-select" name="accountQuestions" id="questions" required>
                                <option>당신이 가장 존경하는 선생님은 누구입니까?</option>
                            </select>
                        </div>

                        <div class="col-6">
                            <label for="answer" class="form-label">비밀번호 찾기 답변</label>
                            <input class="form-control" name="accountAnswer" type="text" id="answer">
                        </div>

                    </div>
                    <hr class="my-4">

                    <div class="mb-3">
                        <label for="uploadImage" class="form-label">프로필 이미지</label>
                        <input class="form-control" type="file" accept="image/*" id="uploadImage" name="uploadImage">
                    </div>

                    <hr class="my-4">

                    <button class="w-100 btn btn-primary btn-lg" id="submitBtn" disabled type="submit">회원가입</button>
                </form>
            </div>
        </div>
    </div>
</main>
<c:import url="../include/footer.jsp"/>
<script src="resources/js/register.js"></script>
</body>
</html>
