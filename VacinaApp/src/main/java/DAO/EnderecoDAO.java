package DAO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EnderecoDAO {

	public boolean SalvarEndereco (String conteudo) throws IOException{
        try {
       	 FileWriter file = new FileWriter("C:\\Users\\Pc\\eclipse-workspace\\VacinaApp\\Arquivos\\Endereco.txt",true);
            file.write( conteudo);
            file.close();
            
            return true;
            
		} catch (Exception e) {
			
			
		}
        return false;
   }
  
  public  List<String> LerDadosEndereco () throws FileNotFoundException, IOException
   {
       List<String> dados = new ArrayList<>();

       File arquivo = new File("C:\\Users\\Pc\\eclipse-workspace\\VacinaApp\\Arquivos\\Endereco.txt");
       if (arquivo.exists()) {
           String dadosContass = "";
           try {
               BufferedReader in = new BufferedReader(new FileReader(arquivo));

               while (in.ready()) {
               dadosContass = in.readLine();  
              
               dados.add(dadosContass);
               }
               in.close();
           } catch (IOException ex) {
           
       }
      
       }
        return dados;  
   }
}
