<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
	
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link type="text/css" href="${pageContext.request.contextPath}/estilo/cpp.css" rel="stylesheet">
<title>Controle de Processos e Produtividade - CPP</title>
</head>
<body>
	<h1>Bem Vindo ao Controle de Processos e Produtividade</h1>
	${pageContext.request.contextPath}/estilo/cpp.css
	<h3>Defensoria Pública - Pimenta Bueno/RO</h3>

	<form action="executa?tarefa=ControleDeProcessos" method="post">
		<input type="submit" value="Controle de Processos" />
	</form>


	<br>
	<a href="<c:url value='/cpp/controleDeTarefas'></c:url>">Controle
		de Petições/Tarefas</a>
</body>
</html>