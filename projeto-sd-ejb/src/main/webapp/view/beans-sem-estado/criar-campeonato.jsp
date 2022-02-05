<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Criar Campeonato</title>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<style type="text/css">
h1 {
	text-align: center;
}

body {
		position: absolute;
		left: 30%;
		right: 33%;
	
	}
</style>

</head>
<body>

	<h1>Criar Campeonato</h1>
	<br>

	<form action="<%=request.getContextPath()%>/CbfServlet" method="post">

		<div class="row">

			<label class="form-label">Nome do Campeontato: </label>

			
			<div class="form-check form-check-inline">
				<input class="form-check-input" type="radio" name="campeonato"
					id="serieA" value="SerieA"> <label
					class="form-check-label" for="serieA">Serie A</label>
			</div>
			<div class="form-check form-check-inline">
				<input class="form-check-input" type="radio" name="campeonato"
					id="serieB" value="SerieB"> <label
					class="form-check-label" for="serieB">Serie B</label>
			</div>

			<div class="mb-6">
				<label class="form-label">Ano do Campeonato</label> <input
					type="text" name="ano" value="${ano}">
			</div>
			<div class="mb-3">
				<input type="submit" class="btn btn-primary" name="opcao"
					value="adicionarCampeonato">
			</div>


		</div>
	</form>
	
	<h1>${mensagem}</h1>

</body>
</html>