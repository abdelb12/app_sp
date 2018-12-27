package com.tournoi.foot.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class JoueurRowMapper implements RowMapper<Joueur> {

	@Override
	public Joueur mapRow(ResultSet rs, int rowNum) throws SQLException {
		Joueur joueur = new Joueur();
		joueur.setIdJoueur(rs.getInt("id_joueur"));
		joueur.setPrenom(rs.getString("prenom"));
		joueur.setNom(rs.getString("nom"));
		joueur.setAge(rs.getInt("age"));
		joueur.setTaille(rs.getFloat("taille"));
		joueur.setPoste(rs.getInt("poste"));
		joueur.setDateNaissance(rs.getString("date_naissance"));
		joueur.setIdEquipe(rs.getInt("id_equipe"));
		return joueur;
	}
	
}
