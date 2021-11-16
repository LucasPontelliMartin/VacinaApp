package Model;

public class Endereco {
	
	public String Cep;
	public String Ibge;
	public String Rua;
	public String Bairro;
	public String Cidade;
	public String Estado;

	
	public String FormatacaoPost(Endereco endereco) {
		String Conteudo = endereco.Cep + " | " + endereco.Rua + " | " +
				endereco.Bairro + " | " + endereco.Cidade + " | " + endereco.Estado + " | " + endereco.Ibge +"\n";
		
		return Conteudo;
		
	}
}
