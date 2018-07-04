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
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<meta charset="ISO-8859-1">
<title>Livros cadastrados</title>
</head>
<body>

	<h1>Livros cadastrados</h1>
	<div style="padding-bottom: 5px">
		<input type="button" value="+Novo"
			onclick="window.location.href='cadastro.jsp'">
	</div>
	<c:if test="${not empty livros}">
		<divstyle="padding-bottom:5px">
		<inputtype ="button"value="+Novo"
			onclick="window.location.href='cadastro.jsp'">
		</div>
		<table border="1">
			<thead>
				<tr>
					<th width="30%">Título</th>
					<th width="30%">Autor</th>
					<th width="10%">Páginas</th>
					<th width="10%">Publicado em</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="livro" items="${livros}">
					<fmt:formatNumber var="paginas" pattern="00000"
						value="${livro.paginas}" />
					<fmt:formatDate var="publicado" pattern="dd/MM/yyyy"
						value="${livro.publicado}" />
					<tr>
						<td>${livro.titulo}</td>
						<td>${livro.autor}</td>
						<td style="text-align: right">${paginas}</td>
						<td style="text-align: center">${publicado}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:if>
</body>
</html>