package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Tarefa;
import service.TarefaService;

@WebServlet(
		name = "CadastrarTarefa.do", 
		urlPatterns = { 
				"/CadastrarTarefa.do" 
		})
public class CadastrarTarefa extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CadastrarTarefa() {
        super();
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter saida = response.getWriter();
		
		String titulo = request.getParameter("titulo_tarefa");
		String descricao = request.getParameter("descricao_tarefa");
		String emailUsuario = request.getParameter("email_usuario_tarefa");
		
		if(titulo.equals("") || descricao.equals("") || emailUsuario.equals("")) {
			saida.print("<a class='botao' href='cadastrar_tarefa.jsp'>Volte</a> e preencha todos os campos");
		}
		else {
			Tarefa t = new Tarefa(titulo, descricao, emailUsuario);
			TarefaService ts = new TarefaService();
			ts.cadastrar(t);
			saida.print("Tarefa cadastrada com sucesso! <a class='botao' href='tarefas.jsp'>Voltar</a>");
		}
	}
}
