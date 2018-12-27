package com.tournoi.foot.model;

import org.springframework.stereotype.Component;

@Component
public class Entraineur {
	private Integer idEntraineur;
	private String prenom;
	private String nom;
	private Integer age;
	private float taille;
	private String dateNaissance;
	private Integer idEquipe;
	
	public Integer getIdEntraineur() {
		return idEntraineur;
	}
	public void setIdEntraineur(Integer idEntraineur) {
		this.idEntraineur = idEntraineur;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public float getTaille() {
		return taille;
	}
	public void setTaille(float taille) {
		this.taille = taille;
	}
	public String getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(String dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	public Integer getIdEquipe() {
		return idEquipe;
	}
	public void setIdEquipe(Integer idEquipe) {
		this.idEquipe = idEquipe;
	}
	
	@Override
	public String toString() {
		return "Entraineur [idEntraineur=" + idEntraineur + ", prenom=" + prenom + ", nom=" + nom + ", age=" + age
				+ ", taille=" + taille + ", dateNaissance=" + dateNaissance + ", idEquipe=" + idEquipe + "]";
	}
	
}
