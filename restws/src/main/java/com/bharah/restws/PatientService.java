package com.bharah.restws;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import com.bharah.restws.model.Patient;

@Path("/patientservice") // 標註Service EndPoint
public interface PatientService {
	
	/**
	 * 取得所有病患
	 * @return
	 */
	@Path("/patients")
	@GET
	public List<Patient> getPatients();
}
