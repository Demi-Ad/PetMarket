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
                    <a href="<c:url value="/login"/>" type="button" class="btn btn-outline-primary me-2">Login</a>
                </div>
            </c:when>
            <c:otherwise>
                <div class="d-flex">
                    <a class="btn btn-outline-info" href="<c:url value="/logout"/>">logout</a>
                    <a class="m-0 ms-3 me-3 btn btn-outline-success" href="<c:url value="/account/change"/>"><c:out value="${sessionScope.sessionDetail.accountId}"/></a>

                    <button class="btn btn-primary me-3" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasRight" aria-controls="offcanvasRight">쪽지</button>

                    <div class="offcanvas offcanvas-end" tabindex="-1" id="offcanvasRight" aria-labelledby="offcanvasRightLabel">
                        <div class="offcanvas-header">
                            <h5 id="offcanvasRightLabel">쪽지</h5>
                            <button type="button" class="btn-close text-reset" data-bs-dismiss="offcanvas" aria-label="Close"></button>
                        </div>
                        <div class="offcanvas-body" id="noteBody">
                            ...
                        </div>
                    </div>

                    <c:choose>
                        <c:when test="${sessionScope.sessionDetail.profilePath != null}">
                            <img src="/resources/upload/<c:out value="${sessionScope.sessionDetail.profilePath}"/>" alt="img" style="border-radius: 50%; width: 40px; height: 38px" >
                        </c:when>
                        <c:otherwise>
                            <img src="<c:url value="/resources/person.png"/>" alt="img" style="border-radius: 50%; width: 40px; height: 38px" >
                        </c:otherwise>
                    </c:choose>

                </div>
            </c:otherwise>
        </c:choose>
    </div>

    <c:if test="${note != null}">
        <div class="container p-0">
            <div class="alert alert-danger" role="alert">
                <c:out value="${note}"/>
            </div>
        </div>
    </c:if>

</header>

<script>
    function noteDelete(e) {
        const { id } = e.dataset;
        fetch("/noteDelete", {
            method: "POST",
            headers: {
                "Content-Type" : "application/json"
            },
            body: JSON.stringify({id})
        }).then(async res => {
            if (res.status === 200) {
                e.parentNode.parentNode.remove()
            } else {
                const {reason} = await res.json()
                throw new Error(reason)
            }
        }).catch(e => {
            alert(e)
        })
    }

    function drawData(noteList) {
        return noteList.map(data => {
            const {noteSeq, noteTitle, noteContent, senderId} = data
            return `
            <div class="card mb-3">
                <div class="card-header d-flex justify-content-between">
                    <p class="mb-0">\${senderId}</p>
                    <button type="button" onClick="noteDelete(this)" data-id="\${noteSeq}" class="btn-close text-reset" aria-label="Close"></button>
                </div>
                <div class="card-body">
                    <h5 class="card-title">\${noteTitle}</h5>
                    <p class="card-text">\${noteContent}</p>
                </div>
            </div>
        `
        }).join("")
    }

    document.querySelector("#offcanvasRight").addEventListener("show.bs.offcanvas", e => {
            fetch("/noteShow?accountSeq=<c:out value="${sessionScope.sessionDetail.accountSeq}"/>").then(async res => {
                if (res.status === 200) {
                    const data = await res.json()
                    document.querySelector("#noteBody").innerHTML = drawData(data)
                }
            })
        })
</script>
