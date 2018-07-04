<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="tt" tagdir="/WEB-INF/tags/templating"%>
<%@ taglib prefix="mm" tagdir="/WEB-INF/tags/messages"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<tt:template title="Cadastro de contatos">
	<jsp:attribute name="tscript">
	    <script
			src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
	    <script
			src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
	   
	    <script type="text/javascript">
						var form = document.getElementById("logout-form");
						document.getElementById("link-submit")
								.addEventListener("click", function() {
									form.submit()
								})
					</script>
</jsp:attribute>
	<jsp:body>
		<nav class="navbar navbar-default navbar-fixed-top">
			<div class="container">
				<div id="navbar">
					<ul class="nav navbar-nav navbar-right">
						<li class="dropdown">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown"
							role="button" aria-haspopup="true" aria-expanded="false">${sessionScope.usuario.nome} 
							  <span class="caret"></span>
							</a>
							<ul class="dropdown-menu">
								<li>
									<a href="#" id="link-submit">Sair</a>
								</li>
								<li role="separator" class="divider">
								</li>
								<li>
								<a href="#">${sessionScope.usuario.perfil}
									</a>
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
				<h2>Memori<i class="glyphicon glyphicon-phone"></i>m</h2>
				<h3>Dados para novo contato</h3>
				<mm:messages value="${msgs}" erroStyle="color:red"
					infoStyle="color:blue" />
				<form action="${pageContext.request.contextPath}/controller.do"
					method="post" class="form-horizontal">
					<input type="hidden" name="op" value="cadastrarContato">
					<input type="hidden" name="id" value="${contato.id}">
					<input type="text" id="nome" value="${contato.nome}" name="nome"
						class="form-control" placeholder="Nome" />
					<input type="text" id="fone" value="${contato.fone}" name="fone"
						class="form-control" placeholder="Fone" />
					<fmt:formatDate var="dataAniv" value="${contato.dataAniversario}"
						pattern="dd/MM/yyyy" />
					<input type="text" id="dataaniv" value="${dataAniv}"
						name="dataaniv" class="form-control"
						placeholder="Data de criação (dd/mm/aaaa)" />
					<select class="form-control" id="operadora" name="operadora"
						required="required">
					    <option value="${null}" label="Selecione a operadora">Selecione a operadora</option>
						<c:forEach var="operadora" items="${UtilBean.operadoras}">
							<c:if test="${operadora.id eq contato.operadora.id}">
								<option value="${operadora.id}" label="${operadora.nome}"
									selected>${operadora.nome}</option>
							</c:if>
							<c:if test="${operadora.id ne contato.operadora.id}">
								<option value="${operadora.id}" label="${operadora.nome}">${operadora.nome}</option>
							</c:if>
						</c:forEach>
					</select> 
					<input type="submit" class="btn btn-primary" value="Salvar">
					<a href="/memoriam" class="btn btn-info">Cancelar</a>
				</form>
			</div>
	</div>
	
<c:remove var="msgs" scope="application" />
</jsp:body>
</tt:template>

