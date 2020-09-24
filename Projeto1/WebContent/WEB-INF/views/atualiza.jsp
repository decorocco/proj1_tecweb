<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page import="java.util.*,br.edu.insper.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Atualizar</title>
</head>
<body>

	<form method='post' action="Atualiza">
		Nome: <input value="${param.nome}" type='text' name='nome'><br>
		Lançamento: <input value="${param.data}" type='text' name='nascimento'><br>
		Tamanho: <input value="${param.tamanho}" type='text' name='idade'><br>
		
		<input type="hidden" value="${param.id}" name="id">
		<input type='submit' value='Atualizar'>
		
	</form>

</body>
</html>