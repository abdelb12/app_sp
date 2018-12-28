package com.tournoi.foot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tournoi.foot.dao.EntraineurDAOImpl;
import com.tournoi.foot.model.Entraineur;

@Service
public class EntraineurServiceImpl implements EntraineurService {

	@Autowired
	private EntraineurDAOImpl entraineurDAO;
	
	@Override
	public List<Entraineur> getAllEntraineurs() {
		return entraineurDAO.getAllEntraineur();
	}

	@Override
	public Entraineur findEntraineurById(int id) {
		return entraineurDAO.findEntraineurById(id);
	}

	@Override
	public void addEntraineur(Entraineur entraineur) {
		entraineurDAO.addEntraineur(entraineur);
	}

	@Override
	public void updateEntraineur(Entraineur entraineur) {
		entraineurDAO.updateEntraineur(entraineur);
	}

	@Override
	public void deleteEntraineur(int id) {
		entraineurDAO.deleteEntraineur(id);
	}

}
