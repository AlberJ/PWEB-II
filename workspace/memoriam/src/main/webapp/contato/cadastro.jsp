<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<title>Memoriam - Cadastro de Contato</title>
<link href="${pageContext.request.contextPath}/css/memoriam.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
 	<c:import url="../template/header.jsp" />

	<div class="container">
		<div class="jumbotron">
			<c:if test="${not empty _msg}">
				<c:forEach var="_m" items="${_msg}">
					<div class="alert alert-danger">${_m}</div>
				</c:forEach>
			</c:if>
			
			<h2>
				Memori<i class="glyphicon glyphicon-phone"></i>m
			</h2>
			<h3>Dados do Contato</h3>
			<form action="${pageContext.request.contextPath}/controller.do"
				method="POST" class="form-horizontal">
				<input type="hidden" name="op" value="cadctt"> 
				<input type="hidden" name="id" value="${contato.id}"> 
				<input id="nome" value="${contato.nome}" name="nome" type="text" class="form-control" placeholder="Nome" /> 
				<input id="fone" value="${contato.fone}" name="fone" class="form-control" type="text" placeholder="Fone" />
				<fmt:formatDate var="dc" value="${contato.dataAniversario}"	pattern="dd/MM/yyyy" />
				<input id="dataaniv" value="${dc}" name="dataaniv"	class="form-control" placeholder="Data de criação (dd/mm/aaaa)" />
				<select class="form-control" id="operadora" name="operadora">
						<option value="${null}" label="Selecione a operadora">Selecione a operadora</option>
						<c:forEach var="operadora" items="${operadoras}">
							<c:if test="${operadora.id eq contato.operadora.id}">
								<option value="${operadora.id}" label="${operadora.nome}" selected>${operadora.nome}</option>
							</c:if>
							<c:if test="${operadora.id ne contato.operadora.id}">
								<option value="${operadora.id}" label="${operadora.nome}">${operadora.nome}</option>
							</c:if>
						</c:forEach>
				</select>
				<input type="submit" class="form-control btn btn-primary"
					value="Salvar">
			</form>
		</div>
	</div>
	
	<c:import url="../template/footer.jsp" />
	<c:set var="endofconversation" value="yes" scope="request"/>
</body>
</html>