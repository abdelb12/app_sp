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
		/*String query = "INSERT INTO joueur(prenom, nom, age, taille, poste, date_naissance) VALUES(?, ?, ?, ?, ?, ?)";
		jdbcTemplate.update(query, joueur.getPrenom(), joueur.getNom(), joueur.getAge(), joueur.getTaille(), joueur.getPoste(), joueur.getDateNaissance());*/
		String query = "INSERT INTO arbitre(prenom, nom, age, taille, poste, date_naissance) VALUES('" + joueur.getPrenom() + "','" + joueur.getNom() + "','" + joueur.getAge() + "','" + joueur.getTaille() + "','" + joueur.getDateNaissance() + "')";
		writeToFile(query);
	}

	@Override
	public void updateJoueur(Joueur joueur) {
		/*String query = "UPDATE joueur SET prenom=?, nom=?, age=?, taille=?, poste=?, date_naissance=? WHERE id_joueur=?";
		jdbcTemplate.update(query, joueur.getPrenom(), joueur.getNom(), joueur.getAge(), joueur.getTaille(), joueur.getPoste(), joueur.getDateNaissance(), joueur.getIdJoueur());*/
		String query = "UPDATE joueur SET prenom='" + joueur.getPrenom() + "', nom='" + joueur.getNom() +"', age='" + joueur.getAge() + "', taille='" + joueur.getTaille() + "', date_naissance='" + joueur.getDateNaissance() + "' WHERE id_arbitre='" + joueur.getIdJoueur() + "'";
		writeToFile(query);
	}

	@Override
	public void deleteJoueur(int id) {
		/*String query = "DELETE FROM joueur WHERE id_joueur=?";
		jdbcTemplate.update(query, id);*/
		String query = "DELETE FROM joueur WHERE id_joueur='" + id + "'";
		writeToFile(query);
	}
	
	@Override
	public void validate() {
		try {
			File f = new File("src/main/java/com/tournoi/foot/log/joueurSql.txt");
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
			FileWriter f = new FileWriter("src/main/java/com/tournoi/foot/log/joueurSql.txt", true);
			BufferedWriter bw = new BufferedWriter(f);
			bw.write(query);
			bw.newLine();
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
