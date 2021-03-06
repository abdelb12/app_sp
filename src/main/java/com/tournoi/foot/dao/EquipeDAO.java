package com.tournoi.foot.dao;

import java.util.List;

import com.tournoi.foot.model.Equipe;

public interface EquipeDAO {

	public List<Equipe> getAllEquipes();
	public Equipe findEquipeById(int id);
	public void addEquipe(Equipe equipe);
	public void updateEquipe(Equipe equipe);
	public void deleteEquipe(int id);
	public void validate();
	
}
