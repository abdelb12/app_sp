package com.tournoi.foot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tournoi.foot.dao.ArbitreDAOImpl;
import com.tournoi.foot.model.Arbitre;

@Service
public class ArbitreServiceImpl implements ArbitreService {

	@Autowired
	private ArbitreDAOImpl arbitreDAO;
	
	@Override
	public List<Arbitre> getAllArbitres() {
		return arbitreDAO.getAllArbitres();
	}

	@Override
	public Arbitre findArbitreById(int id) {
		return arbitreDAO.findArbitreById(id);
	}

	@Override
	public void addArbitre(Arbitre arbitre) {
		arbitreDAO.addArbitre(arbitre);
	}

	@Override
	public void updateArbitre(Arbitre arbitre) {
		arbitreDAO.updateArbitre(arbitre);
	}

	@Override
	public void deleteArbitre(int id) {
		arbitreDAO.deleteArbitre(id);
	}

}
