package controller;

import java.util.Scanner;

import DAO.ReclamacoesDAO;
import DAO.UsersDAO;
import model.AbstractUsers;

public class MenuWrapper {
	private ReclamacoesDAO ReclamacaoDAO;
	private UsersDAO userDAO;
	public String ola;
	public MenuWrapper() {
		
	}
	public ReclamacoesDAO getReclamacaoDAO() {
		return ReclamacaoDAO;
	}
	public void setReclamacaoDAO(ReclamacoesDAO reclamacaoDAO) {
		ReclamacaoDAO = reclamacaoDAO;
	}
	public UsersDAO getUserDAO() {
		return userDAO;
	}
	public void setUserDAO(UsersDAO userDAO) {
		this.userDAO = userDAO;
	}
	
}
