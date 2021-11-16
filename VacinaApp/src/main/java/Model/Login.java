package Model;

public class Login {

	public String Nome;
	public String Email;
	public String Senha;
	public String Cep;
	public String Ibge;

	
	public String FormatacaoPost(Login cliente) {
		String Conteudo = cliente.Nome + " | " + cliente.Email + " | " +
        					cliente.Senha + " | " + cliente.Cep + " | " + cliente.Ibge + "\n";
		
		return Conteudo;
		
	}
}
