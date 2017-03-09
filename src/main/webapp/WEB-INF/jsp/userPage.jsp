<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page contentType="text/html;charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Страница пользователя</title>
</head>
<body>

	<div class="container-fluid" align="center">
		<h3>Страница пользователя</h3>
		<table class="table">
			<thead style="background: #9AC0CD">
				<th>Дата поставки</th>
			</thead>
			<c:forEach items="${user}" var="searchList">
				<tr>
					<td><c:out value="${searchList.fullName}" /></td>
				</tr>
			</c:forEach>
		</table>
	</div>

</body>
</html>