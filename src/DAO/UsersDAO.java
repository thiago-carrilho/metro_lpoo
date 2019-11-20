package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import database.MySQL;
import model.AbstractUsers;
import model.UserCentral;
import model.UserFiscal;
import model.UserPassageiro;
import model.Users;

public class UsersDAO implements InterfaceDAO<AbstractUsers> {

	public UsersDAO() {
		
	}

	@Override
	public void listarTodos() {
		// TODO Auto-generated method stub
//		for (Users abstractUsers : users) {
//			System.out.println(abstractUsers.toString());
//		}
	}

	@Override
	public void add(AbstractUsers obj) throws Exception {
		// TODO Auto-generated method stub
		PreparedStatement presql = null;
		if(obj instanceof UserPassageiro) {
			 presql = MySQL.getConnection()
					.prepareStatement("INSERT INTO Passageiro (nomePassageiro,emailPassageiro,senhaPassageiro) values(?,?,?)");
			}
		else if(obj instanceof UserCentral) {
			presql = MySQL.getConnection()
					.prepareStatement("INSERT INTO Central (nomeCentral,emailCentral,senhaCentral) values(?,?,?)");	
		}
		presql.setString(1, obj.getNome());
		presql.setString(2, obj.getEmail());
		presql.setString(3, obj.getSenha());
		MySQL.setData(presql);		
	}
		
	@Override
	public void update(AbstractUsers obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(AbstractUsers obj) {
		// TODO Auto-generated method stub

	}
	public String teste() {
		return "OLAAAA";
	}

	public AbstractUsers loginUser(String login, String senha) throws Exception {
		AbstractUsers user = null;
		PreparedStatement sql = MySQL.getConnection()
				.prepareStatement("SELECT nomePassageiro, emailPassageiro FROM Passageiro WHERE emailPassageiro=? AND senhaPassageiro=?");
		sql.setString(1, login);
		sql.setString(2, senha);
		ResultSet rs = MySQL.getData(sql);
		if(rs.next()) {
			user = new UserPassageiro(rs.getString("nomePassageiro"), rs.getString("emailPassageiro"));
			return user;
		}
		sql = MySQL.getConnection()
				.prepareStatement("SELECT nomeFiscal, emailFiscal FROM Fiscal WHERE emailFiscal=? AND senhaFiscal=?");
		sql.setString(1, login);
		sql.setString(2, senha);
		rs = MySQL.getData(sql);
		if(rs.next()) {
			user = new UserFiscal(rs.getString("nomeFiscal"), rs.getString("emailFiscal"));
			return user;
		}
		sql = MySQL.getConnection()
				.prepareStatement("SELECT nomeCentral,emailCentral FROM Condutor WHERE emailCentral=? AND senhaCentral=?");
		sql.setString(1, login);
		sql.setString(2, senha);
		rs = MySQL.getData(sql);
		if(rs.next()) {
			user = new UserCentral(rs.getString("nomeCentral"), rs.getString("emailCentral"));
			return user;
		}		 
		return null;
	}


	@Override
	public void getById(int id) {
		// TODO Auto-generated method stub
		
	}
	
	public int getUserId(AbstractUsers user) {
		try {
		PreparedStatement presql = null;
		if(user instanceof UserPassageiro) {
			 presql = MySQL.getConnection()
					.prepareStatement("SELECT idPassageiro FROM Passageiro WHERE emailPassageiro=? AND nomePassageiro=?");
			}
		else if(user instanceof UserCentral) {
			presql = MySQL.getConnection()
					.prepareStatement("SELECT idCentral FROM Passageiro WHERE emailCentral=? AND nomeCentral=?");
		}
		else if(user instanceof UserFiscal) {
			presql = MySQL.getConnection()
					.prepareStatement("SELECT idFiscal FROM Fiscal WHERE emailFiscal=? AND nomeFiscal=?");
		}
		presql.setString(1, user.getEmail());
		presql.setString(2, user.getNome());
		ResultSet rs = MySQL.getData(presql);
		if(rs.next()) {
			if(user instanceof UserPassageiro) {
				return rs.getInt("idPassageiro");
			}
			else if(user instanceof UserCentral) {
				return rs.getInt("idCentral");
			}
			else if(user instanceof UserFiscal) {
				return rs.getInt("idFiscal");
			}
		}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	
}
