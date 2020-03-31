package it.polito.tdp.spellchecker.model;

public class RichWord {
	String parola;
	boolean parolag;
	public RichWord(String parola) {
		super();
		this.parola = parola;
		this.parolag = true;
	}
	public String getParola() {
		return parola;
	}
	public void setParola(String parola) {
		this.parola = parola;
	}
	public boolean isParolag() {
		return parolag;
	}
	public void setParolag(boolean parolag) {
		this.parolag = parolag;
	}

	
	
	
}