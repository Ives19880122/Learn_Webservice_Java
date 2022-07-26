package com.bharah.ws.soap.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


@XmlType(name="RideProcessorRequest")
@XmlAccessorType(XmlAccessType.FIELD)
public class RideProcessorRequest {
	@XmlElement(name="ride", required=true)
	private RideInfo ride;

	public RideInfo getRide() {
		return ride;
	}

	public void setRide(RideInfo ride) {
		this.ride = ride;
	}
}
