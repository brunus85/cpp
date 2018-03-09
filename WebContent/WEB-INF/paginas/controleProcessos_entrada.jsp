<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CPP - Entrada de Processos</title>
</head>
<body>
	<h1>Entrada de Processos</h1>

	<form action="executa?tarefa=RegistraEntrada&num_proc=num_processo" method="post">
		<label>Número do Processo:</label> 
		<input type="text" name="num_processo" maxlength="26" size="26">
		<input type="submit" value="Registrar">
	</form>


</body>
</html>