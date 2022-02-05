<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Criar Jogador</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<style type="text/css">
h1 {
	text-align: center;
}

</style>

</head>
<body>
	
	<h1>Criar Jogador</h1> <br>

	<form action="<%= request.getContextPath()%>/CbfServlet" method="post">
	  
	  <div class="row">
	  
		  <div class="mb-6">
		    <label class="form-label">Nome do Jogador</label>
		    <input type="text" name="nome" value="${nome}">
		  </div>
		  <div class="mb-6">
		    <label class="form-label">CPF</label>
		    <input type="text" name="cpf" value="${cpf}">
		  </div>
		  <div class="mb-6">
		    <label class="form-label">Data de Nascimento</label>
		    <input type="text" name="dataNascimento" value="${dataNascimento}">
		  </div>
		  <div class="mb-6 form-label">
		    <label class="form-label">Idade</label>
		    <input type="text" name="idade" value="${idade}">
		  </div>
		  <div class="mb-6 form-label">
		    <label class="form-label">Posição</label>
		    <input type="text" name="posicao" value="${posicao}">
		  </div>
		  <div class="mb-6 form-label">
		    <label class="form-label">Cidade de Origem</label>
		    <input type="text" name="cidadeOrigem" value="${cidadeOrigem}">
		  </div>
		  <div class="mb-6">
		    <label class="form-label">Estado de Origem</label>
		    <input type="text" name="estadoOrigem" value="${estadoOrigem}">
		  </div>
		  <div class="mb-6">
		    <label class="form-label">País de Origem</label>
		    <input type="text" name="paisOrigem" value="${paisOrigem}">
		  </div>
		  <div class="mb-3">
		  	<input type="submit"  class="btn btn-primary" name="opcao" value="adicionarJogador">
		  </div>
		  
	  
	  </div>
	</form>
</body>
</html>