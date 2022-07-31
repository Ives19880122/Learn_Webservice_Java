package com.bharah.restws.model;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Course")
public class Course {
	Long id;
	String name;
	String taughtBy;
	BigDecimal price;
	Integer rating;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTaughtBy() {
		return taughtBy;
	}
	public void setTaughtBy(String taughtBy) {
		this.taughtBy = taughtBy;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public Integer getRating() {
		return rating;
	}
	public void setRating(Integer rating) {
		this.rating = rating;
	}
	
	
}
