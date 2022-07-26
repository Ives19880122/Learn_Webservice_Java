package com.bharah.ws.soap;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import com.bharah.ws.soap.dto.RideProcessorRequest;
import com.bharah.ws.soap.dto.RideProcessorResponse;

@WebService(name="RideProcessor")
public interface RideProcessor {
	@WebMethod
	public @WebResult(name="response") RideProcessorResponse processRide(
			@WebParam(name="rideProcessorRequest") RideProcessorRequest rideProcessorRequest);
}
