package model;

public class Trem 
//implements Comparable<Trem>
{
	private int idTrem;
	private String nomeTrem;
	private int idOperador;
	
	public Trem(int idTrem, String nomeTrem, int idOperador) {
		this.idTrem = idTrem;
		this.nomeTrem = nomeTrem;
		this.idOperador = idOperador;
	}



	public int getIdTrem() {
		return idTrem;
	}



	public void setIdTrem(int idTrem) {
		this.idTrem = idTrem;
	}



	public String getNomeTrem() {
		return nomeTrem;
	}



	public void setNomeTrem(String nomeTrem) {
		this.nomeTrem = nomeTrem;
	}



	public int getIdOperador() {
		return idOperador;
	}



	public void setIdOperador(int idOperador) {
		this.idOperador = idOperador;
	}

	@Override
	public String toString() {
		return "Trem [idTrem=" + idTrem + ", nomeTrem=" + nomeTrem + ", idOperador=" + idOperador + ", idReclamacoes="
				 + "]";
	}

//	@Override
//	public int compareTo(Trem trem) {
//		// TODO Auto-generated method stub
//		if(this.quantReclamacoes<trem.getQuantReclamacoes()) {
//			return -1;
//		}
//		if(this.quantReclamacoes>trem.getQuantReclamacoes()) {
//			return 1;
//		}
//		return 0;
//	}


	
	
}
