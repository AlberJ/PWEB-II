<!DOCTYPE html>
<html>
<head>
<link
	href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<meta charset="ISO-8859-1">
<title>Livros cadastrados</title>
</head>
<body>
	<h1>Livros Cadastrados</h1>
	<table class="table">
		<tr align="left">
			<th style="width: 10%">Titulo</th>
			<th style="width: 10%">Autor</th>
			<th style="width: 10%">Data de Publicação</th>
			<th style="width: 10%">Quantidade de Páginas</th>
		</tr>
		<c:forEach var="livro" items="${livros}">
			<tr>
				<td>${livro.titulo}</td>
				<td>${livro.autor}</td>
				<td>${livro.publicado}</td>
				<td>${livro.paginas}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>