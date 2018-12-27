package com.tournoi.foot.model;

public class Match {

	private Integer idMatch;
	private String resultat;
	private String dateMatch;
	private Integer idArbitre;
	
	public Integer getIdMatch() {
		return idMatch;
	}
	public void setIdMatch(Integer idMatch) {
		this.idMatch = idMatch;
	}
	public String getResultat() {
		return resultat;
	}
	public void setResultat(String resultat) {
		this.resultat = resultat;
	}
	public String getDateMatch() {
		return dateMatch;
	}
	public void setDateMatch(String dateMatch) {
		this.dateMatch = dateMatch;
	}
	public Integer getIdArbitre() {
		return idArbitre;
	}
	public void setIdArbitre(Integer idArbitre) {
		this.idArbitre = idArbitre;
	}
	
	@Override
	public String toString() {
		return "Match [idMatch=" + idMatch + ", resultat=" + resultat + ", dateMatch=" + dateMatch + ", idArbitre="
				+ idArbitre + "]";
	}
	
}
