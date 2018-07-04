<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="tt" tagdir="/WEB-INF/tags/templating"%>
<%@ taglib prefix="mm" tagdir="/WEB-INF/tags/messages"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
	<title>Login Memoriam</title>
	<link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/css/login.css" rel="stylesheet">
</head>
<body>
<div class="container">
<form class="form-signin" action="${pageContext.request.contextPath}/controller.do?op=login" method="POST">
	<h2 class="form-signin-heading">Memori<i class="glyphicon glyphicon-phone"></i>m</h2>
	<label for="inputEmail" class="sr-only">Usuário</label> 
	<input type="email" name="login" id="login" class="form-control" value="${cookie['loginCookie'].value}" placeholder="Email" required autofocus>
	<label for="inputPassword" class="sr-only">Senha</label>
	<input type="password" id="senha" name="senha" class="form-control" placeholder="Senha" required>
	<div class="checkbox">
		<label>
		<input type="checkbox" value="sim" id="lembrar" name="lembrar"> Lembrar-me </label>
	</div>
	<button class="btn btn-lg btn-primary btn-block" type="submit">Entrar</button>
</form>
</div>
</body>
</html>
