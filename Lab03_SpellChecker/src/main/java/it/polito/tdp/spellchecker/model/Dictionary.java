package it.polito.tdp.spellchecker.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

public class Dictionary {
	TreeMap<String,RichWord> dizionario=new TreeMap<>();
	public void loadDictionary(String language) {
		
		String nomeFile=language;
		try {
			FileReader fr= new FileReader(nomeFile);
		   BufferedReader br= new BufferedReader(fr);
		   String word;
		   while((word=br.readLine())!=null) {
			   String array[] =word.split("\n");
				for(String s : array) {
					RichWord r = new RichWord(s);
					dizionario.put(s, r);
				}
			}
			fr.close();
			br.close();
	}catch(IOException e) {
			System.out.println("Errore file\n");
		}
		

}
	public List <RichWord> spellCheckText(String inputText) {
			List<RichWord> l =  new LinkedList <> ();
			inputText = inputText . replaceAll ( " [., \\ / #?! $% \\ ^ & \\ * ;: {} = \\ -_` ~ () \\ [ \\ ] \" ] " , " " );
			String array [] = inputText . toLowerCase () . split ( "  " );
			for(String s : array) {
				if (!this.dizionario.containsKey(s)) {
					RichWord tempR = new RichWord(s) ;
					tempR.setParolag(false);
					l.add(tempR);
				}
			}
		return l;
		}
}

