package com.bharah.restws;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

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
	
	/**
	 * 取得單一病患
	 * @param id
	 * @return
	 */
	@Path("/patients/{id}")
	@GET
	Patient getPatient(@PathParam(value = "id") Long id);
	
	/**
	 * 新增病患
	 * @param patient
	 * @return
	 */
	@Path("/patients")
	@POST
	Response createPatient(Patient patient);
}
