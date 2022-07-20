<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<header class="container">

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
							<p class="m-0 ms-3 me-3 btn btn-outline-success">
								<c:out value="${sessionScope.sessionDetail.accountId}" />
							</p>
							<c:choose>
								<c:when
									test="${sessionScope.sessionDetail.profilePath eq not null}">
									<img
										src="<c:out value="${sessionScope.sessionDetail.profilePath}"/>"
										alt="img"
										style="border-radius: 50%; width: 40px; height: 38px">
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
			</c:otherwise>
			
		</c:choose>
		
	</div>
	
	<c:if test="note != null">
						</div>
					</c:otherwise>
				</c:choose>
			</div>
		</c:otherwise>
	</c:choose>


	<c:if test="${not empty note}">
		<div class="container">
			<div class="alert alert-danger" role="alert">
				<c:out value="${note}"></c:out>
			</div>
		</div>
	</c:if>
</header>