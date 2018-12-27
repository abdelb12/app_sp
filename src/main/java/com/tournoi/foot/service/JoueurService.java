package com.tournoi.foot.service;

import java.util.List;

import com.tournoi.foot.model.Joueur;

public interface JoueurService {
	
	public List<Joueur> getAllJoueur();
	public Joueur findJoueurById(int id);
	public void addJoueur(Joueur joueur);
	public void updateJoueur(Joueur joueur);
	public void deleteJoueur(int id);

}
