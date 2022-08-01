package com.bharah.restwsclient;

import java.math.BigDecimal;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.bharah.restwsclient.model.Course;

public class CourseWSClient {

	private static final String COURSE_SERVICE_URL = "http://localhost:8080/restws/services/courseservice";

	public static void main(String[] args) {
		// build Client
		Client client = ClientBuilder.newClient();
		WebTarget getTarget = client.target(COURSE_SERVICE_URL)
				.path("/courses")
				.path("/{id}")
				.resolveTemplate("id", 9453);		
		Builder request = getTarget.request();
		Course course = request.get(Course.class);
		
		// print result
		System.out.println(course.getId());
		System.out.println(course.getName());
		
		course.setName("servlet");
		
		// update course
		WebTarget putTarget = client.target(COURSE_SERVICE_URL).path("/courses");
		Response updateResponse = putTarget.request().put(Entity.entity(course,MediaType.APPLICATION_XML));
		System.out.println(updateResponse.getStatus());
		updateResponse.close();
		
		// create course
		Course newCourse = new Course();
		newCourse.setName("JavaSE");
		newCourse.setPrice(BigDecimal.valueOf(2000));
		newCourse.setRating(95);
		newCourse.setTaughtBy("Test123");
		
		WebTarget postTarget = client.target(COURSE_SERVICE_URL).path("/courses");
		Course createCourse = postTarget.request()
				.post(Entity.entity(newCourse, MediaType.APPLICATION_XML),Course.class);
		System.out.println("Create Course ID "+ createCourse.getId());
		
		// delete course
		WebTarget deleteTarget = client.target(COURSE_SERVICE_URL)
				.path("/courses")
				.path("/{id}")
				.resolveTemplate("id", 9454);
		Response delResponse = deleteTarget.request().delete();
		System.out.println(delResponse.getStatus());
		delResponse.close();
		
		// close resource
		client.close();
	}

}
