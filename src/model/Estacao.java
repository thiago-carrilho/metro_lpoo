package model;

import java.util.ArrayList;
import java.util.List;

public class Estacao {
	private String nome;
	private List<Integer> linhas = new ArrayList<Integer>();
	

	public Estacao(String nome, int linha) {
		this.nome = nome;
		this.linhas.add(linha);
	}
	public List<Integer> getLinhas() {
		return linhas;
	}
	public void setLinhas(List<Integer> linhas) {
		this.linhas = linhas;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void addLinha(int linha) {
		linhas.add(linha);
	}
	public int getQntLinhas() {
		return linhas.size();
	}
	@Override
	public String toString() {
		String temp = nome.replaceAll("\\s","");
		return temp;
	}
	
}
