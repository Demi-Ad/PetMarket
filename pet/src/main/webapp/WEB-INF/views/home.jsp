<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
		<c:import url="include/nav.jsp"/>
		
		<h1>
			Hello world!
		</h1>
		<P>  The time on the server is ${model}. </P>
	</div>
</main>
<c:import url="include/footer.jsp"/>
</body>
</html>
