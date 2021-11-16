package DAO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LoginDAO {
	
	public void SalvarLogin (String conteudo) throws IOException{
		
        try {
        	
       	 FileWriter file = new FileWriter("C:\\Users\\Pc\\eclipse-workspace\\VacinaApp\\Arquivos\\Login.txt");
            file.write( conteudo);
            file.close();
            
		} catch (Exception e) {
			
			
		}
   }
  
	
	public  String LerDadosLogin () throws FileNotFoundException, IOException
    {
		String dadosContass = "";
        File arquivo = new File("C:\\Users\\Pc\\eclipse-workspace\\VacinaApp\\Arquivos\\Login.txt");
        if (arquivo.exists()) {
            try {
                BufferedReader in = new BufferedReader(new FileReader(arquivo));

                dadosContass = in.readLine();  

                
                in.close();
            } catch (IOException ex) {
            
        }
       
        }
         return dadosContass;  
    }
}
