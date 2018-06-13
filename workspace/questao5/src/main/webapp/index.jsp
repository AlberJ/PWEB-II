<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB"
	crossorigin="anonymous">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Formulario de cadastro</title>
</head>
<body>
	<div class="container">
		<div class="col-4"></div>
		<div class="col-6">
			<br> <br>
			
			<p>${mensagem}</p>
			
			<form action="validar" method="post">

				Nome <input type="text" name="nome" required value="${nome}"> <br> <br>
				Email <input type="text" name="email" required value="${email}"> <br> <br>
				Telefone <input type="text" name="nome" required><br> <br>
				<br> Estudante ? <br> <input type="radio" name="estudante"
					value="sim" required>Sim <br> <br> <input
					type="radio" name="estudante" value="nao">Não <br>
				Número do cartão de crédito <input type="number" name="cartao"
					required> <br> <br> Confirme o numero do cartão
				de crédito <input type="number" name="confirmacao" required>
				<br> <br> <Input type="checkbox" name="cursos" value="tsi">Tsi
				<br> <Input type="checkbox" name="cursos" value="redes">Redes
				<br> <Input type="checkbox" name="cursos" value="administração">Administração
				<br> <Input type="checkbox" name="cursos" value="eletrica">Eng.
				Elétrica <br> <Input type="checkbox" name="cursos"
					value="geoprocessamento">Geoprocessamento <br> <br>
				<button type="submit">Cadastrar</button>
			</form>
		</div>
		<div class="col-2"></div>
	</div>
</body>
</html>