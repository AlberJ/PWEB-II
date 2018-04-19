<!DOCTYPE html>
<html>
<head>
<link
	href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<meta charset="ISO-8859-1">
<title>Prática -6</title>
</head>
<body>
	<div class="container"
		style="background-color: black; width: 100%; height: 860px">
		<div id="loginbox" style="margin-top: 50px;"
			class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
			<div class="panel panel-info">
				<div class="panel-heading">
					<div class="panel-title">Login - Prática 6 - Sessões</div>
				</div>
				<div style="padding-top: 30px" class="panel-body">
					<div style="display: none" id="login-alert"
						class="alert alert-danger col-sm-12"></div>
					<form action="login" method="post" class="form-horizontal"
						role="form">
						<div style="margin-bottom: 25px" class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-user"></i></span> <input type="text"
								class="form-control" name="login" placeholder="Login">
						</div>
						<div style="margin-bottom: 25px" class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-lock"> </i></span> <input type="password"
								class="form-control" name="senha" placeholder="Senha">
						</div>
						<div style="margin-top: 10px" class="form-group">
							<div class="col-md-offset-3 col-md-9">
								<button id="btn-login" type="submit" class="btn btn-info"
									style="width: 300px">
									<i class="icon-hand-right"> </i> Entrar
								</button>
								<p style="color: red">${erro}</p>

							</div>

						</div>
					</form>
				</div>
				<div align="right">
					<a href="ajuda.jsp" class="btn btn-large btn-primary"> <i
						class="glyphicon glyphicon-question-sign	Try it
"></i>
					</a>
				</div>
			</div>
		</div>
	</div>
</body>
</html>


