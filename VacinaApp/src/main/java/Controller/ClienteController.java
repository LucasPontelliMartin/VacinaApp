package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ClienteDAO;
import DAO.EnderecoDAO;
import DAO.LoginDAO;
import Model.Cliente;
import Model.Endereco;
import Model.Login;

/**
 * Servlet implementation class ClienteController
 */
@WebServlet(urlPatterns = {"/ClienteController", "/Cliente"})
public class ClienteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClienteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cliente cliente = new  Cliente();
		ClienteDAO dao = new ClienteDAO();
		
		List<String> dados = new ArrayList<>();
		List<Cliente> dadosCliente = new ArrayList<>();
		
		cliente.Email = request.getParameter("email");
        cliente.Senha = request.getParameter("senha");
        
        dados = dao.LerDadosCliente();
        
        boolean login = false;

        if (dados.size() > 0) {
        	
            String dadosConta[] = new String[5];
            for (String d : dados) {
				dadosConta = d.split(Pattern.quote(" | "));
                      
				Cliente c = new Cliente();
				c.Nome = dadosConta[0];
				c.Email = dadosConta[1];
				c.Senha = dadosConta[2];
				c.Cep = dadosConta[3];
				c.Ibge = dadosConta[4];
				dadosCliente.add(c);
				
				if(cliente.Email.equals(c.Email) && cliente.Senha.equals(c.Senha)) {
					login = true;
					LoginDAO loginDao = new LoginDAO();
					loginDao.SalvarLogin(c.FormatacaoPost(c));
				}
					
            }
        }
        
        
        if(login) {
        	
        	request.getRequestDispatcher("/Inicio.html").forward(request, response);
    		
        }
        
        
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cliente cliente = new  Cliente();
		ClienteDAO dao = new ClienteDAO();
		EnderecoDAO daoEndereco = new EnderecoDAO();
		
		cliente.Nome = request.getParameter("name");
        cliente.Email = request.getParameter("email");
        cliente.Senha = request.getParameter("senha");
        cliente.Cep = request.getParameter("cep");
		cliente.Ibge = request.getParameter("ibgelbl");
		
        Endereco endereco = new Endereco();
        
        endereco.Cep = request.getParameter("cep");
        endereco.Bairro = request.getParameter("bairro");
        endereco.Rua = request.getParameter("rua");
        endereco.Cidade = request.getParameter("cidade");
        endereco.Ibge = request.getParameter("ibgelbl");
        endereco.Estado = request.getParameter("estado");
        
        String conteudo = cliente.FormatacaoPost(cliente);
        boolean retornoCliente = dao.SalvarCliente(conteudo);
        
        String conteudoEndereco = endereco.FormatacaoPost(endereco);
        boolean retornoEndereco = daoEndereco.SalvarEndereco(conteudoEndereco);
        
        
        if(retornoCliente && retornoEndereco) {
            Login login = new Login();
            login.Cep = request.getParameter("cep");
            login.Email = request.getParameter("email");
            login.Nome = request.getParameter("name");
            login.Senha = request.getParameter("senha");
            login.Ibge = request.getParameter("ibgelbl");
        	LoginDAO loginDao = new LoginDAO();
			loginDao.SalvarLogin(login.FormatacaoPost(login));	
        	request.getRequestDispatcher("/Inicio.html").forward(request, response);
    		
        }
	}

}
