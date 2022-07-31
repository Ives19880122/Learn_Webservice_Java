package com.bharah.restws;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.bharah.restws.model.Course;

@Consumes(value= {"application/xml","application/json"})
@Produces(value= {"application/xml","application/json"})
@Path("/courseservice")
public interface CourseService {
	
	@Path("/courses")
	@GET
	List<Course> getCourses();
	
	@Path("/courses/{id}")
	@GET
	Course getCourse(@PathParam("id") Long id);
	
	@Path("/courses")
	@POST
	Response createCourse(Course course);
	
	@Path("/courses")
	@PUT
	Response updateCourse(Course course);
	
	@Path("/courses/{id}")
	@DELETE
	Response deleteCourse(@PathParam("id") Long id);
	
}
