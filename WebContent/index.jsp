<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Tasks Manager</title>
	</head>
	<body>
		<h1 class="logo">Tasks Manager</h1>
		<form method="post" action="Login.do">
			<p>
				E-mail: <input type="text" name="email">
			</p>
			<p>
				Senha: <input type="password" name="senha">
			</p>
			<input type="submit" value="Entrar">
		</form>
		<p>
			<a href="cadastrar.jsp">Cadastre-se</a>
		</p>
	</body>
</html>