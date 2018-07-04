<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="tt" tagdir="/WEB-INF/tags/templating"%>
<%@ taglib prefix="mm" tagdir="/WEB-INF/tags/messages"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<tt:template title="Cadastrar operadora">
<jsp:attribute name="tscript">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
	<script	src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
	
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
		<script	src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
		<script type="text/javascript">
			var form = document.getElementById("logout-form");
			document.getElementById("link-submit").addEventListener("click",
			function() {form.submit()})
			</script>
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
	
	
	
	
</jsp:attribute>
<jsp:body>
		<nav class="navbar navbar-default navbar-fixed-top">
			<div class="container">
				<div id="navbar">
					<ul class="nav navbar-nav navbar-right">
						<li class="dropdown">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">${sessionScope.usuario.nome} 
								<span class="caret"></span>
							</a>
							<ul class="dropdown-menu">
								<li>
									<a href="#" id="link-submit">Sair</a>
								</li>
								<li role="separator" class="divider">
								</li>
								<li>
									<a href="#">$sessionScope.usuario.perfil</a>
								</li>
							</ul>
						</li>
					</ul>
				</div>
			</div>
		</nav>
		<form id="logout-form" action="controller.do" method="post">
			<input type="hidden" name="op" value="logout" />
		</form>
		<div class="container">
			<div class="jumbotron">
				<h2>Memori<i class="glyphicon glyphicon-phone"></i>m.</h2>
				<h3>Operadoras atualmente cadastradas</h3>
				<form action="controller.do?op=excluirOperadora" method="POST" name="formulario">
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
					<br>
					<input type="submit" value="excluir operadora" class="btn btn-danger" onClick="return confirm('Deseja realmente deletar os contatos selecionados?')">
					</div>
				</form>
				<br>
				<a href="operadora/cadastro_op.jsp" class="btn btn-primary">Cadastrar nova operadora</a>
				<a href="/memoriam" class="btn btn-info">Página principal</a>
			</div>
		</div>
			
<c:remove var="msgs" scope="application" />
</jsp:body>
</tt:template>
		