<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<a href="top">톱 페이지로</a><br>


<c:if test="${empty access_token }">
	<a href="loginForm">카카오 로그인</a>
</c:if>
<c:if test="${not empty access_token }">
	${nickName }님 <a href="logout">카카오 로그아웃</a>
</c:if>
</body>
</html>
