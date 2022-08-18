package com.bharah.restws.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Course")
@Entity
public class Course {
	@Id
	Long id;
	String name;
	String taughtby;
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
		return taughtby;
	}
	public void setTaughtBy(String taughtby) {
		this.taughtby = taughtby;
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
