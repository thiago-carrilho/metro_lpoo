package model;

import DAO.UsersDAO;
import controller.Menu;

public abstract class AbstractUsers {
	private String nome;
	private String email;
	private String senha;
	
	public AbstractUsers(String nome, String email, String senha) {
		this.nome = nome;
		this.email = email;
		this.senha = senha;
	}
	public AbstractUsers(String nome, String email) {
		this.nome = nome;
		this.email = email;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	@Override
	public String toString() {
		return "AbstractUsers [nome=" + nome + ", email=" + email + "]";
	}

	
	public void criarMenu(Menu menu) {
		//menu.addOpcao("Cadastrar", () -> TODO);
		//menu.addOpcao("Registrar Reclamacao", metodo);
		//menu.addOpcao("Acompanhar Reclamacao", metodo);
		//menu.addOpcao("Calcular Rota", metodo);
		//menu.addOpcao("Estacoes", metodo);


	}
	public void mostrarMenu(Menu menu) {
		menu.listarOpcoes();
	}
}
