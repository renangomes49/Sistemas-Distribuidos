<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Tela de Início</title>

<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<style type="text/css">
h1 {
	text-align: center;
}

</style>

</head>
<body>

	<h1>EJB - Disciplina de Sistemas Distribuídos 2021.2</h1>

	<div class="row">
	
		<div class="col-md-6">
			<!-- As a link -->
			<nav class="navbar navbar-light bg-light">
				<div class="container-fluid">
					<a class="navbar-brand" href="view/beans-sem-estado/principal-bse.jsp">Beans de Sessão sem Estado</a>
				</div>
			</nav>
		</div>
		<div class="col-md-6">
			<!-- As a heading -->
			<nav class="navbar navbar-light bg-light">
				<div class="container-fluid">
					<a class="navbar-brand" href="view/beans-com-estado/principal-bce.jsp">Beans de Sessão com Estado</a>
				</div>
			</nav>
		</div>
	</div>
</body>
</html>