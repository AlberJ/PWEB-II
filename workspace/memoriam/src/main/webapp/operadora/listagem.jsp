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
			<h2>
				Memori<i class="glyphicon glyphicon-phone"></i>m
			</h2>

			

			<form action="${pageContext.request.contextPath}/controller.do" method="POST">
				<input type="hidden" name="op" value="deloper"> 
				<table class="table">
					<tr align="left">
						<th></th>
						<th style="width: 30%">Nome</th>
						<th>Prefixo</th>
					</tr>
					<c:forEach var="operadora" items="${operadoras}">
						<tr align="left">
							<td><input type="checkbox" name="delids"
								value="${operadora.id}" onclick="showDeleteIcon('bt-excluir')" /></td>
							<td><a href="${pageContext.request.contextPath}/controller.do?op=edtoper&id=${operadora.id}">${operadora.nome}</a></td>
							<td>${operadora.prefixo}</td>
						</tr>
					</c:forEach>
				</table>
				<div id="bt-excluir" style="display: none">
					<input type="submit" value="Excluir"
						class="form-control btn btn-danger"
						onclick="return confirm('Quer remover mesmo as operadoras?');" />
				</div>
			</form>
			<a href="operadora/cadastro.jsp" class="form-control btn btn-primary">Novo</a>
		</div>
	</div>

	<c:import url="../template/footer.jsp" />
	<c:set var="endofconversation" value="yes" scope="request"/>
	
</body>
</html>