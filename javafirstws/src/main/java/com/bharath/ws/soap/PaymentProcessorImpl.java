package com.bharath.ws.soap;

import org.apache.cxf.feature.Features;

import com.bharath.ws.soap.dto.PaymentProcessorRequest;
import com.bharath.ws.soap.dto.PaymentProcessorResponse;

@Features(features="org.apache.cxf.feature.LoggingFeature")
public class PaymentProcessorImpl implements PaymentProcessor {

	public PaymentProcessorResponse processPayment(PaymentProcessorRequest paymentProcessorRequest) {
		PaymentProcessorResponse paymentProcessorResponse = new PaymentProcessorResponse();
		if(paymentProcessorRequest.getCreditCardInfo().getCardNumber() == null
				|| paymentProcessorRequest.getCreditCardInfo().getCardNumber().length()==0) {
			throw new RuntimeException("Invalid Card Number");
		}
		
		// Business Logic or a call to a Business Logic Class Goes Here.
		paymentProcessorResponse.setResult(true);
		return paymentProcessorResponse;
	}

}
