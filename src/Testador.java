import java.io.StringWriter;
import java.io.Writer;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.ResultSet;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import org.jgrapht.Graph;
import org.jgrapht.alg.connectivity.KosarajuStrongConnectivityInspector;
import org.jgrapht.alg.interfaces.ShortestPathAlgorithm.SingleSourcePaths;
import org.jgrapht.alg.interfaces.StrongConnectivityAlgorithm;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleDirectedWeightedGraph;
import org.jgrapht.io.ComponentNameProvider;
import org.jgrapht.io.DOTExporter;
import org.jgrapht.io.ExportException;
import org.jgrapht.io.GraphExporter;

import DAO.InterfaceDAO;
import DAO.ReclamacoesDAO;
import DAO.EstacaoDAO;
import DAO.UsersDAO;
import controller.Menu;
import controller.UsersControler;
import database.mysql;
import model.Users;
import model.AbstractUsers;
import model.Linha;
import model.Reclamacao;
import model.Trem;
import model.UserCentral;
import model.UserCondutor;
import model.UserPassageiro;

public class Testador {
	private ReclamacoesDAO reclamacoes = new ReclamacoesDAO();
	private UsersDAO usuarios = new UsersDAO();
	private EstacaoDAO trens = new EstacaoDAO();
	private AbstractUsers user;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		Testador teste = new Testador();
		
		teste.testaUsuarios(in);
		in.close();
	}
	
	
	
	public void testaUsuarios(Scanner in) throws Exception {
		user = usuarios.loginUser("tico@gmail.com", "carrilho");
		System.out.println(user);
		UsersControler controller = new UsersControler(reclamacoes, in, user, usuarios);
		controller.listarOpcoes();
		controller.executarOpcao(1);
//		UserPassageiro a = new UserPassageiro("Thiago Carrilho","tico@gmail.com", "carrilho");
//		usuarios.add(a);
		
	}
	public void testaGraph() {
//		Linha a = new Linha("testeeeee");
//		a.loadAllStations();
		EstacaoDAO a = new EstacaoDAO();
		a.carregarEstacoes();
		Linha b = new Linha("a");
		b.loadAllStations(a);
		b.shortestPath(a,"Curado","Recife");
	}
	public void testaReclamacao() {
		
//		Reclamacao reclamacao1 = new Reclamacao("Motorista bateu", "Hoje", "teste");
//		Reclamacao reclamacao2 = new Reclamacao("Motorista parou", "ontem", "teste");
//		Reclamacao reclamacao3 = new Reclamacao("Motorista correu muito", "Duas Semanas", "reclamacao");
//		reclamacoes.add(reclamacao1);
//		reclamacoes.add(reclamacao2);
//		reclamacoes.add(reclamacao3);
//		reclamacoes.listarTodos();
	}

}
