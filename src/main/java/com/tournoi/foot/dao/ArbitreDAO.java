package com.tournoi.foot.dao;

import java.util.List;

import com.tournoi.foot.model.Arbitre;

public interface ArbitreDAO {
	
	public List<Arbitre> getAllArbitres();
	public Arbitre findArbitreById(int id);
	public void addArbitre(Arbitre arbitre);
	public void updateArbitre(Arbitre arbitre);
	public void deleteArbitre(int id);

}
