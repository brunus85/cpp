<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Controle de Processos</title>
</head>
<body>

	<a href="<c:url value='executa?tarefa=EntradaProcessos'></c:url>">Entrada	de Processos</a>
	<br>
	<a href="<c:url value='executa?tarefa=MovimentoProcessos'></c:url>">Movimento de Processo</a>
	<br>
	<a href="<c:url value='/cpp/controleDeTarefas'></c:url>">Emitir 2ª Vida de Certidão de Saída</a>

</body>
</html>