<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page contentType="text/html;charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Страница пользователя</title>
</head>
<body>

	<table class="table">
		<thead style="background: #9AC0CD">
			<tr>
				<th>Пользователь</th>
			</tr>
		</thead>
		<tbody>
			
			<tr>
				<td><a href="${addContact}" input type="submit"
					class="btn btn-primary">Добавить контакт</a></td>
			</tr>
		</tbody>
	</table>
</body>
</html>