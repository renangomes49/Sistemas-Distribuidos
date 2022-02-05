<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Criar Time</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<style type="text/css">
h1 {
	text-align: center;
}

</style>

</head>
<body>
	
	<h1>Criar Time</h1> <br>

	<form action="<%= request.getContextPath()%>/CbfServlet" method="post">
	  
	  <div class="row">
	  
		  <div class="mb-6">
		    <label class="form-label">Nome do Time</label>
		    <input type="text" name="nome" value="${nome}">
		  </div>
		  <div class="mb-6">
		    <label class="form-label">Nome do Estadio</label>
		    <input type="text" name="estadio" value="${estadio}">
		  </div>
		  <div class="mb-6 form-label">
		    <label class="form-label">Localização do Estadio</label>
		    <input type="text" name="localizacao" value="${localizacao}">
		  </div>
		  <div class="mb-3">
		  	<input type="submit"  class="btn btn-primary" name="opcao" value="adicionarTime">
		  </div>
		  
	  
	  </div>
	</form>	
	
</body>
</html>