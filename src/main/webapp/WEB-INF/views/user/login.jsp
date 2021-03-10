<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 확인 페이지</title>
<style>
	#userId{margin-left:15px}
</style>
</head>
<body>
	<c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION }">
		<font color="red">
			${SPRING_SECURITY_LAST_EXCEPTION }
			<c:remove var="SPRING_SECURITY_LAST_EXCEPTION" scope="session"/>
		</font>
	</c:if>
	<form action="login" method="post" id="frm">
			<h3>로그인 페이지</h3>
			아이디: <input type="text" name="id" id="userId"><br>
			비밀번호: <input type="text" name="password">
		<p>
		<button>로그인</button>&nbsp;&nbsp;
		<button>취소</button>
	</form>
<h3>카카오 로그인</h3>
<a href="https://kauth.kakao.com/oauth/authorize?response_type=code&client_id=0b594fc45bb5f0d24a765caaced28b1c&redirect_uri=http://localhost/bank/callback">카카오 로그인</a>
</body>
</html>