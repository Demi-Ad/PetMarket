<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<html>
<c:import url="include/head.jsp">
	<c:param name="title" value="index"/>
</c:import>
<body>
<h1>
	Hello world!  
</h1>
<P>  The time on the server is ${model}. </P>
</body>
</html>
