<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<header class="container">

    <div class="d-flex flex-wrap align-items-center justify-content-between py-3 mb-4 border-bottom">
        <a href="<c:url value="/"/>" class="d-flex align-items-center mb-2 mb-md-0 text-dark text-decoration-none">
            <img src="<c:url value="/resources/194279.png"/>" alt="icon" style="width: 50px"/>
        </a>

        <div>
            <h3 class="mb-0">동물 분양 사무소</h3>
        </div>

	<c:choose>
		<c:when test="${sessionScope.sessionDetail eq null}">
			<div class="text-end">
				<a href="<c:url value="/login"/>" type="button"
					class="btn btn-outline-primary me-2">Login</a>
			</div>
		</c:when>
		<c:otherwise>
			<div class="d-flex">
				<a class="btn btn-outline-info" href="<c:url value="/logout"/>">logout</a>
				<a class="m-0 ms-3 me-3 btn btn-outline-success"
					href="<c:url value="/account/change"/>"><c:out
						value="${sessionScope.sessionDetail.accountId}" /></a>
				<c:choose>
					<c:when test="${sessionScope.sessionDetail.profilePath != null}">
						<img
							src="/resources/upload/<c:out value="${sessionScope.sessionDetail.profilePath}"/>"
							alt="img" style="border-radius: 50%; width: 40px; height: 38px">
					</c:when>
					<c:otherwise>
						<img src="<c:url value="/resources/person.png"/>" alt="img"
							style="border-radius: 50%; width: 40px; height: 38px">
					</c:otherwise>
				</c:choose>

                </div>
            </c:otherwise>
        </c:choose>
    </div>

    <c:if test="${note != null}">
        <div class="container">
            <div class="alert alert-danger" role="alert">
                <c:out value="${note}"/>
            </div>
        </div>
    </c:if>

</header>