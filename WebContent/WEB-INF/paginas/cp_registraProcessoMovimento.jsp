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

	<h1>Grava o processo e sua movimenta��o de entrada</h1>
	<form method="post" action="executa?tarefa=GravaProcessoMovimento">
		<fieldset>
			<legend>Cadastro do Processo</legend>
			
				<label for="num_proc">N. Processo:</label> 
				<input type="text" id="num_proc" value="${num_proc}" name="num_proc"> <br />
				
				<label for="comarca">Comarca:</label> 
				<input type="text" id="comarca" name="comarca" value="Pimenta Bueno"> <br />
				
				<label	for="id_vara">Vara:</label> 
				<select id="id_vara" name="id_vara">
					<option id="id_vara" value="" selected="selected">--</option>
					<c:forEach var="v" items="${varaList}">
						<option id="id_vara" value="${v.id}">${v.descricao}</option>
					</c:forEach>

				</select> <br />
				
				<label for="classe">Classe:</label> 
				<input type="text" name="classe"><br />

				<label for="assunto">Assunto:</label> 
				<input type="text" id="assunto" name="assunto"><br />
				
				<label for="distribuicao">Distribui��o:</label>
				<input type="text" id="distribuicao" name="distribuicao"> <br />
				
				<label for="autor">Autor:</label>
				<input type="text" id="autor" name="autor"> <br />
				
				<label for="parte" id="parte">Parte:</label>
				<input type="text" name="parte"> <br/>
				
		</fieldset>
		<fieldset>
			<legend>Movimenta��o</legend>
			
			<input type="hidden" name="id_processo	">
			
			<label for="manifestacao">Manifesta��o</label>
			<input type="text" id="manifestacao" name="manifestacao" value="Para an�lise"><br/>
			
			<label for="destino">Destino:</label>
			<select id="destino" name="destino">
				<option id="destino" value="Setor Criminal">Setor Criminal</option>
				<option id="destino" value="Setor C�vel">Setor C�vel</option>
			</select><br/>
			
			<label for="responsavel">Respons�vel:</label>
			<select id="responsavel" name="responsavel">
				<option id="responsavel" value="Heverson">Heverson</option>
				<option id="responsavel" value="Taynara">Taynara</option>
				<option id="responsavel" value="Fl�vio">Fl�vio</option>
				<option id="responsavel" value="Rog�rio">Rog�rio</option>
			</select><br/>
			
			<label for="data">Data:</label>
			<input type="date" id="data" name="data">
		
		</fieldset>
		<input type="submit" value="Registrar Entrada">
	</form>
</body>
</html>