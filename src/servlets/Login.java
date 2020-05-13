package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Usuario;
import service.UsuarioService;

@WebServlet(
		name = "Login.do", 
		urlPatterns = { 
				"/Login.do" 
		})
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Login() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		PrintWriter saida = response.getWriter();
		
		UsuarioService us = new UsuarioService();
		Usuario u = new Usuario();
		
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		
		if(email.equals("") || senha.equals("")) {
			saida.print("<p><a href='index.jsp'>Volte</a> e preencha o usuário e senha!</p>");
		}
		else {
			u = us.consultar(email, senha);
			if(u != null) {
				HttpSession sessao = request.getSession();
				sessao.setAttribute("email", email);
				sessao.setAttribute("senha", senha);
				sessao.setAttribute("nome", u.getNome());
				response.sendRedirect("tarefas.jsp");
			}
			else {
				saida.print("<p>Usuário e/ou senha inválidos! <a href='index.jsp'>Volte</a></p>");
			}
		}
	}
}