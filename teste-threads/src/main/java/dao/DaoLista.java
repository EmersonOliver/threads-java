package dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class DaoLista {
	
	public List<String> getLista(){
		BufferedReader br =null;
		try {
			List<String> resultLista = new ArrayList<String>();
			
			File file = new File("C:/dados/dados.txt");
			br = new BufferedReader(new FileReader(file));
			String linha;
			while((linha = br.readLine())!=null) {
				resultLista.add(linha);
			}
			br.close();
			return resultLista;
		} catch (Exception e) {
			return new ArrayList<>();
		}
	}

}
