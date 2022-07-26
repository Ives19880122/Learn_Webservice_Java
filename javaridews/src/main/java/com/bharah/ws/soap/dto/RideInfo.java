package com.bharah.ws.soap.dto;

import java.io.Serializable;
import java.math.BigInteger;

import javax.xml.bind.annotation.XmlType;

@XmlType(name="ride")
public class RideInfo{
	private String id;
	private String from;
	private String to;
	private BigInteger amount;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public BigInteger getAmount() {
		return amount;
	}
	public void setAmount(BigInteger amount) {
		this.amount = amount;
	}

}
