<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Tarefa" %>
<%@ page import="service.TarefaService" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Tasks Manager</title>
	</head>
	<body>
		<% 
		String email = "";
		HttpSession sessao = request.getSession();
		if(session.getAttribute("email") == null) {
			response.sendRedirect("index.jsp");
		}
		else {
			email = (String) session.getAttribute("email");
		}
		%>
		<h1 class="logo">Tasks Manager</h1>
		<form method="post" action="CadastrarTarefa.do">
			<p>
				Título: <input type="text" name="titulo_tarefa">
			</p>
			<p>
				Descrição: <input type="text" name="descricao_tarefa">
			</p>
			<p>
				Email do Usuário: <input type="text" name="email_usuario_tarefa" value="<%= email %>" readonly>
			</p>
			<input type="submit" value="Cadastrar">
		</form>
	</body>
</html>