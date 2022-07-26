package com.bharah.ws.soap;

import org.apache.cxf.feature.Features;

import com.bharah.ws.soap.dto.RideProcessorRequest;
import com.bharah.ws.soap.dto.RideProcessorResponse;

@Features(features="org.apache.cxf.feature.LoggingFeature")
public class RideProcessorImpl implements RideProcessor {

	public RideProcessorResponse processRide(RideProcessorRequest paymentProcessorRequest) {
		RideProcessorResponse paymentProcessorResponse = new RideProcessorResponse();
		// Business Logic or a call to a Business Logic Class Goes Here.
		paymentProcessorResponse.setResult(true);
		return paymentProcessorResponse;
	}

}
