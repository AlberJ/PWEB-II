<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CADASTRO - Livro</title>
</head>
<body>
	<form action="cadastra" method="post">
		Titulo <input type="text" name="titulo"> <br> <br>
		Autor <input type="text" name="autor"> <br> <br>
		Publicado<input type="text" name="publicado"> <br> <br>
		Páginas <input type="text" name="paginas"> <br> <br>
		<button type="submit">Cadastrar</button>
	</form>
</body>
</html>