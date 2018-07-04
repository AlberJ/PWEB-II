<%@ page contentType="text/html; charset=UTF-8 " pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="mm" tagdir="/WEB-INF/tags/messages" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style></style>
<title>Cadastro de Contato</title>
<link
	href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/memoriam.css"
	rel="stylesheet">
</head>
<body>
	<div class="container">
		<div class="jumbotron">
			<h2>Memori<i class="glyphicon glyphicon-phone"> </i>m</h2>
			<h3>Dados para novo contato</h3>
			<mm:messages value="${msgs}" erroStyle="color:red" infoStyle="color:blue"/>
			<form action="${pageContext.request.contextPath}/controller.do"
				method="post" class="form-horizontal">
				<input type="hidden" name="op" value="cadctt"> <input
					type="hidden" name="id" value="${contato.id}"> <input
					type="text" id="nome" value="${contato.nome}" name="nome"
					class="form-control" placeholder="Nome" /> <input type="text"
					id="fone" value="${contato.fone}" name="fone" class="form-control"
					placeholder="Fone" />
				<fmt:formatDate var="dataAniv" value="${contato.dataAniversario}"
					pattern="dd/MM/yyyy" />
				<input type="date" id="dataaniv" value="${dataAniv}" name="dataaniv"
					class="form-control" placeholder="Data de criação (dd/mm/aaaa)" />


				<select class="form-control" id="operadora" name="operadora"
					required="required">
					<option value="${null}" label="Selecione a operadora">
						Selecione a operadora</option>
					<c:forEach var="operadora" items="${UtilBean.operadoras}">
						<c:if test="${operadora.id eq contato.operadora.id}">
							<option value="${operadora.id}" label="${operadora.nome}"
								selected>${operadora.nome}</option>
						</c:if>
						<c:if test="${operadora.id ne contato.operadora.id}">
							<option value="${operadora.id}" label="${operadora.nome}">
								${operadora.nome}</option>
						</c:if>
					</c:forEach>
				</select> 
				         <input type="submit" class="btn btn-primary" value="Salvar">
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