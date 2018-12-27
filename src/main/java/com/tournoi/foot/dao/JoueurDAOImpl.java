package com.tournoi.foot.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tournoi.foot.model.Joueur;
import com.tournoi.foot.model.JoueurRowMapper;

@Transactional
@Repository
public class JoueurDAOImpl implements JoueurDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Joueur> getAllJoueur() {
		String query = "SELECT * FROM joueur";
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		RowMapper<Joueur> rowMapper = context.getBean("joueurRowMapper", JoueurRowMapper.class);
		List<Joueur> list = jdbcTemplate.query(query, rowMapper);
		System.out.println(list.toString());
		context.close();
		return list;
	}

	@Override
	public Joueur findJoueurById(int id) {
		String query = "SELECT * FROM joueur WHERE id_joueur = ?";
		RowMapper<Joueur> rowMapper = new BeanPropertyRowMapper<Joueur>(Joueur.class);
		Joueur joueur = jdbcTemplate.queryForObject(query, rowMapper, id);
		return joueur;
	}

	@Override
	public void addJoueur(Joueur joueur) {
		String query = "INSERT INTO joueur(prenom, nom, age, taille, poste, date_naissance) VALUES(?, ?, ?, ?, ?, ?)";
		jdbcTemplate.update(query, joueur.getPrenom(), joueur.getNom(), joueur.getAge(), joueur.getTaille(), joueur.getPoste(), joueur.getDateNaissance());
	}

	@Override
	public void updateJoueur(Joueur joueur) {
		String query = "UPDATE joueur SET prenom=?, nom=?, age=?, taille=?, poste=?, date_naissance=? WHERE id_joueur=?";
		jdbcTemplate.update(query, joueur.getPrenom(), joueur.getNom(), joueur.getAge(), joueur.getTaille(), joueur.getPoste(), joueur.getDateNaissance(), joueur.getIdJoueur());
	}

	@Override
	public void deleteJoueur(int id) {
		String query = "DELETE FROM joueur WHERE id_joueur=?";
		jdbcTemplate.update(query, id);
	}

}
