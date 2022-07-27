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
        <c:import url="include/nav.jsp">
            <c:param name="search" value="${keyword}"/>
        </c:import>

        <c:choose>
            <c:when test="${pagingData.data.size() eq 0}">
                <h6>자료가 없습니다</h6>
            </c:when>
            <c:otherwise>
                <div class="row row-cols-1 row-cols-md-5 g-4 mt-5">
                    <c:forEach items="${pagingData.data}" var="data">
                        <div class="col">
                            <div class="card">
                                <img src="/resources/upload/<c:out value="${data.postImgPath}"/>" class="card-img-top"
                                     alt="...">
                                <div class="card-body">
                                    <a href="/post/<c:out value="${data.postSeq}"/>" class="card-title fs-4">
                                        <p class="text-truncate mb-0">${data.postTitle}</p>
                                    </a>
                                    <p class="card-text"><c:out value="${data.postContent}"/></p>
                                    <div class="d-flex justify-content-between align-items-center">
                                        <p class="mb-0"><c:out value="${data.accountId}"/></p>
                                        <img src="/resources/upload/<c:out value="${data.accountImagePath}"/>"
                                             style="border-radius: 50%; width: 20px; height: 20px">
                                    </div>

                                </div>
                                <div class="card-footer">
                                    <small class="text-muted"><c:out value="${data.postCreatedDate}"/></small>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>

                <nav class="mt-5 d-flex justify-content-center ">
                    <ul class="pagination">
                        <li class="page-item <c:out value="${pagingData.firstPage ? 'disabled' : ''}"/>">
                            <a class="page-link" href="?pageNum=${pagingData.currentPage - 1}&keyword=${keyword}"> < </a>
                        </li>

                        <c:forEach begin="${pagingData.currentStartPage}" end="${pagingData.currentLastPage}" var="i">
                            <li class="page-item <c:if test="${i eq pagingData.currentPage}">active</c:if>">
                                <a class="page-link" href="?pageNum=${i}&keyword=${keyword}"><c:out value="${i}"/></a>
                            </li>
                        </c:forEach>

                        <li class="page-item <c:out value="${pagingData.lastPage ? 'disabled' : ''}"/>">
                            <a class="page-link" href="?pageNum=${pagingData.currentPage +1}&keyword=${keyword}">></a>
                        </li>
                    </ul>
                </nav>
            </c:otherwise>
        </c:choose>
    </div>

</main>
<c:import url="include/footer.jsp"/>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>

</body>
</html>
