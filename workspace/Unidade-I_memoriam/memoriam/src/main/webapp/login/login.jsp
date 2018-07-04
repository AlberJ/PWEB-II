<%@ page contentType="text/html; charset=UTF-8 " pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<title>Memoriam</title>
<link
	href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/bootstrap/css/login.css"
	rel="stylesheet">
</head>
<body style="background-color: black;">
	<div class="container" style="background-color:white; border-radius:7px; width: 20%; text-align: center; border-style:solid; border-width: 1px; position: absolute; left: 40%; top: 20%;">
		<form action="${pageContext.request.contextPath}/controller.do?op=login"
			method="post">
			
			<h2 class="form-signin-heading">
				Memori<i class="glyphicon glyphicon-phone"></i>m
			</h2>
			<label for="inputEmail" class="sr-only">Usuário</label> <input
				type="email" name="login" id="login" class="form-control"
				placeholder="Email" required autofocus> <label
				for="inputPassword" class="sr-only">Senha</label> <input
				type="password" id="senha" name="senha" class="form-control"
				placeholder="senha" required>
			<button class="btn btn-lg btn-primary btn-block" type="submit">Entrar</button>
		</form>
	</div>
</body>
</html>