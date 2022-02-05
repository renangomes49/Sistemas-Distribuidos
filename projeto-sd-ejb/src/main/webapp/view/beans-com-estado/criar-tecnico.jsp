<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!-- Configuração JSTL -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Técnico</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<style type="text/css">
h1 {
	text-align: center;
}

</style>

</head>
<body>
	
	<h1>Técnicos</h1> <br>

	<form action="<%= request.getContextPath()%>/CbfMemoriaServlet" method="post">
	  
	  <div class="row">
	  
		  <div class="mb-6">
		    <label class="form-label">Nome do Técnico</label>
		    <input type="text" name="nome" value="${nome}">
		  </div>
		  <div class="mb-6">
		    <label class="form-label">Data de Nascimento</label>
		    <input type="text" name="dataNascimento" value="${dataNascimento}">
		  </div>
		  <div class="mb-6 form-label">
		    <label class="form-label">CPF</label>
		    <input type="text" name="cpf" value="${cpf}">
		  </div>
		  <div class="mb-6 form-label">
		    <label class="form-label">Time</label>
		    <input type="text" name="time" value="${time}">
		  </div>
		  <div class="mb-3">
		  	<input type="submit"  class="btn btn-primary" name="opcao" value="adicionarTecnico">
		  </div>
		  
	  
	  </div>
	</form>	<br>
	<h3>${mensagem}</h3>
	
	<div>
		<table class="table" id="tecnicos">
													 
		  <thead>
		 
		    <tr>
		      <th scope="col">ID</th>
		      <th scope="col">Nome</th>
		      <th scope="col">Data de Nascimento</th>
		      <th scope="col">CPF</th>
		      <th scope="col">Time</th>
		      <th scope="col">Excluir</th>
		    </tr>
		 
		  </thead>
			<c:forEach items="${tecnicos}" var="t">
													 	  	
	 	  		<tr>
	 	  			<td><c:out value="${t.id}"></c:out> </td>
	 	  			<td><c:out value="${t.nome}"></c:out> </td>
	 	  			<td><c:out value="${t.dataNascimento}"></c:out></td>
	 	  			<td><c:out value="${t.cpf}"></c:out></td>
	 	  			<td><c:out value="${t.time}"></c:out></td>
	 	  			<td><a class="btn btn-outline-secondary" href="<%= request.getContextPath()%>/CbfMemoriaServlet?opcao=deleteTecnico&id=${t.id}">Excluir</a></td>
	 	  		</tr>
											 	  	
													 	  	
			</c:forEach>	
				<tbody>
													    
				</tbody>
		</table>	 
	</div>
	
</body>
</html>