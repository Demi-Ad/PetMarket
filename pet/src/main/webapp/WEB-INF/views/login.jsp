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
        <form class="col-6 offset-3">
            <h1 class="h3 mb-3 fw-normal">Please Log in</h1>

            <div class="form-floating mb-3">
                <input type="email" class="form-control" id="floatingInput" placeholder="name@example.com">
                <label for="floatingInput">Email address</label>
            </div>
            <div class="form-floating mb-3">
                <input type="password" class="form-control" id="floatingPassword" placeholder="Password">
                <label for="floatingPassword">Password</label>
            </div>

            <button class="w-100 btn btn-lg btn-primary mb-3" type="submit">Log in</button>
            <button class="w-100 btn btn-lg btn-info" type="submit">Sign in</button>
        </form>
    </div>
</main>
<c:import url="include/footer.jsp"/>
</body>
</html>
