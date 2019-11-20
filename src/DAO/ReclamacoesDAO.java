package DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import database.MySQL;
import model.Reclamacao;
import model.UserCentral;
import model.UserPassageiro;

public class ReclamacoesDAO implements InterfaceDAO<Reclamacao>{
	private List<Reclamacao> reclamacoes = new ArrayList<Reclamacao>();
	
	public ReclamacoesDAO() {
		// TODO Auto-generated constructor stub
		
	}
	
	@Override
	public void listarTodos() {
		// TODO Auto-generated method stub
		for (Reclamacao reclamacao : reclamacoes) {
			System.out.println(reclamacao.toString());
		}
	}

	@Override
	public void add(Reclamacao obj) throws Exception {
		// TODO Auto-generated method stub
		Timestamp sqlNow = Timestamp.valueOf(obj.getDataReclamacao());
		if(obj.getIdPassageiroReclamou()!=-1) {
			PreparedStatement presql = MySQL.getConnection()
						.prepareStatement("INSERT INTO Reclamacoes (descricaoReclamacao,dataReclamacao,tipoReclamacao,idPassageiroReclamou) values(?,?,?,?)");
			presql.setString(1, obj.getTextoReclamacao());
			presql.setTimestamp(2, sqlNow);
			presql.setString(3, obj.getTipoReclamacao());
			presql.setInt(4,obj.getIdPassageiroReclamou());
			MySQL.setData(presql);
		}
		else if(obj.getIdCentralReclamou()!=-1) {
			PreparedStatement presql = MySQL.getConnection()
					.prepareStatement("INSERT INTO Reclamacoes (descricaoReclamacao,dataReclamacao,tipoReclamacao,idCentralReclamou) values(?,?,?,?)");
			presql.setString(1, obj.getTextoReclamacao());
			presql.setTimestamp(2, sqlNow);
			presql.setString(3, obj.getTipoReclamacao());
			presql.setInt(4,obj.getIdCentralReclamou());
			MySQL.setData(presql);
		}
		else if(obj.getIdFiscalReclamou()!=-1) {
			PreparedStatement presql = MySQL.getConnection()
					.prepareStatement("INSERT INTO Reclamacoes (descricaoReclamacao,dataReclamacao,tipoReclamacao,idFiscalReclamou) values(?,?,?,?)");
			presql.setString(1, obj.getTextoReclamacao());
			presql.setTimestamp(2, sqlNow);
			presql.setString(3, obj.getTipoReclamacao());
			presql.setInt(4,obj.getIdFiscalReclamou());
			MySQL.setData(presql);
		}
	}

	@Override
	public void update(Reclamacao obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Reclamacao obj) {
		// TODO Auto-generated method stub
		reclamacoes.remove(obj);
	}

	public List getAllByUserId(int userId) {
		//!!TODO 
		return null;
	}

	@Override
	public void getById(int id) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
