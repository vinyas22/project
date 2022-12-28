package com.project.doctor;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.project.patient.Patient;

@Service
public class DoctorService {
	
	@Autowired
	DoctorDao docdao;
	
	public List<Doctor> getdocdetails() {
		List<Doctor> doc=docdao.getdoctor();
		return doc;
	}
public  boolean savedoctoDB(Doctor doc) {
		
		
		return docdao.saveDoctortoDB(doc) ;
	}

public List<Docidpass> getauthdetails(){
	List<Docidpass> docc=docdao.getdoctorauth();
	return docc;
}


public List<Doctor> getcategory(String category) {
	List<Doctor> info=docdao.getdoctor();
	List<Doctor> filterlist = info.stream().filter(doct->doct.getCategory().equals(category)).collect(Collectors.toList());
	return filterlist;
}

}
