package com.bharah.restws;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.bharah.restws.model.Patient;

@Consumes(value= {"application/xml","application/json"})
@Produces(value= {"application/xml","application/json"})
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
	Patient getPatient(@PathParam("id") Long id);
	
	/**
	 * 新增病患
	 * @param patient
	 * @return
	 */
	@Path("/patients")
	@POST
	Response createPatient(Patient patient);
	
	/**
	 * 更新病患
	 * @param patient
	 * @return
	 */
	@Path("/patients")
	@PUT
	Response updatePatient(Patient patient);
	
	/**
	 * 刪除病患
	 * @param id
	 * @return
	 */
	@Path("/patients/{id}")
	@DELETE
	Response deletePatient(@PathParam("id") Long id);
}
