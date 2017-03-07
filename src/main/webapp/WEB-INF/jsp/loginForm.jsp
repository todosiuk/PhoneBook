<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=utf-8"%>

<html>
<head>
	<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">
<title>Login Page</title>
</head>
<body>
	<div class="container-fluid">
		<h3>Вход</h3>
		<c:url var="loginUrl" value="/login"></c:url>
		<form action="${loginUrl}" method="POST">
			<table>
				<tr>
					<td>Логин:</td>
					<td><input type='text' class="form-control" name='username' /></td>
				</tr>
				<tr>
					<td>Пароль:</td>
					<td><input type='password' class="form-control"
						name='password' /></td>
				</tr>
				<tr>
					<td><input name="submit" class="btn btn-primary btn-sm"
						type="submit" value="Вход" /></td>
					<td><input name="submit" class="btn btn-primary btn-sm"
						type="submit" value="Регистрация" /></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>
