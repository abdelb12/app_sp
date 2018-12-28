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

import com.tournoi.foot.model.Entraineur;
import com.tournoi.foot.model.EntraineurRowMapper;

@Transactional
@Repository
public class EntraineurDAOImpl implements EntraineurDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Entraineur> getAllEntraineur() {
		String query = "SELECT * FROM entraineur";
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		RowMapper<Entraineur> rowMapper = context.getBean("entraineurRowMapper", EntraineurRowMapper.class);
		List<Entraineur> list = jdbcTemplate.query(query, rowMapper);
		System.out.println(list.toString());
		context.close();
		return list;
	}

	@Override
	public Entraineur findEntraineurById(int id) {
		String query = "SELECT * FROM entraineur WHERE id_entraineur = ?";
		RowMapper<Entraineur> rowMapper = new BeanPropertyRowMapper<Entraineur>(Entraineur.class);
		Entraineur entraineur = jdbcTemplate.queryForObject(query, rowMapper, id);
		return entraineur;
	}

	@Override
	public void addEntraineur(Entraineur entraineur) {
		String query = "INSERT INTO entraineur(prenom, nom, age, taille, date_naissance, id_equipe) VALUES('" + entraineur.getPrenom() + "','" + entraineur.getNom() + "','" + entraineur.getAge() + "','" + entraineur.getTaille() + "','" + entraineur.getDateNaissance() + "','" + entraineur.getIdEquipe() + "')";
		writeToFile(query);
	}

	@Override
	public void updateEntraineur(Entraineur entraineur) {
		String query = "UPDATE entraineur SET prenom='" + entraineur.getPrenom() + "', nom='" + entraineur.getNom() +"', age='" + entraineur.getAge() + "', taille='" + entraineur.getTaille() + "', date_naissance='" + entraineur.getDateNaissance() + "' WHERE id_entraineur='" + entraineur.getIdEntraineur() + "'";
		writeToFile(query);
	}

	@Override
	public void deleteEntraineur(int id) {
		String query = "DELETE FROM entraineur WHERE id_entraineur='" + id + "'";
		writeToFile(query);
	}

	@Override
	public void validate() {
		try {
			File f = new File("src/main/java/com/tournoi/foot/log/entraineurSql.txt");
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
			FileWriter f = new FileWriter("src/main/java/com/tournoi/foot/log/entraineurSql.txt", true);
			BufferedWriter bw = new BufferedWriter(f);
			bw.write(query);
			bw.newLine();
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
