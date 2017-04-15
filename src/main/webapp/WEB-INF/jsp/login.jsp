<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Login</title>
<link href="${contextPath}/resources/css/bootstrap.min.css"
	rel="stylesheet">
<link href="${contextPath}/resources/css/common.css" rel="stylesheet">
</head>
<body >
	<c:if test="${param.error ne null}">
		<div>Неверное имя пользователя и/или пароль.</div>
	</c:if>
	<c:if test="${param.logout ne null}">
		<div>You have been logged out.</div>
	</c:if>
	<form action="/login" method="post" class="form-signin">
		<div class="form-group" align = "center">
			<h4 class="form-signin-heading"> User Name : <input type="text" name="username"
				class="form-control" /></h4>
			
		</div>
		<div class="form-group" align = "center">
			<h4 class="form-signin-heading"> Password: <input type="password" name="password"
				class="form-control" /></h4>
			
		</div>
		<div class="form-group" align = "center">
			<input type="submit" value="Sign In" class="btn btn-primary" />
			</p>
			<a href="${contextPath}/registration">Create an account</a>
		</div>
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	</form>
</body>
</html>