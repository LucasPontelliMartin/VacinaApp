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
import DAO.ClienteDAO;
import DAO.EnderecoDAO;
import DAO.LoginDAO;
import DAO.UbsDAO;
import Model.Agendar;
import Model.Cliente;
import Model.Endereco;
import Model.Ubs;

/**
 * Servlet implementation class AgendarController
 */
@WebServlet(urlPatterns = {"/AgendarController", "/Agendar"})
public class AgendarController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AgendarController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<String> dadosUbs = new ArrayList<String>();
		UbsDAO ubsDao = new UbsDAO();
		dadosUbs = (ArrayList<String>) ubsDao.LerDadosUBSProximas();
		ArrayList<String> UbsProxima = new ArrayList<String>();
		String Auxiliar = "";
		if (dadosUbs.size() > 0) {
        	
            String dado[] = new String[5];
            for (String d : dadosUbs) {
				dado = d.split(Pattern.quote(" | "));
                      
				Ubs ubs = new Ubs();;
				ubs.CodigoSP = dado[0];
				ubs.Ibge = dado[1];
				ubs.Unidade = dado[2];
				ubs.Logradouro = dado[3];
				ubs.Bairro = dado[4];
				
				Auxiliar = ubs.Unidade + " - " + ubs.Logradouro;

				UbsProxima.add(Auxiliar);	
            }
        }
		request.getSession().setAttribute("UbsProxima", UbsProxima);
		request.getRequestDispatcher("Campanha.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Agendar agendar = new  Agendar();
		AgendarDAO dao = new AgendarDAO();
		
		agendar.Unidade = request.getParameter("ubs");
        agendar.Campanha = request.getParameter("campanha");
        agendar.Hora = request.getParameter("hora");
        
        LoginDAO login = new LoginDAO();
        String dados = login.LerDadosLogin();
        
        String dadosConta[] = new String[5];
		dadosConta = dados.split(Pattern.quote(" | "));
        agendar.Nome = dadosConta[0];
		
        dao.SalvarAgendar(agendar.FormatacaoPost(agendar));
    	PrintWriter out = response.getWriter();
    	request.getRequestDispatcher("Inicio.html").forward(request, response);
	}

}
