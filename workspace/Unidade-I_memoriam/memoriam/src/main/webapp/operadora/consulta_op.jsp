<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Memoriam</title>
<link
	href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/memoriam.css"
	rel="stylesheet">
<script src="jquery.min.js"></script>
<script type="text/javascript">
function exibe_bt(este) {
	var listaMarcados = document.getElementsByTagName("INPUT");
	for (loop = 0; loop < listaMarcados.length; loop++) {
		var item = listaMarcados[loop];
		if (item.type == "checkbox" && item.checked) {
			var marcado = true;
		}
	}
	if (marcado == true) {
		btn_exc.style.visibility = "visible";
	} else {
		btn_exc.style.visibility = "hidden";
	}
}</script>
</head>
<body>
	<div class="container">
		<div class="jumbotron">
			<h2>
				Memori<i class="glyphicon glyphicon-phone"></i>m.
			</h2>
			<h3>Operadoras atualmente cadastradas</h3>
			<form action="controller.do?op=excope" method="POST" name="formulario">
					<table>
						<tr align="left">
							<th style="width: 30%">operadoras</th>
						</tr>
						<c:forEach var="operadora" items="${operadoras}">
							<tr align="left">
								<td>
								    <input type="checkbox" name="id" id="selecionado" value="${operadora.id}" onchange="exibe_bt(this);">
								</td>
								<td>
								    <a href="controller.do?op=editarOperadora&id=${operadora.id}">${operadora.nome}</a>
								</td>
							</tr>
						</c:forEach>
					</table>
					<div id="btn_exc" style="visibility: hidden;">
					<br> <input type="submit" value="excluir operadora"
						class="btn btn-danger"
						onClick="return confirm('Deseja realmente deletar os contatos selecionados?')">
						 
				</div>
				
				</form>
				<br> 
				    <a href="operadora/cadastro_op.jsp" class="btn btn-primary">Cadastrar nova operadora</a>
				    <a href="/memoriam" class="btn btn-info">Página principal</a>
				
				
				
				
				
				
		</div>
	</div>
</body>
</html>