package com.tournoi.foot.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tournoi.foot.model.Arbitre;
import com.tournoi.foot.model.ArbitreRowMapper;

@Transactional
@Repository
public class ArbitreDAOImpl implements ArbitreDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Arbitre> getAllArbitres() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		String query = "SELECT * FROM arbitre";
		RowMapper<Arbitre> rowMapper = context.getBean("arbitreRowMapper", ArbitreRowMapper.class);
		List<Arbitre> list = jdbcTemplate.query(query, rowMapper);
		System.out.println(list.toString());
		context.close();
		return list;
	}

	@Override
	public Arbitre findArbitreById(int id) {
		String query = "SELECT * FROM arbitre WHERE id_arbitre = ?";
		RowMapper<Arbitre> rowMapper = new BeanPropertyRowMapper<Arbitre>(Arbitre.class);
		Arbitre arbitre = jdbcTemplate.queryForObject(query, rowMapper, id);
		return arbitre;
	}

	@Override
	public void addArbitre(Arbitre arbitre) {
		String query = "INSERT INTO arbitre(prenom, nom, age, taille, date_naissance) VALUES(?, ?, ?, ?, ?)";
		jdbcTemplate.update(query, arbitre.getPrenom(), arbitre.getNom(), arbitre.getAge(), arbitre.getTaille(), arbitre.getDateNaissance());
		
	}

	@Override
	public void updateArbitre(Arbitre arbitre) {
		String query = "UPDATE arbitre SET prenom=?, nom=?, age=?, taille=?, date_naissance=? WHERE id_arbitre=?";
		jdbcTemplate.update(query, arbitre.getPrenom(), arbitre.getNom(), arbitre.getAge(), arbitre.getTaille(), arbitre.getDateNaissance(), arbitre.getIdArbitre());
		
	}

	@Override
	public void deleteArbitre(int id) {
		String query = "DELETE FROM arbitre WHERE id_arbitre=?";
		jdbcTemplate.update(query, id);
	}

}
