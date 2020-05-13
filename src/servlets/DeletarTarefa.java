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
		name = "DeletarTarefa.do", 
		urlPatterns = { 
				"/DeletarTarefa.do"
		})
public class DeletarTarefa extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeletarTarefa() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idTarefa = request.getParameter("id");
		
		response.setContentType("text/html");
		PrintWriter saida = response.getWriter();
		TarefaService ts = new TarefaService();
		
		saida.print("<meta charset='UTF-8'>");
		if(idTarefa.equals("")) {
			saida.print("<p><a href='tarefas.jsp'>Volte</a> e selecione uma tarefa para excluir!</p>");
		}
		else {
			int idTarefaInt = Integer.parseInt(idTarefa);
			Tarefa t = ts.consultar(idTarefaInt);
			if(t.getId() == 0) {
				saida.print("<p>Tarefa não encontrada! <a href='tarefas.jsp'>Volte</a> e selecione uma tarefa para excluir!</p>");
			}
			else {
				ts.excluir(t);
				saida.print("<p>Tarefa deletada!</p> <a href='tarefas.jsp'>Voltar</a>");
			}
		}
	}
}
