<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">

<title>Log in with your account</title>

<link href="${contextPath}/resources/css/bootstrap.min.css"
	rel="stylesheet">
<link href="${contextPath}/resources/css/common.css" rel="stylesheet">
</head>

<body>
	<h1>Log in</h1>

	<form role="form" action="/login" method="post">
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />

		<div>
			<label for="email">Email address</label> <input type="email"
				name="email" id="email" required autofocus />
		</div>
		<div>
			<label for="password">Password</label> <input type="password"
				name="password" id="password" required />
		</div>
		<div>
			<label for="remember-me">Remember me</label> <input type="checkbox"
				name="remember-me" id="remember-me" />
		</div>
		<button type="submit">Sign in</button>
		<h4 class="text-center">
			<a href="${contextPath}/user/create">Create an account</a>
		</h4>
	</form>

	<#if error.isPresent()>
	<p>The email or password you have entered is invalid, try again.</p>
	</#if>

</body>
</html>