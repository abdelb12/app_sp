package com.tournoi.foot.model;

public class Equipe {
	private Integer idEquipe;
	private String nom;
	private String dateCreation;
	private Integer idEntraineur;
	
	public Integer getIdEquipe() {
		return idEquipe;
	}
	public void setIdEquipe(Integer idEquipe) {
		this.idEquipe = idEquipe;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(String dateCreation) {
		this.dateCreation = dateCreation;
	}
	public Integer getIdEntraineur() {
		return idEntraineur;
	}
	public void setIdEntraineur(Integer idEntraineur) {
		this.idEntraineur = idEntraineur;
	}
	
	@Override
	public String toString() {
		return "Equipe [idEquipe=" + idEquipe + ", nom=" + nom + ", dateCreation=" + dateCreation + ", idEntraineur="
				+ idEntraineur + "]";
	}
	
}
