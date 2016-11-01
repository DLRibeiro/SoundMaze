package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class FazerMapa {
	String content;
	StringTokenizer st;
	ArrayList<Reta> retas;
	int qtdRetas;
	
	public FazerMapa(String caminho) throws IOException{
		this.content = readFile(caminho);
		this.st = new StringTokenizer(this.content);
		this.qtdRetas = Integer.parseInt(st.nextToken());
		for(int i = 0; i < qtdRetas; i++){
			Ponto p1 = new Ponto(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
			Ponto p2 = new Ponto(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
			retas.add(new Reta(p1, p2));
		}
	}
	
	String readFile(String fileName) throws IOException {
	    BufferedReader br = new BufferedReader(new FileReader(fileName));
	    try {
	        StringBuilder sb = new StringBuilder();
	        String line = br.readLine();

	        while (line != null) {
	            sb.append(line);
	            sb.append("\n");
	            line = br.readLine();
	        }
	        return sb.toString();
	    } finally {
	        br.close();
	    }
	}

	public ArrayList<Reta> getRetas() {
		return retas;
	}

	public void setRetas(ArrayList<Reta> retas) {
		this.retas = retas;
	}
	
}
