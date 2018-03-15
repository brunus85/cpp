<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link type="text/css" href="/cpp/estilo/cpp.css" rel="stylesheet">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registrar Processo - Novo Processo</title>
</head>
<body>

	<h1>Grava o processo e sua movimentação de entrada</h1>
	<form method="post" action="executa?tarefa=GravaProcessoMovimento">
		<fieldset>
			<legend>Cadastro do Processo</legend>
			
				<label for="num_proc">N. Processo:</label> 
				<input type="text" id="num_proc" name="num_proc"> <br />
				
				<label for="comarca">Comarca:</label> 
				<input type="text" id="comarca" name="comarca"> <br />
				
				<label	for="id_vara">Vara:</label> 
				<select id="id_vara" name="id_vara">
				
					<c:forEach var="v" items="${varaList}">
						<option id="id_vara" value="${v.id}">${v.descricao}</option>
					</c:forEach>

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
				<input type="text" name="denunciado"> <br/>
				
		</fieldset>
		<fieldset>
			<legend>Movimentação</legend>
			
			<input type="hidden" name="id_processo	">
			
			<label for="manifestacao">Manifestação</label>
			<input type="text" id="manifestacao" name="manifestacao" value="Para análise"><br/>
			
			<label for="destino"></label>
			<select id="destino" name="destino">
				<option id="destino" value="Setor Criminal">Setor Criminal</option>
				<option id="destino" value="Setor Cível">Setor Cível</option>
			</select><br/>
		
		</fieldset>
		<input type="submit" value="Registrar Entrada">
	</form>
</body>
</html>