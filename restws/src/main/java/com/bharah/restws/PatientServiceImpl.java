package com.bharah.restws;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.Response;

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

	@Override
	public List<Patient> getPatients() {
		Collection<Patient> values = patients.values();
		return new ArrayList<Patient>(values);
	}

	@Override
	public Patient getPatient(Long id) {
		return patients.get(id);
	}

	@Override
	public Response createPatient(Patient patient) {
		patient.setId(++currentId);
		patients.put(patient.getId(), patient);
		// 回傳patient物件
		return Response.ok(patient).build();
	}

	@Override
	public Response updatePatient(Patient patient) {
		Patient currentPatient = patients.get(patient.getId());
		Response response;
		if(currentPatient!=null) {
			patients.put(patient.getId(), patient);
			response = Response.ok().build();
		}else {
			response = Response.notModified().build();
		}
		return response;
	}

	@Override
	public Response deletePatient(Long id) {
		Patient patient = patients.get(id);
		Response response;
		if(patient!=null) {
			patients.remove(id);
			response = Response.ok().build();
		}else {
			response = Response.notModified().build();
		}
		return response;
	}
	
}
