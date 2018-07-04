<%@ page contentType="text/html; charset=UTF-8 " pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style></style>
<title>Cadastro de nova operadora</title>
<link
	href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/memoriam.css"
	rel="stylesheet">
</head>
<body>
	<div class="container">
		<div class="jumbotron">
			<h2>
				Memori<i class="glyphicon glyphicon-phone"> </i>m
			</h2>
			<h3>Editando dados da operadora</h3>
			<mm:messages value="${msgs}" erroStyle="color:red" infoStyle="color:blue"/>
			<form action="${pageContext.request.contextPath}/controller.do"
				method="post" class="form-horizontal">
				<input type="hidden" name="op" value="cadope">
				<input type="hidden" name="id" value="${operadora.id}"> 
				<input type="text" id="nome" value="${operadora.nome}" name="nome" class="form-control" placeholder="Nome" /> 
			 <input  type="submit" class="btn btn-primary" value="Salvar">
				  <a href="/memoriam" class="btn btn-info">Cancelar</a>
			</form>
		</div>
	</div>
	<c:set var="endofconversation" value="true" scope="request" />
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>