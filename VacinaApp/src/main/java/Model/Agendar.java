package Model;

public class Agendar {

	public String Nome;
	public String Unidade;
	public String Campanha;
	public String Hora;
	
	public String FormatacaoPost(Agendar cliente) {
		String Conteudo = cliente.Nome + " | " + cliente.Unidade + " | " +
        					cliente.Campanha + " | " + cliente.Hora + "\n";
		
		return Conteudo;
		
	}
}
