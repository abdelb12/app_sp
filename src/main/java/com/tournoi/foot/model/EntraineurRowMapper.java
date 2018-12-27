package com.tournoi.foot.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class EntraineurRowMapper implements RowMapper<Entraineur>{

	@Override
	public Entraineur mapRow(ResultSet rs, int rowNum) throws SQLException {
		Entraineur entraineur = new Entraineur();
		entraineur.setIdEntraineur(rs.getInt("id_entraineur"));
		entraineur.setPrenom(rs.getString("prenom"));
		entraineur.setNom(rs.getString("nom"));
		entraineur.setAge(rs.getInt("age"));
		entraineur.setTaille(rs.getFloat("taille"));
		entraineur.setDateNaissance(rs.getString("date_naissance"));
		entraineur.setIdEquipe(rs.getInt("id_equipe"));
		return entraineur;
	}

}
