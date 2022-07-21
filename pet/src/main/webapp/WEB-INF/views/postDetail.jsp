<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<html class="h-100">
<c:import url="include/head.jsp">
    <c:param name="title" value="index"/>
</c:import>
<body class="d-flex flex-column h-100">
<c:import url="include/header.jsp"/>

<main class="flex-shrink-0">
    <div class="container">
        <div class="d-flex justify-content-between align-items-center">
            <h3><c:out value="${detail.postTitle}"/></h3>
            <p class="text-muted mb-0"><c:out value="${detail.postCreatedDate}"/></p>
        </div>
        <hr/>
        <div class="d-flex justify-content-between align-items-center">
            <div class="d-flex justify-content-between align-items-center">
                <img src="/resources/upload/<c:out value="${detail.postAuthorProfilePath}"/> " alt="..." style="border-radius:50%; width:50px; height:50px">
                <p class="mb-0 ms-3 fs-3"><c:out value="${detail.postAuthorId}"/></p>
            </div>
            <p class="mb-0">조회수 : <c:out value="${detail.postHit}"/></p>
        </div>

        <div class="mt-3">
            <img class="img-fluid mb-3" src="/resources/upload/<c:out value="${detail.postImgPath}"/>">
            <div>
                <c:out value="${detail.postContent}"/>
            </div>
        </div>

        <hr/>
        <div>
            <c:if test="${sessionScope.sessionDetail ne null}">
                <div class="d-flex justify-content-between mt-5 mb-5">
                    <c:choose>
                        <c:when test="${sessionScope.sessionDetail.accountSeq eq detail.postAuthorSeq}">
                            <div class="d-flex">
                                <form class="mb-0 me-3" action="/post/delete/<c:out value="${postSeq}"/>" method="post">
                                    <button type="submit" class="btn btn-outline-danger">삭제</button>
                                </form>
                                <a href="/post/edit/<c:out value="${postSeq}"/>" class="btn btn-outline-primary me-3">수정</a>
                            </div>
                        </c:when>
                        <c:otherwise>
                            <button type="button" class="btn btn-outline-success">쪽지</button>
                        </c:otherwise>
                    </c:choose>

                </div>
            </c:if>
        </div>
    </div>

</main>
<c:import url="include/footer.jsp"/>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>

</body>
</html>
