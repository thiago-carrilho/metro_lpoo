package model;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Reclamacao {	
	private int idReclamacao;
	private String textoReclamacao;
	private String tipoReclamacao;
	private LocalDateTime dataReclamacao;
	private int idPassageiroReclamou;
	private int idFiscalReclamou;
	private int idCentralReclamou;
	//private int idEstacao;
	
	public Reclamacao(String textoReclamacao, String tipoReclamacao, UserEnum tipoUsuario, int idPassageiroReclamou
			, int idCentralReclamou, int idFiscalReclamou) {
		this.textoReclamacao = textoReclamacao;
		this.tipoReclamacao = tipoReclamacao;
		this.dataReclamacao = LocalDateTime.now();
		if(tipoUsuario==UserEnum.PASSAGEIRO) 
			this.idPassageiroReclamou = idPassageiroReclamou;
		if(tipoUsuario==UserEnum.FISCAL)
			this.idFiscalReclamou = idFiscalReclamou;
		if(tipoUsuario==UserEnum.CENTRAL)
			this.idCentralReclamou = idCentralReclamou;

		//this.idEstacao = idEstacao;
	}
	
	public int getIdReclamacao() {
		return idReclamacao;
	}
	public void setIdReclamacao(int idReclamacao) {
		this.idReclamacao = idReclamacao;
	}
	public String getTextoReclamacao() {
		return textoReclamacao;
	}
	public void setTextoReclamacao(String textoReclamacao) {
		this.textoReclamacao = textoReclamacao;
	}
	public String getTipoReclamacao() {
		return tipoReclamacao;
	}
	public void setTipoReclamacao(String tipoReclamacao) {
		this.tipoReclamacao = tipoReclamacao;
	}
	public LocalDateTime getDataReclamacao() {
		return dataReclamacao;
	}
	public void setDataReclamacao(LocalDateTime dataReclamacao) {
		this.dataReclamacao = dataReclamacao;
	}
	public int getIdPassageiroReclamou() {
		return idPassageiroReclamou;
	}
	public void setIdPassageiroReclamou(int idPassageiroReclamou) {
		this.idPassageiroReclamou = idPassageiroReclamou;
	}
	public int getIdFiscalReclamou() {
		return idFiscalReclamou;
	}
	public void setIdFiscalReclamou(int idFiscalReclamou) {
		this.idFiscalReclamou = idFiscalReclamou;
	}
	public int getIdCentralReclamou() {
		return idCentralReclamou;
	}
	public void setIdCentralReclamou(int idCentralReclamou) {
		this.idCentralReclamou = idCentralReclamou;
	}
	@Override
	public String toString() {
		return "Reclamacao [idReclamacao=" + idReclamacao + ", textoReclamacao=" + textoReclamacao + ", tipoReclamacao="
				+ tipoReclamacao + ", dataReclamacao=" + dataReclamacao + ", idPassageiroReclamou="
				+ idPassageiroReclamou + ", idFiscalReclamou=" + idFiscalReclamou + ", idCentralReclamou="
				+ idCentralReclamou + "]";
	}
	
	
	
	
		
	
}
