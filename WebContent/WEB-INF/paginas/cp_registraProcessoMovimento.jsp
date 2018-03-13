<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link type="text/css" href="${request.contextPath}/css/cpp.css" rel="stylesheet">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registrar Processo - Novo Processo</title>
</head>
<body>

	<h1>Grava o processo e sua movimentação de entrada</h1>

	<form method="post" action="executa?tarefa=GravaProcessoMovimento">
		<fieldset>
			<legend>Cadastro do Processo</legend>
			
				<label for="num_proc">Número do Processo:</label> 
				<input type="text" id="num_proc" name="num_proc"> <br />
				
				<label for="comarca">Comarca:</label> 
				<input type="text" id="comarca" name="comarca"> <br />
				
				<label	for="id_vara">Vara:</label> 
				<select id="id_vara" name="id_vara">
					<option id="id_vara" value="1">Vara Criminal</option>
					<option id="id_vara" value="2">1ª Vara Cível</option>
					<option id="id_vara" value="3">2ª Vara Cível</option>
				</select> <br />
				
				<label for="classe">Classe:</label> 
				<input type="text" name="classe"><br />

				<label for="assunto">Assunto:</label> 
				<input type="text" id="assunto" name="assunto"><br />
				
				<label for="distribuicao">Distribuição:</label>
				<input type="text" id="distribuicao" name="distribuicao"> <br />
				
				<label for="autor">Autor:</label>
				<input type="text" id="autor" name="autor"> <br />
				
				<label for="denunciado" id="denunciado">Parte:</label>
				<input type="text" name="denunciado">
		</fieldset>
	</form>
</body>
</html>