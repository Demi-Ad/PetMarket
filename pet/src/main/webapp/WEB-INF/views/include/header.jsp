<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<header class="container">
    <div class="d-flex flex-wrap align-items-center justify-content-between py-3 mb-4 border-bottom">
        <a href="<c:url value="/"/>" class="d-flex align-items-center mb-2 mb-md-0 text-dark text-decoration-none">
            <img src="<c:url value="/resources/194279.png"/>" alt="icon" style="width: 50px"/>
        </a>

        <ul class="nav mb-2 justify-content-center mb-md-0">
            <li><a href="#" class="nav-link px-2 link-secondary">Home</a></li>
            <li><a href="#" class="nav-link px-2 link-dark">Features</a></li>
            <li><a href="#" class="nav-link px-2 link-dark">Pricing</a></li>
            <li><a href="#" class="nav-link px-2 link-dark">FAQs</a></li>
            <li><a href="#" class="nav-link px-2 link-dark">About</a></li>
        </ul>
        <c:choose>
            <c:when test="${sessionScope.sessionDetail eq null}">
                <div class="text-end">
                    <a href="<c:url value="/login"/>" type="button" class="btn btn-outline-primary me-2">Login</a>
                </div>
            </c:when>
            <c:otherwise>
                <div class="row">
                    <p class="mb-0 col-3"><c:out value="${sessionScope.sessionDetail.accountId}"/></p>
                    <img src="<c:out value="${sessionScope.sessionDetail.profilePath}"/>" class="col-6" alt="img" style="border-radius: 50%; width: 30px" >
                </div>
            </c:otherwise>
        </c:choose>

    </div>
</header>