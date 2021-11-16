package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.AgendarDAO;
import DAO.LoginDAO;
import Model.Agendar;
import Model.Cliente;
import Model.Ubs;

/**
 * Servlet implementation class AgendamentoController
 */
@WebServlet(urlPatterns = {"/AgendamentoController", "/Agendamento"})
public class AgendamentoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AgendamentoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Agendar agendar = new  Agendar();
		AgendarDAO dao = new AgendarDAO();
		LoginDAO loginD = new LoginDAO();
		String dadosLogin = loginD.LerDadosLogin();
		
		String dadosContaLogin[] = new String[5];
		dadosContaLogin = dadosLogin.split(Pattern.quote(" | "));
		Cliente c = new Cliente();
		c.Nome = dadosContaLogin[0];
		
		ArrayList<String> dados = new ArrayList<String>();
		dados = (ArrayList<String>) dao.LerDadosAgenda();
		
		ArrayList<String> dadoss = new ArrayList<String>();

        
		 String dadosConta[] = new String[4];
		 String campo = "";	
	        
        if (dados.size() > 0) {

            for (String d : dados) {
            	dadosConta = d.split(Pattern.quote(" | "));
    	        agendar.Nome = dadosConta[0];
    	        agendar.Unidade = dadosConta[1];
    	        agendar.Campanha = dadosConta[2];
    	        agendar.Hora = dadosConta[3];
    	        
    	        if(agendar.Nome.equals(c.Nome)) {
    	        	 campo = agendar.Unidade + " | " + agendar.Campanha + " | " + agendar.Hora ;
    				 dadoss.add(campo);
    	        }
    	       
					
            }
        }
                request.getSession().setAttribute("lista", dadoss);
		request.getRequestDispatcher("Agenda.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
