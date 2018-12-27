package com.tournoi.foot.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class ArbitreRowMapper implements RowMapper<Arbitre> {

	@Override
	public Arbitre mapRow(ResultSet rs, int rowNum) throws SQLException {
		Arbitre arbitre = new Arbitre();
		arbitre.setIdArbitre(rs.getInt("id_arbitre"));
		arbitre.setPrenom(rs.getString("prenom"));
		arbitre.setNom(rs.getString("nom"));
		arbitre.setAge(rs.getInt("age"));
		arbitre.setTaille(rs.getFloat("taille"));
		arbitre.setDateNaissance(rs.getString("date_naissance"));
		return arbitre;
	}

}
