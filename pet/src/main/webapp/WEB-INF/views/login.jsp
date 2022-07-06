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
        <form class="col-6 offset-3" action="<c:url value="/login"/>" method="post">
            <h1 class="h3 mb-3 fw-normal">Please Log in</h1>

            <div class="form-floating mb-3">
                <input type="text" name="id" class="form-control" id="id" placeholder="name@example.com">
                <label for="id">ID</label>
            </div>
            <div class="form-floating mb-3">
                <input type="password" name="password" class="form-control" id="floatingPassword" placeholder="Password">
                <label for="floatingPassword">Password</label>
            </div>

            <button class="w-100 btn btn-lg btn-primary mb-3" type="submit">Log in</button>
            <a href="<c:url value="/register"/>" class="w-100 btn btn-lg btn-info mb-3" type="submit">Sign in</a>
            <a href="/forgot">아이디 · 비밀번호 찾기</a>
        </form>
    </div>

</main>
<c:import url="include/footer.jsp"/>
</body>
</html>
