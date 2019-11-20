package model;

import java.io.StringWriter;
import java.io.Writer;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

import org.jgrapht.Graph;
import org.jgrapht.GraphPath;
import org.jgrapht.alg.interfaces.ShortestPathAlgorithm.SingleSourcePaths;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultDirectedWeightedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleDirectedWeightedGraph;
import org.jgrapht.io.ComponentNameProvider;
import org.jgrapht.io.DOTExporter;
import org.jgrapht.io.ExportException;
import org.jgrapht.io.GraphExporter;

import DAO.EstacaoDAO;
import database.MySQL;

public class Linha {
	private String nome;
	private DefaultDirectedWeightedGraph<Estacao, DefaultWeightedEdge> estacoes = 
            new DefaultDirectedWeightedGraph<Estacao, DefaultWeightedEdge>
            (DefaultWeightedEdge.class); 

	public Linha(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void shortestPath(EstacaoDAO dao, String origem, String destino) {
		DijkstraShortestPath<Estacao, DefaultWeightedEdge> alg =
	            new DijkstraShortestPath<>(estacoes);
	        SingleSourcePaths<Estacao, DefaultWeightedEdge> caminho = alg.getPaths(dao.get(origem));
	        System.out.println(caminho.getPath(dao.get(destino)) + "\n");
	}

	public void loadAllStations(EstacaoDAO dao) {
		try {
			Estacao anterior = null, dividora = null;
			Iterator<Estacao> temp2 = new ArrayList<Estacao>(dao.getAll()).iterator();
			HashMap<Estacao, Integer> vezesapareceu = new HashMap<Estacao, Integer>();
			for (int i = 1; i <= 3; i++) {
				for (int j = 0; temp2.hasNext(); j++) {
					Estacao estacao = temp2.next();
					int n = 0;
					
					if(anterior!=null) {
					
					for (Integer estacao2 : anterior.getLinhas()) {
						if(!estacao.getLinhas().contains(estacao2)) {
							n = 1;
						}
						else {
							break;
						}
					}
					}
					if(n==1) {
						anterior=dividora;
					}
					if(vezesapareceu.containsKey(estacao)) {
						vezesapareceu.put(estacao, vezesapareceu.get(estacao)+1);
						anterior=estacao;
					}else {
						vezesapareceu.put(estacao, 1);
						estacoes.addVertex(estacao);
					if(anterior!=null) {
						DefaultWeightedEdge ida = estacoes.addEdge(estacao, anterior);
						estacoes.setEdgeWeight(ida, 1.0);
						DefaultWeightedEdge volta = estacoes.addEdge(estacao, anterior);
						//estacoes.setEdgeWeight(volta, 1.0); !!TODO Not working volta
					if(estacao.getQntLinhas()>=2) {
						dividora = estacao;
					}
					}else {
						dividora = estacao;
					}
					
					anterior = estacao;
					temp2.remove();
					}
					
				}
				}
			
		}catch(

	Exception e)
	{
		e.printStackTrace();
	}

	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Linha [nome=" + nome + ", qntReclamacoes=" + ", estacoes=" + estacoes + "]";
	}

}
