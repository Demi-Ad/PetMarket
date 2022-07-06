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
                <div class="d-flex">
                    <a class="btn btn-outline-info" href="<c:url value="/logout"/>">logout</a>
                    <p class="m-0 ms-3 me-3 btn btn-outline-success"><c:out value="${sessionScope.sessionDetail.accountId}"/></p>
                    <c:choose>
                        <c:when test="${sessionScope.sessionDetail.profilePath eq not null}">
                            <img src="<c:out value="${sessionScope.sessionDetail.profilePath}"/>" alt="img" style="border-radius: 50%; width: 40px; height: 38px" >
                        </c:when>
                        <c:otherwise>
                            <img src="<c:url value="/resources/person.png"/>" alt="img" style="border-radius: 50%; width: 40px; height: 38px" >
                        </c:otherwise>
                    </c:choose>

                </div>
            </c:otherwise>
        </c:choose>

    </div>
</header>