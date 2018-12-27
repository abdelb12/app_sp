package com.tournoi.foot.model;

public class Joueur {

	private Integer idJoueur;
	private String prenom;
	private String nom;
	private Integer age;
	private float taille;
	private Integer poste;
	private String dateNaissance;
	private Integer idEquipe;
	
	public Integer getIdJoueur() {
		return idJoueur;
	}

	public void setIdJoueur(Integer idJoueur) {
		this.idJoueur = idJoueur;
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

	public Integer getPoste() {
		return poste;
	}

	public void setPoste(Integer poste) {
		this.poste = poste;
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
		return "Joueur [idJoueur=" + idJoueur + ", prenom=" + prenom + ", nom=" + nom + ", age=" + age + ", taille="
				+ taille + ", poste=" + poste + ", dateNaissance=" + dateNaissance + "]";
	}
	
}
