package com.bharah.restwsclient;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.bharah.restwsclient.model.Patient;

public class PatientWSClient {

	private static final String PATIENT_SERVICE_URL = "http://localhost:8080/restws/services/patientservice";

	public static void main(String[] args) {
		// 建立Client端實體
		Client client = ClientBuilder.newClient();
		// client 指向 WebTarget
		WebTarget target = client.target(PATIENT_SERVICE_URL)
				.path("/patients")
				.path("/{id}")
				.resolveTemplate("id", 123);
		
		// target建立請求
		Builder request = target.request();
		// 請求獲得回應
		Patient patient = request.get(Patient.class);
		
		// 提取結果
		System.out.println(patient.getId());
		System.out.println(patient.getName());
		
		patient.setName("servlet");
		
		// 進行Update操作
		WebTarget putTarget = client.target(PATIENT_SERVICE_URL).path("/patients");
		// 設置Entity, inject物件 並且設定為XML/JSON
		Response updateResponse = putTarget.request().put(Entity.entity(patient,MediaType.APPLICATION_XML));
		System.out.println(updateResponse.getStatus());
		updateResponse.close();
		
		// create patient
		Patient newPatient = new Patient();
		newPatient.setName("JavaSE");
		
		WebTarget postTarget = client.target(PATIENT_SERVICE_URL).path("/patients");
		Patient createPatient = postTarget.request()
				.post(Entity.entity(patient, MediaType.APPLICATION_XML),Patient.class);
		System.out.println("Create Patient ID "+ createPatient.getId());
		
		// delete patient
		WebTarget deleteTarget = client.target(PATIENT_SERVICE_URL)
				.path("/patients")
				.path("/{id}")
				.resolveTemplate("id", 125);
		Response delResponse = deleteTarget.request().delete();
		System.out.println(delResponse.getStatus());
		delResponse.close();
		
		// 結束時關閉資源
		client.close();
	}

}
