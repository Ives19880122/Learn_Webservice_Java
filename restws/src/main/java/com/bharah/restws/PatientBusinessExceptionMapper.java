package com.bharah.restws;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.bharah.restws.exceptions.PatientBusinessException;

@Provider	// 讓javax知道有設置ExceptionMapper
public class PatientBusinessExceptionMapper implements ExceptionMapper<PatientBusinessException> {

	@Override
	public Response toResponse(PatientBusinessException e) {
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		sb.append("\"status\":\"error\",");
		sb.append("\"message\":\"Try Again Later!\",");
		sb.append("}");
		return Response.serverError()
				.entity(sb.toString())
				.type(MediaType.APPLICATION_JSON)
				.build();
	}

}
