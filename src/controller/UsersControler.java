package controller;

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
	private AbstractUsers user;
	public UsersControler(ReclamacoesDAO ReclamacaoDAO, Scanner in, AbstractUsers user, UsersDAO userDAO) {
		super();
		this.ReclamacaoDAO=ReclamacaoDAO;
		this.userDAO = userDAO;
		this.in = in;
		this.user=user;
		super.addOpcao("teste", () -> criarReclamacaoEstacao(in));
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
	public void acompanharReclamacao(int reclamacaoId) {
		
	}
}
