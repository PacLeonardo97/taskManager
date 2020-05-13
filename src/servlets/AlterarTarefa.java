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
		name = "AlterarTarefa.do", 
		urlPatterns = { 
				"/AlterarTarefa.do" 
		})
public class AlterarTarefa extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AlterarTarefa() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter saida = response.getWriter();
		
		String idTarefa = request.getParameter("id_tarefa");
		String titulo = request.getParameter("titulo_tarefa");
		String descricao = request.getParameter("descricao_tarefa");
		String emailUsuario = request.getParameter("email_usuario_tarefa");
		
		if(idTarefa.equals("") || emailUsuario.equals("")) {
			saida.print("<a class='botao' href='tarefas.jsp'>Volte</a> e selecione uma tarefa para alterar");
		}
		else {
			int idTarefaInt = Integer.parseInt(idTarefa);
			Tarefa t = new Tarefa(idTarefaInt, titulo, descricao, emailUsuario);
			TarefaService ts = new TarefaService();
			ts.alterar(t);
			saida.print("Tarefa alterada com sucesso! <a class='botao' href='tarefas.jsp'>Voltar</a>");
		}
	}
}
