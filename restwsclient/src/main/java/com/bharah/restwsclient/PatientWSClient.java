package com.bharah.restwsclient;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;

import com.bharah.restwsclient.model.Patient;

public class PatientWSClient {

	public static void main(String[] args) {
		// 建立Client端實體
		Client client = ClientBuilder.newClient();
		// client 指向 WebTarget
		WebTarget target = client.target("http://localhost:8080/restws/services/patientservice/patients/123");
		// target建立請求
		Builder request = target.request();
		// 請求獲得回應
		Patient patient = request.get(Patient.class);
		// 提取結果
		System.out.println(patient.getId());
		System.out.println(patient.getName());
	}

}
