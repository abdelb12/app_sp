package com.tournoi.foot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tournoi.foot.dao.EquipeDAOImpl;
import com.tournoi.foot.model.Equipe;

@Service
public class EquipeServiceImpl implements EquipeService {

	@Autowired
	private EquipeDAOImpl equipeDAO;
	
	@Override
	public List<Equipe> getAllEquipes() {
		return equipeDAO.getAllEquipes();
	}

	@Override
	public Equipe findEquipeById(int id) {
		return equipeDAO.findEquipeById(id);
	}

	@Override
	public void addEquipe(Equipe equipe) {
		equipeDAO.addEquipe(equipe);
	}

	@Override
	public void updateEquipe(Equipe equipe) {
		equipeDAO.updateEquipe(equipe);
	}

	@Override
	public void deleteEquipe(int id) {
		equipeDAO.deleteEquipe(id);
	}

}
