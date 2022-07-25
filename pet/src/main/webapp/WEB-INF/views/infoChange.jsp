<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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
        <div class="row g-5">

            <div class="d-flex align-items-start justify-content-between">
                <div class="nav flex-column nav-pills me-3" id="v-pills-tab" role="tablist" aria-orientation="vertical">
                    <button class="nav-link active" id="v-pills-home-tab" data-bs-toggle="pill" data-bs-target="#v-pills-id" type="button" role="tab" aria-controls="v-pills-home" aria-selected="true">프로파일 변경</button>
                    <button class="nav-link" id="v-pills-profile-tab" data-bs-toggle="pill" data-bs-target="#v-pills-password" type="button" role="tab" aria-controls="v-pills-profile" aria-selected="false">비밀번호 변경</button>
                </div>
                <div class="tab-content flex-fill ms-3" id="v-pills-tabContent">
                    <div class="tab-pane fade show active ms-3" id="v-pills-id" role="tabpanel" aria-labelledby="v-pills-home-tab">
                        <form method="post" enctype="multipart/form-data" action="<c:url value="/account/change/profile"/>">
                            <div class="input-group">
                                <input type="file" accept="image/*" name="profile" class="form-control" id="profileImg" required>
                                <button class="btn btn-outline-secondary" type="submit" id="profileBtn">변경</button>
                            </div>
                        </form>
                    </div>

                    <div class="tab-pane fade" id="v-pills-password" role="tabpanel" aria-labelledby="v-pills-profile-tab">

                        <form method="post" action="<c:url value="/account/change/password"/>">
                            <div class="input-group mb-3">
                                <label for="password" class="input-group-text">비밀번호 변경</label>
                                <input type="password" name="password" class="form-control" id="password" required>
                            </div>

                            <div class="input-group mb-3">
                                <label for="passwordCheck" class="input-group-text">비밀번호 확인</label>
                                <input type="password" name="passwordCheck" class="form-control" id="passwordCheck" required>
                            </div>
                            <div class="d-flex">
                                <button class="btn btn-outline-secondary flex-fill" type="submit" id="passwordBtn">변경</button>
                            </div>
                        </form>

                    </div>
                </div>
            </div>

        </div>
    </div>
</main>
<c:import url="include/footer.jsp"/>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<script src="<c:url value="/resources/js/infoChange.js"/>"></script>
</body>
</html>
