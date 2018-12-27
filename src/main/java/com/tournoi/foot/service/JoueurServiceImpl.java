package com.tournoi.foot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tournoi.foot.dao.JoueurDAOImpl;
import com.tournoi.foot.model.Joueur;

@Service
public class JoueurServiceImpl implements JoueurService{

	@Autowired
	private JoueurDAOImpl joueurDAO;
	
	@Override
	public List<Joueur> getAllJoueur() {
		return joueurDAO.getAllJoueur();
	}

	@Override
	public Joueur findJoueurById(int id) {
		return joueurDAO.findJoueurById(id);
	}

	@Override
	public void addJoueur(Joueur joueur) {
		joueurDAO.addJoueur(joueur);
	}

	@Override
	public void updateJoueur(Joueur joueur) {
		joueurDAO.updateJoueur(joueur);
	}

	@Override
	public void deleteJoueur(int id) {
		joueurDAO.deleteJoueur(id);
	}

}
