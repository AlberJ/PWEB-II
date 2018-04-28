<!DOCTYPE html>
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link
	href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<meta charset="ISO-8859-1">
<title>P�gina - 1</title>
</head>
<body>
	<c:if test="${sessionScope.logado == null}">
		<c:redirect url="login.jsp" />
	</c:if>

	<table class="table table-striped"
		style="width: 25%; align-self: center;">
		<thead>
			<tr>
				<th>
					<h3>
						<span class="glyphicon glyphicon-user"></span> ${logado}
					</h3>
				</th>
				<th><a href="ajuda.jsp">Ajuda</a></th>
				<th><a href="logout">Sair</a></th>
			</tr>
		</thead>
	</table>
	<h1>Esta � a p�gina 2</h1>
	<br>
	<h3>Esta � a p�gina 2 Bl�, Bl�, Bl�...</h3>
	<br>
	<a href="pagina1.jsp"><< Anterior </a>
</body>
</html>