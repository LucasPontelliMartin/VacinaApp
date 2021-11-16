package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.LoginDAO;
import DAO.UbsDAO;
import Model.Cliente;
import Model.Ubs;

/**
 * Servlet implementation class UbsController
 */
@WebServlet(urlPatterns = {"/UbsController", "/BuscarUbs"})
public class UbsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UbsController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		LoginDAO loginD = new LoginDAO();
		List<String> dadosUbs = new ArrayList<>();
		ArrayList<String> dadoUbs = new ArrayList<String>();
		String dados = loginD.LerDadosLogin();
		String dadosConta[] = new String[5];
		dadosConta = dados.split(Pattern.quote(" | "));
        String deee = "";
		Cliente c = new Cliente();
		c.Nome = dadosConta[0];
		c.Email = dadosConta[1];
		c.Senha = dadosConta[2];
		c.Cep = dadosConta[3];
		c.Ibge = dadosConta[4];
		
		UbsDAO ubsDao = new UbsDAO();
		dadosUbs = ubsDao.LerDadosUBS(c.Ibge);
		
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
					
					if(ubs.Ibge.equals(c.Ibge)) {
						dadoUbs.add(d);
						deee = deee + d + "\n";

					}
						
	            }
	        }
		 	ubsDao.SalvarEnderecoProximo(deee);
		 request.getSession().setAttribute("SUBFAMILY", dadoUbs);
		// request.setAttribute("Listagem", dadoUbs);
		 request.getRequestDispatcher("BuscarUbs.jsp").forward(request, response);
		 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
