package com.bharah.restws;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.bharah.restws.exceptions.PatientBusinessException;

@Provider	// 讓javax知道有設置ExceptionMapper
public class PatientBusinessExceptionMapper implements ExceptionMapper<PatientBusinessException> {

	@Override
	public Response toResponse(PatientBusinessException e) {
		return Response.status(404).build();
	}

}
