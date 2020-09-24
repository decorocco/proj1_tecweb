<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page import="java.util.*,br.edu.insper.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista</title>
</head>
<body>

	<table border='1'>

		<tr>
			<td><b>#</b><td>
			<td><b>Nome</b><td>
			<td><b>Lançamento</b><td>
			<td><b>Tamanho</b><td>
			<td><b>Categoria</b><td>
		</tr>
		
			<c:forEach var="jogo" items="${jogos}">
			<tr>
				<td>${jogo.id}<td>
				<td>${jogo.nome}<td>
		 		<td><fmt:formatDate value="${jogo.data.time}" pattern="dd/MM/yyyy"/><td>
				<td>${jogo.tamanho}<td>
				<td>${jogo.categoria}<td>
				
				<form action="Remove" method="post">
				<button type="submit" name="id" value="${jogo.id}">Apagar</button>
				</form>
				
				<form action="Atualiza" method="get">
				<input type="hidden" name="id" value="${jogo.id}">
				<input type="hidden" name="nome" value="${jogo.nome}">
				<input type="hidden" name="data" value="<fmt:formatDate value="${jogo.data.time}" pattern="dd/MM/yyyy"/>">
				<input type="hidden" name="tamanho" value="${jogo.tamanho}">
				<input type="hidden" name="categoria" value="${jogo.categoria}">
				<input type="submit" value="Atualizar">
				
				</form>
				
			</tr>
			</c:forEach>
	</table>
	
	
	<b>ADICIONAR JOGO:</b>

			<form action='Cria' method='post'>
				Nome: <input type='text' name='nome'><br>
				Lançamento: <input type='text' name='data'><br>
				Tamanho(GBs): <input type='text' name='tamanho'><br>
				Categoria: <input type='text' name='categoria'><br>
				<input type='submit' value='Submit'>
			</form>

</body>
</html>