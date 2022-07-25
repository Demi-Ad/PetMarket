<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="navbar navbar-expand-lg navbar-light" style="background-color: #e3f2fd;">
    <div class="container-fluid">
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarColor03"
                aria-controls="navbarColor03" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarColor03">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="<c:url value="/post/category/mammalia"/>">포유류</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value="/post/category/reptile"/>">파충류</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value="/post/category/birds"/>">조류</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value="/post/category/default"/>">기타</a>
                </li>
            </ul>
            <form class="d-flex mb-0" action="<c:url value="/search"/>" method="get">
                <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search" name="keyword" value="${param.search != null ? param.search : ''}">
                    <button class="btn btn-outline-primary" type="submit">Search</button>
            </form>
        </div>
    </div>
</nav>