<!DOCTYPE html>
<html>
<head>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<meta charset="ISO-8859-1">
<title>Select Dinâmico - Hilberto</title>
</head>
<body>
	<h1>forEach JSTL</h1>
	<br>
	<form action="geraSelect" method="get">
		Informe um novo item para o select <input type="text" name="novo_item">
		<button type="submit">Adicionar Item</button>
	</form>
	<h1>Este é o select "alimentado" pelo Servlet</h1>
	<br>
	<select>
		<c:forEach items="${opcoes}" var="opcao">
			<option>"${opcao}"</option>
		</c:forEach>
	</select>
</body>
</html>