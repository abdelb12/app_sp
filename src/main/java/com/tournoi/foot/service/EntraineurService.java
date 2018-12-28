package com.tournoi.foot.service;

import java.util.List;

import com.tournoi.foot.model.Entraineur;

public interface EntraineurService {

	public List<Entraineur> getAllEntraineurs();
	public Entraineur findEntraineurById(int id);
	public void addEntraineur(Entraineur entraineur);
	public void updateEntraineur(Entraineur entraineur);
	public void deleteEntraineur(int id);
	
}
