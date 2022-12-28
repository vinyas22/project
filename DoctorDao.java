package com.project.doctor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import com.project.patient.Patient;

@Component
public class DoctorDao {
	
	@Autowired
	JdbcTemplate template;
	
	public List<Doctor> getdoctor() {
		List<Doctor> doc=  new ArrayList<>();
		
		return	template.query("select * from project.doctor", new ResultSetExtractor<List<Doctor>>() {

			@Override
			public List<Doctor> extractData(ResultSet rs) throws SQLException, DataAccessException {
				while (rs.next()) {
					Doctor doct=new Doctor();
					doct.setName(rs.getString("name"));;
					doct.setCategory(rs.getString("category"));
					doct.setTimings(rs.getString("timings"));
					doct.setFee(rs.getString("fee"));
					doct.setExperience(rs.getString("experience"));
					doct.setContact(rs.getString("contact"));
					doct.setPassword(rs.getString("password"));
					
					doc.add(doct);
				}
				
				return doc;
			}
			

		});
	}

	public boolean saveDoctortoDB(Doctor doct) {
		boolean status=false;
		String sql= "insert into project.doctor(name,category,timings,fee,experience,contact,password)"+ "values("+"'"+doct.getName()+"',"+"'"+doct.getCategory()+"',"+"'"+doct.getTimings()+"',"+"'"+doct.getFee()+"'"+","+"'"+doct.getExperience()+"',"+"'"+doct.getContact()+"',"+"'"+doct.getPassword()+"')";
		try {
			template.execute(sql);
			status=true;
		}catch (Exception e) {                              
			e.printStackTrace();
		}
		return status;
	
	 

	
	}
	
	public List<Docidpass> getdoctorauth() {
		List<Docidpass> doc=  new ArrayList<>();
		
		return	template.query("select * from project.doctor", new ResultSetExtractor<List<Docidpass>>() {

			@Override
			public List<Docidpass> extractData(ResultSet rs) throws SQLException, DataAccessException {
				while (rs.next()) {
					Docidpass doct=new Docidpass();
					doct.setName(rs.getString("name"));;
					
					doct.setPassword(rs.getString("password"));
					
					doc.add(doct);
				}
				
				return doc;
			}
			

		});
	}
}


