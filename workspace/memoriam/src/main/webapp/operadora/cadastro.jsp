<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<title>Memoriam - Cadastro de Operadora</title>
<link
	href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/memoriam.css"
	rel="stylesheet">
</head>
<body>
 	<c:import url="../template/header.jsp" />

	<div class="container">
		<br>
		<div class="jumbotron">
		
			<c:if test="${not empty _msg}">
				<c:forEach var="_m" items="${_msg}">
					<div class="alert alert-danger">${_m}</div>
				</c:forEach>
			</c:if>
			
			<h2>
				Memori<i class="glyphicon glyphicon-phone"></i>m
			</h2>
			<h3>Dados da Operadora</h3>
			<form action="${pageContext.request.contextPath}/controller.do"
				method="POST" class="form-horizontal">
				<input type="hidden" name="op" value="cadoper"> 
				<input type="hidden" name="id" value="${operadora.id}"> 
				<input id="nome" value="${operadora.nome}" name="nome" type="text" class="form-control" placeholder="Nome" /> 
				<input id="fone" value="${operadora.prefixo}" name="prefixo" class="form-control" type="text" placeholder="Prefixo" />
				<input type="submit" class="form-control btn btn-primary"
					value="Salvar">
			</form>
		</div>
	</div>
	
	<c:import url="../template/footer.jsp" />
	<c:set var="endofconversation" value="yes" scope="request"/>

</body>
</html>