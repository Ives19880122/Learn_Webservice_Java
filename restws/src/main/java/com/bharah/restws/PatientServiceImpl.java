package com.bharah.restws;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.bharah.restws.model.Patient;

@Service // Spring使用
public class PatientServiceImpl implements PatientService {
	
	Map<Long,Patient> patients = new HashMap<>();
	long currentId = 123;
	
	public PatientServiceImpl() {
		init();
	}
	
	// mock data from database
	void init() {
		Patient patient = new Patient();
		patient.setId(currentId);
		patient.setName("JavaRS");
		patients.put(patient.getId(), patient);
	}
}
