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
		String id = request.getParameter("id");
		Tarefa t = new Tarefa();
		if(id.equals("")) {
			out.print("<a class='botao' href='tarefas.jsp'>Volte</a> e selecione uma tarefa para alterar");
		}
		else {
			int idTarefa = Integer.parseInt(id);
			TarefaService ts = new TarefaService();
			t = ts.consultar(idTarefa);
		}
		%>
		<h1 class="logo">Tasks Manager</h1>
		<form method="post" action="AlterarTarefa.do">
			<p>
				ID da Tarefa: <input type="hidden" name="id_tarefa" value="<%= t.getId() %>" readonly>
			</p>
			<p>
				Título: <input type="text" name="titulo_tarefa" value="<%= t.getTitulo() %>">
			</p>
			<p>
				Descrição: <input type="text" name="descricao_tarefa" value="<%= t.getDescricao() %>">
			</p>
			<p>
				Email do Usuário: <input type="text" name="email_usuario_tarefa" value="<%= t.getEmailUsuario() %>" readonly>
			</p>
			<input type="submit" value="Alterar">
		</form>
	</body>
</html>