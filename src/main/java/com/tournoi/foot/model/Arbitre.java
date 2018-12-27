package com.tournoi.foot.model;

import org.springframework.stereotype.Component;

@Component
public class Arbitre {
	
	private Integer idArbitre;
	private String prenom;
	private String nom;
	private Integer age;
	private float taille;
	private String dateNaissance;
	
	public Integer getIdArbitre() {
		return idArbitre;
	}
	public void setIdArbitre(Integer idArbitre) {
		this.idArbitre = idArbitre;
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
	
	@Override
	public String toString() {
		return "Arbitre [idArbitre=" + idArbitre + ", prenom=" + prenom + ", nom=" + nom + ", age=" + age + ", taille="
				+ taille + ", dateNaissance=" + dateNaissance + "]";
	}
	
}
