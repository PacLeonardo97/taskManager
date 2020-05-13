package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Usuario;
import service.UsuarioService;

@WebServlet(name = "Cadastrar.do", urlPatterns = { "/Cadastrar.do" })
public class Cadastrar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Cadastrar() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		PrintWriter saida = response.getWriter();
		
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		String nome = request.getParameter("nome");
		
		if(email.equals("") || senha.equals("") || nome.equals("")) {
			saida.print("<p><a href='cadastrar.jsp'>Volte</a> e preencha todos os campos!</p>");
		}
		else {
			if(email.length() > 256 || senha.length() > 16 || nome.length() > 126) {
				saida.print("<p><a href='cadastrar.html'>Volte</a> e preencha o nome com no máximo 256 caracteres, senha com no máximo 16 caracteres e nome com no máximo 126 caracteres!</p>");
			}
			else {
				UsuarioService us = new UsuarioService();
				Usuario u = new Usuario(email, senha, nome);
				us.cadastrar(u);
				saida.print("<p>Cadastrada(o)!</p> <a href='index.jsp'>Volte e entre com seu e-mail e senha</a>");
			}
		}
	}
}
