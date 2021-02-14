package com.enigma.ari.tryThymeleaf.dao;

import com.enigma.ari.tryThymeleaf.entities.Patients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PatientDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<Patients> list() {
		String sql = "SELECT * FROM PATIENTS";

		List<Patients> listPatients = jdbcTemplate.query(sql,
				BeanPropertyRowMapper.newInstance(Patients.class));

		return listPatients;
	}
	
	public void save(Patients patients) {
		SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
		insertActor.withTableName("patients").usingColumns("name", "alamat", "golongan", "umur");
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(patients);
		
		insertActor.execute(param);		
	}
	
	public Patients get(int id) {
		String sql = "SELECT * FROM PATIENTS WHERE id = ?";
		Object[] args = {id};
		Patients patients = jdbcTemplate.queryForObject(sql, args, BeanPropertyRowMapper.newInstance(Patients.class));
		return patients;
	}
	
	public void update(Patients patients) {
		String sql = "UPDATE PATIENTS SET name=:name, alamat=:alamat, golongan=:golongan, umur=:umur WHERE id=:id";
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(patients);
		NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
		template.update(sql, param);		
	}
	
	public void delete(int id) {
		String sql = "DELETE FROM PATIENTS WHERE id = ?";
		jdbcTemplate.update(sql, id);
	}
}
