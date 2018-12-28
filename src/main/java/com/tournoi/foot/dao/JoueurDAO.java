package com.tournoi.foot.dao;

import java.util.List;

import com.tournoi.foot.model.Joueur;

public interface JoueurDAO {
	
	public List<Joueur> getAllJoueur();
	public Joueur findJoueurById(int id);
	public void addJoueur(Joueur joueur);
	public void updateJoueur(Joueur joueur);
	public void deleteJoueur(int id);
	void validate();

}
