package com.bharah.ws.soap.dto;

import javax.xml.bind.annotation.XmlType;

@XmlType(name="RideProcessorResponse")
public class RideProcessorResponse {

	private boolean result;

	public boolean isResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}
}
