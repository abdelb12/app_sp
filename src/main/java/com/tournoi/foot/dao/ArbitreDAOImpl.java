package com.tournoi.foot.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
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
		String query = "SELECT * FROM arbitre";
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		RowMapper<Arbitre> rowMapper = context.getBean("arbitreRowMapper", ArbitreRowMapper.class);
		List<Arbitre> list = jdbcTemplate.query(query, rowMapper);
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
		/*String query = "INSERT INTO arbitre(prenom, nom, age, taille, date_naissance) VALUES(?, ?, ?, ?, ?)";
		jdbcTemplate.update(query, arbitre.getPrenom(), arbitre.getNom(), arbitre.getAge(), arbitre.getTaille(), arbitre.getDateNaissance());*/
		String query = "INSERT INTO arbitre(prenom, nom, age, taille, date_naissance) VALUES('" + arbitre.getPrenom() + "','" + arbitre.getNom() + "','" + arbitre.getAge() + "','" + arbitre.getTaille() + "','" + arbitre.getDateNaissance() + "')";
		writeToFile(query);
	}

	@Override
	public void updateArbitre(Arbitre arbitre) {
		/*String query = "UPDATE arbitre SET prenom=?, nom=?, age=?, taille=?, date_naissance=? WHERE id_arbitre=?";
		jdbcTemplate.update(query, arbitre.getPrenom(), arbitre.getNom(), arbitre.getAge(), arbitre.getTaille(), arbitre.getDateNaissance(), arbitre.getIdArbitre());*/
		String query = "UPDATE arbitre SET prenom='" + arbitre.getPrenom() + "', nom='" + arbitre.getNom() +"', age='" + arbitre.getAge() + "', taille='" + arbitre.getTaille() + "', date_naissance='" + arbitre.getDateNaissance() + "' WHERE id_arbitre='" + arbitre.getIdArbitre() + "'";
		writeToFile(query);
	}

	@Override
	public void deleteArbitre(int id) {
		/*String query = "DELETE FROM arbitre WHERE id_arbitre=?";
		jdbcTemplate.update(query, id);*/
		String query = "DELETE FROM arbitre WHERE id_arbitre='" + id + "'";
		writeToFile(query);
	}

	@Override
	public void validate() {
		try {
			File f = new File("src/main/java/com/tournoi/foot/log/arbitreSql.txt");
			if (f.exists()) {
				BufferedReader b = new BufferedReader(new FileReader(f));
				String readQuery = "";
				while ((readQuery = b.readLine()) != null) {
					jdbcTemplate.update(readQuery);
				}
				b.close();
				f.delete();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void writeToFile(String query) {
		try {
			FileWriter f = new FileWriter("src/main/java/com/tournoi/foot/log/arbitreSql.txt", true);
			BufferedWriter bw = new BufferedWriter(f);
			bw.write(query);
			bw.newLine();
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
