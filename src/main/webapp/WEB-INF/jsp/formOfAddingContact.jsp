<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>добавление контактов</title>
</head>
<body>
	<div class="container-fluid" align="center">
		<h1>Добавление новой поставки</h1>
		<c:url var="saveUrl"
			value="/contactController/add?userId=${contactAttribute.user.userId }" />
		<form:form class="form-horizontal" modelAttribute="contactAttribute"
			method="POST" action="${saveUrl}">
			<table>
				<tr>
					<td><form:label class="control-label" path="user.userId"></form:label></td>
					<td style="display: none"><form:input path="user.userId" /></td>
				</tr>

				<tr>
					<td><form:label class="control-label" path="contactSurname">Фамилия</form:label></td>
					<td><form:input path="contactSurname" /></td>
				</tr>

				<tr>
					<td><form:label class="control-label" path="contactName">Имя</form:label></td>
					<td><form:input path="contactName" /></td>
				</tr>

				<tr>
					<td><form:label class="control-label" path="contactPatronymic">Отчество</form:label></td>
					<td><form:input path="contactPatronymic" /></td>
				</tr>

				<tr>
					<td><form:label class="control-label"
							path="contactMobilePhone">Мобильный телефон</form:label></td>
					<td><form:input path="contactMobilePhone" /></td>
				</tr>

				<tr>
					<td><form:label class="control-label" path="contactHomePhone">Домашний телефон</form:label></td>
					<td><form:input path="contactHomePhone" /></td>
				</tr>

				<tr>
					<td><form:label class="control-label" path="contactAddress">Адресс</form:label></td>
					<td><form:input path="contactAddress" /></td>
				</tr>

				<tr>
					<td><form:label class="control-label" path="contactEmail">E-mail:</form:label></td>
					<td><form:input path="contactEmail" /></td>
				</tr>

			</table>
			<br>
			<input value="Сохранить" input type="submit" class="btn btn-primary" />
		</form:form>
	</div>

</body>
</html>