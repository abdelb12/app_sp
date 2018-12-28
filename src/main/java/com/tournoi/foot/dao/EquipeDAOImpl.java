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

import com.tournoi.foot.model.Equipe;
import com.tournoi.foot.model.EquipeRowMapper;

@Transactional
@Repository
public class EquipeDAOImpl implements EquipeDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Equipe> getAllEquipes() {
		String query = "SELECT * FROM equipe";
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		RowMapper<Equipe> rowMapper = context.getBean("equipeRowMapper", EquipeRowMapper.class);
		List<Equipe> list = jdbcTemplate.query(query, rowMapper);
		System.out.println(list.toString());
		context.close();
		return list;
	}

	@Override
	public Equipe findEquipeById(int id) {
		String query = "SELECT * FROM equipe WHERE id_equipe = ?";
		RowMapper<Equipe> rowMapper = new BeanPropertyRowMapper<Equipe>(Equipe.class);
		Equipe equipe = jdbcTemplate.queryForObject(query, rowMapper, id);
		return equipe;
	}

	@Override
	public void addEquipe(Equipe equipe) {
		String query = "INSERT INTO equipe(nom, date_creation, id_entraineur) VALUES('" + equipe.getNom() + "','" + equipe.getDateCreation() + "','" + equipe.getIdEntraineur() + "')";
		writeToFile(query);
	}

	@Override
	public void updateEquipe(Equipe equipe) {
		String query = "UPDATE equipe SET nom='" + equipe.getNom() + "', date_creation='" + equipe.getDateCreation() +"', id_entraineur='" + equipe.getIdEntraineur() + "' WHERE id_equipe='" + equipe.getIdEquipe() + "'";
		writeToFile(query);
	}

	@Override
	public void deleteEquipe(int id) {
		String query = "DELETE FROM equipe WHERE id_equipe='" + id + "'";
		writeToFile(query);
	}

	@Override
	public void validate() {
		try {
			File f = new File("src/main/java/com/tournoi/foot/log/equipeSql.txt");
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
			FileWriter f = new FileWriter("src/main/java/com/tournoi/foot/log/equipeSql.txt", true);
			BufferedWriter bw = new BufferedWriter(f);
			bw.write(query);
			bw.newLine();
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
