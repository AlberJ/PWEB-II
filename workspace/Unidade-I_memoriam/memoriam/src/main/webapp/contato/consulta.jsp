<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
	  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	  <script src="jquery.min.js"></script>
	 <script type="text/javascript"></script>
  
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Memoriam</title>
<link
	href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/memoriam.css"
	rel="stylesheet">

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
	}
</script>
</head>
<body>
	<div class="container">
		<div class="jumbotron">
			<h2>
				Memori<i class="glyphicon glyphicon-phone"></i>m.
			</h2>
			<h3>Contatos atualmente cadastrados</h3>
			<br>
				<form action="controller.do?op=delctt" method="POST" name="formulario">
					<table>
						<tr align="left">
							<th style="width: 5%"></th>
							<th style="width: 30%">Nome</th>
							<th style="width: 20%">Telefone</th>
							<th style="width: 10%">Operadora</th>
						</tr>
						<c:forEach var="contato" items="${contatos}">
							<tr align="left">
								<td>
								    <input type="checkbox" name="id" id="selecionado" value="${contato.id}" onchange="exibe_bt(this);">
								</td>
								<td>
								    <a href="controller.do?op=editarContato&id=${contato.id}">${contato.nome}</a>
								</td>
								<td>
								    ${contato.fone}
								</td>
								<td>
								    ${contato.operadora.nome}
								</td>
							</tr>
						</c:forEach>
					</table>
					<br>
					<br> 
					<a href="contato/cadastro.jsp" class="btn btn-primary">Novo contato </a>
				    <a href="controller.do?op=consultarOperadoras" class="btn btn-primary">Consultar operadoras</a>
				<div id="btn_exc" style="visibility: hidden;">
					<br> <input type="submit" value="excluir contato"
						class="btn btn-danger"
						onClick="return confirm('Deseja realmente deletar os contatos selecionados?')">
				</div>
			</form>
		</div>
		
	</div>
</body>
</html>