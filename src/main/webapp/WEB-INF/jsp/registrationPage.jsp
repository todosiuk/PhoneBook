<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page contentType="text/html;charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Регистрация</title>
</head>
<body>
	<div class="form-group" align="center">
		<h1>Регистрация пользователя</h1>
		<c:url var="registrationUrl" value="/registrationController/saveUser"></c:url>
		<form:form class="form-horizontal" modelAttribute="userAttribute"
			method="POST" action="${registrationUrl}">
			<table>
				<tr>
					<td>Логин:</td>
					<td><input type="text" class="form-control" name="userLogin" /></td>
				</tr>
				<tr>
					<td>Пароль:</td>
					<td><input type="password" class="form-control"
						name="userPassword" /></td>
				</tr>
				<tr>
					<td>ФИО:</td>
					<td><input type="text" class=" form-control" name="fullName" /></td>
				</tr>
				<tr>
					<td align="right"><input name="submit"
						class="btn btn-primary btn-lg" type="submit" value="Регистрация" /></td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>