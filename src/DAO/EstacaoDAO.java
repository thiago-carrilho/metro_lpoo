package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import database.MySQL;
import model.Estacao;
import model.Reclamacao;
import model.Trem;

public class EstacaoDAO implements InterfaceDAO<Estacao>{
	
	private LinkedHashMap<String,Estacao> listaEstacao = new LinkedHashMap<String,Estacao>();
	
	public EstacaoDAO() {
		
	}
	public void carregarEstacoes() {
		try {
		for (int i = 1; i <=3; i++) {
			PreparedStatement sql = MySQL.getConnection()
					.prepareStatement("SELECT p.*, pt.Linhas_idLinhas " + 
							"FROM Estacao p " + 
							"JOIN Estacao_has_Linhas pt ON p.idEstacao = pt.Estacao_idEstacao " + 
							"JOIN Linhas t ON pt.Linhas_idLinhas = t.idLinhas " + 
							"where t.idLinhas=? " + 
							"order by pt.Estacao_idEstacao");
			sql.setInt(1, i);
			ResultSet rs = MySQL.getData(sql);
			while(rs.next()) {
				String nome = rs.getString("nomeEstacao");
				if(listaEstacao.get(nome) != null) {
					listaEstacao.get(nome).addLinha(rs.getInt("Linhas_idLinhas"));
				}
				else {
					listaEstacao.put(nome,new Estacao(nome, rs.getInt("Linhas_idLinhas")));
				}
			}
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public void listarTodos() {
		// TODO Auto-generated method stub
		for (String estacao : listaEstacao.keySet()) {
			System.out.println(estacao);
		}
	}

	@Override
	public void add(Estacao obj) throws Exception {
		// TODO Auto-generated method stub
		listaEstacao.put(obj.getNome(),obj);
	}

	@Override
	public void update(Estacao obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Estacao obj) {
		// TODO Auto-generated method stub
	}

	@Override
	public void getById(int id) {
		// TODO Auto-generated method stub
		
	}
	public Estacao get(String nome) {
		return listaEstacao.get(nome);
	}
	public Estacao getEstacaoAnteriorDaLinha(int linha) {
		for (Estacao iterable_element : listaEstacao.values()) {
			if(iterable_element.getLinhas().contains(linha)) {
				return iterable_element;
			}
		}
		return null;
	}
	public Collection<Estacao> getAll() {
		// TODO Auto-generated method stub
		return listaEstacao.values();
	}
	
}
