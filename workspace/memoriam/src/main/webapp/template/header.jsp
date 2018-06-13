<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<nav class="navbar navbar-default navbar-fixed-top">
		<div class="container">
			<!-- Note that the .navbar-collapse and .collapse classes have been removed from the #navbar -->
			<div id="navbar">
				<c:if test="${usuario.perfil eq 'ADMIN'}">
					<ul class="nav navbar-nav">
						<li><a
							href="${pageContext.request.contextPath}/controller.do?op=conctts">Contatos</a></li>
						<li><a
							href="${pageContext.request.contextPath}/controller.do?op=conopers">Operadoras</a></li>
					</ul>
				</c:if>
				<ul class="nav navbar-nav navbar-right">
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">${usuario.nome} (${usuario.perfil})<span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="#" id="link-submit"><i
									class="glyphicon glyphicon-log-out"></i> Sair</a></li>
						</ul></li>
				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
	</nav>

	<form id="logout-form"
		action="${pageContext.request.contextPath}/controller.do" method="POST">
		<input type="hidden" name="op" value="logout">
	</form>