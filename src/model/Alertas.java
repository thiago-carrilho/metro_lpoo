package model;

public class Alertas {
	private String text;
	private Linha linha;
	private Estacao estacao;
	
	
	
	
	public Alertas(String text, Estacao estacao) {
		this.text = text;
		this.estacao = estacao;
	}




	public Alertas(String text, Linha linha) {
		this.text = text;
		this.linha = linha;
	}




	public String getText() {
		return text;
	}




	public void setText(String text) {
		this.text = text;
	}




	public Linha getLinha() {
		return linha;
	}




	public void setLinha(Linha linha) {
		this.linha = linha;
	}




	public Estacao getEstacao() {
		return estacao;
	}




	public void setEstacao(Estacao estacao) {
		this.estacao = estacao;
	}




	@Override
	public String toString() {
		return "Alertas [text=" + text + ", linha=" + linha + ", estacao=" + estacao + "]";
	}
	
	

}
