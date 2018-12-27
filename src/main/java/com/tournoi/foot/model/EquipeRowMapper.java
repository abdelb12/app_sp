package com.tournoi.foot.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class EquipeRowMapper implements RowMapper<Equipe> {

	@Override
	public Equipe mapRow(ResultSet rs, int rowNum) throws SQLException {
		Equipe equipe = new Equipe();
		equipe.setIdEquipe(rs.getInt("id_equipe"));
		equipe.setNom(rs.getString("nom"));
		equipe.setDateCreation(rs.getString("date_creation"));
		equipe.setIdEntraineur(rs.getInt("id_entraineur"));
		return equipe;
	}

}
