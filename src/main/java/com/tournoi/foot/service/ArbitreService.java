package com.tournoi.foot.service;

import java.util.List;

import com.tournoi.foot.model.Arbitre;

public interface ArbitreService {

	public List<Arbitre> getAllArbitres();
	public Arbitre findArbitreById(int id);
	public void addArbitre(Arbitre arbitre);
	public void updateArbitre(Arbitre arbitre);
	public void deleteArbitre(int id);
	
}
