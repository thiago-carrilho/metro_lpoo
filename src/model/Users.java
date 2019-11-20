package model;

import DAO.ReclamacoesDAO;
import DAO.UsersDAO;

public class Users {
	private int id;
	private UserEnum tipo;
	private String email;
	private String senha;
	
	public Users(int id, UserEnum tipo,String email, String senha) {
		this.id = id;
		this.tipo = tipo;
		this.email = email;
		this.senha = senha;
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
	
	
	@Override
	public String toString() {
		return "Users [id=" + id + ", email=" + email + ", senha=" + senha + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
