<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=utf-8"%>

<html>
<head>
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">
<title>Login Page</title>
</head>
<body>
	<div class="form-group" align="center">
		<h3>Вход</h3>
		<c:url var="loginUrl" value="/enter"></c:url>
		<form action="${loginUrl}" method="POST">
			<table>
				<tr>
					<td>Логин:</td>
					<td><input type='text' class="form-control" name='userLogin' /></td>
				</tr>
				<tr>
					<td>Пароль:</td>
					<td><input type='password' class="form-control"
						name='userPassword' /></td>
				</tr>
				<tr>
					<td align="right"><input name="submit"
						class="btn btn-primary btn-lg" type="submit" value="Вход" /></td>
					<td align="right"><a
						href="<c:url value="/registrationController/registrationPage"/>">Регистрация</a></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>
