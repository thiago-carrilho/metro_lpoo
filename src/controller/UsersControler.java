package controller;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Scanner;

import DAO.ReclamacoesDAO;
import DAO.UsersDAO;
import model.AbstractUsers;
import model.Reclamacao;
import model.UserCentral;
import model.UserEnum;
import model.UserFiscal;
import model.UserPassageiro;

public class UsersControler extends Menu {
	private ReclamacoesDAO ReclamacaoDAO;
	private UsersDAO userDAO;
	private Scanner in;
	private MenuWrapper wrapper;
	private AbstractUsers user;
	public UsersControler(ReclamacoesDAO ReclamacaoDAO, Scanner in, AbstractUsers user, UsersDAO userDAO) {
		super();
		try {
			this.ReclamacaoDAO=ReclamacaoDAO;
			this.wrapper = new MenuWrapper();
			this.userDAO = userDAO;
			this.in = in;
			this.user=user;
			super.addMenu();
//			super.addOpcao("Realizar Login", () -> userDAO.loginUser(login, senha));
			super.addOpcao("Realizar Login",
					userDAO.getClass().getDeclaredMethod("teste"), userDAO,wrapper);

//			super.addMenu("Realizar Cadastro", () -> );

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void criarReclamacaoEstacao(Scanner in) {
		int idUsuario = userDAO.getUserId(user);
		Reclamacao reclamacao = null;
		if(user instanceof UserPassageiro) {
			reclamacao = new Reclamacao("TEXTO", "ASSALTO", UserEnum.PASSAGEIRO, idUsuario,-1,-1);	
		}
		if(user instanceof UserCentral) {
			reclamacao = new Reclamacao("TEXTO", "ASSALTO", UserEnum.CENTRAL, -1, idUsuario, -1);	
		}
		if(user instanceof UserFiscal) {
			reclamacao = new Reclamacao("TEXTO", "ASSALTO", UserEnum.FISCAL, -1, -1, idUsuario);	
		}
		
		try {
			ReclamacaoDAO.add(reclamacao);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void listarReclamacoes(int userId) {
		ReclamacoesDAO dao = new ReclamacoesDAO();
		List listaReclamacoesUser = dao.getAllByUserId(userId);
//		for (Reclamacao listaReclamacoes : listaReclamacoesUser) {
//			
//		}
	}
	public void teste() {
		System.out.println(wrapper.ola);
	}
	public void acompanharReclamacao(int reclamacaoId) {
		
	}
}
