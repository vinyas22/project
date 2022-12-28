package com.project.doctor;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.patient.Patient;

@CrossOrigin(origins = "http://localhost:4200")

@RestController
public class DoctorController {
	
	@Autowired
	DoctorService docserv;
	
	@RequestMapping (value ="/docdata", method = RequestMethod.GET)
	public List<Doctor> doctordata() {
		List<Doctor> pat= docserv.getdocdetails();
		return pat;
	}
	
	@RequestMapping (value ="/docdata", method = RequestMethod.POST
			, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String postDetails(@RequestBody Doctor doc){
		String StatusMessage;
		List<Doctor> pati = docserv.getdocdetails();

		if(Objects.isNull(doc.getName()) && " ".equals(doc.getName())) {
			throw new IllegalArgumentException("Name is not valid");
		}
		
		boolean status= docserv.savedoctoDB(doc);
	
		if(status) {
			StatusMessage="Data thing positive";
		}
		else {
			StatusMessage="Data thing negative";
		}
		return StatusMessage;
	}
	
	@RequestMapping (value ="/docauth", method = RequestMethod.GET)
	public List<Docidpass> docauth() {
		List<Docidpass> pat= docserv.getauthdetails();
		return pat;
	}
	
//	@RequestMapping(value = "/getdoctcat",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
//	public List<Doctor> getdocdet(@RequestBody Doctor doct) {
//		
//		if(Objects.isNull(doct.getCategory()) &&doct.getCategory().isEmpty()) {
//			throw new IllegalArgumentException("invald details");
//		}
//		List<Doctor> info=docserv.getcategory(doct.getCategory());
//		return info;
//		
//	}

	@GetMapping("/getdoctcat")
	public List<Doctor> getCatdata(@RequestParam(name="category") String category){
		List<Doctor> info=docserv.getcategory(category);
		return info;
	}
	
}
