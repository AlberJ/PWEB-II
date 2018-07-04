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

<meta charset="ISO-8859-1">
<title>CADASTRO - Livro</title>
</head>
<body>
	<div class="container"
		style="background-image: url('http://engenhariae.com.br/wp-content/uploads/2017/04/fnac-desconto-livros.jpg'); width: 100%; height: 1060px">
		<div style="margin-top: 10%;"
			class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
			<div class="panel panel-info" align="center">
				<div class="panel-heading">
					<div class="panel-title">Cadastro de novo livro</div>
				</div>
				<form action="cadastra" method="post" class="form-horizontal"
					role="form">
					<div style="margin-bottom: 25px" class="input-group">
						<span class="input-group-addon"></span> <input type="text"
							class="form-control" name="titulo" placeholder="Titulo">
					</div>
					<div style="margin-bottom: 25px" class="input-group">
						<span class="input-group-addon"></span> <input type="text"
							class="form-control" name="autor" placeholder="Autor">
					</div>
					<div style="margin-bottom: 25px" class="input-group">
						<span class="input-group-addon"></span> <input type="date"
							class="form-control" name="publicado" placeholder="Publicado">
					</div>
					<div style="margin-bottom: 25px" class="input-group">
						<span class="input-group-addon"></span> <input type="number"
							class="form-control" name="paginas" placeholder="Paginas">
					</div>
					<div style="margin-bottom: 25px" class="input-group">
						<button id="btn-login" type="submit" class="btn btn-info"
							style="width: 300px">Cadastrar</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>