package com.tournoi.foot.dao;

import java.util.List;

import com.tournoi.foot.model.Entraineur;

public interface EntraineurDAO {

	public List<Entraineur> getAllEntraineur();
	public Entraineur findEntraineurById(int id);
	public void addEntraineur(Entraineur entraineur);
	public void updateEntraineur(Entraineur entraineur);
	public void deleteEntraineur(int id);
	void validate();

}
