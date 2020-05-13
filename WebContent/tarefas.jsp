<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Tarefa" %>
<%@ page import="service.TarefaService" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Tasks Manager</title>
		<style><%@include file="estilo.css"%></style>
	</head>
	<body>
		<% 
			String nome = "";
			HttpSession sessao = request.getSession();
			if(session.getAttribute("nome") == null) {
				session.setAttribute("mensagem", "Usuário e/ou senha inválidos!");
				response.sendRedirect("index.jsp");
			}
			else {
				nome = (String) session.getAttribute("nome");
				
			}
		%>
		
		<h1 class="logo">Tasks Manager</h1> 
		<p class="texto">
			Boas vindas <%= nome %> 
		</p>
		<a class="sair" href="Logoff.do">Sair</a>
		<br><br>
		<a class="botao" href="cadastrar_tarefa.jsp">Adicionar Tarefa</a>
		<br><br>
		
		<%
			String email = (String) session.getAttribute("email");
			TarefaService ts = new TarefaService();
			Tarefa t = new Tarefa();
			ArrayList<Tarefa> lista = new ArrayList<>();
			lista = ts.listar(email);
			if(lista.size() >= 1) {
				for(int i = 0; i < lista.size(); i++) {
					t = lista.get(i);
		%>
			<div class="tarefa">
					<p class="titulo">
						<%= t.getTitulo() %> 
						<a href="alterar_tarefa.jsp?id=<%= t.getId() %>"><img src="imagens/Alterar.png" width="30" alt="Alterar"></a>
						<a href="DeletarTarefa.do?id=<%= t.getId() %>"><img src="imagens/Remover.png" width="30" alt="Deletar"></a>
					</p>
					<p class="descricao">
						<%= t.getDescricao() %>
					</p>
			</div>
		<%			
				}
			}
		%>
	</body>
</html>