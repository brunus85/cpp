<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link type="text/css" href="cpp.css" rel="stylesheet">
	<c:import url="cpp.css"></c:import>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Registrar Processo - Novo Processo</title>
</head>
<body>

	<h1>Grava o processo e sua movimenta��o de entrada</h1>

	<form method="post" action="executa?tarefa=GravaProcessoMovimento">
		<label>N�mero do Processo:</label><input type="text" name="num_proc"><br>
		<label>Comarca:</label><input type="text" name="comarca"> <label>Vara:</label><br>
		<select name="id_vara">
			<option value="1">Vara Criminal</option>
			<option value="2">1� Vara C�vel</option>
			<option value="3">2� Vara C�vel</option>
		</select> <br>
		<label>Classe:</label><input type="text" name="classe"> <br>
		<label>Assunto:</label>	<input type="text" name="assunto"> <br>
		<label>Distribui��o:</label><input type="text" name="distribuicao"> <br>
		<label>Autor:</label><input type="text" name="autor"> <br>
		<label>Parte:</label><input type="text" name="denunciado">


	</form>
</body>
</html>