package com.bharah.restws;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.Response;

import org.springframework.stereotype.Service;

import com.bharah.restws.model.Course;

@Service
public class CourseServiceImpl implements CourseService {

	private Map<Long,Course> courses = new HashMap<>();
	private long currentId = 9453;
	
	public CourseServiceImpl() {
		init();
	}
	
	public void init() {
		Course course = new Course();
		course.setId(currentId);
		course.setName("JaxRS");
		course.setPrice(BigDecimal.valueOf(1500));
		course.setTaughtBy("TEST123");
		course.setRating(95);
		courses.put(course.getId(), course);
	}
	
	@Override
	public List<Course> getCourses() {
		return new ArrayList<Course>(courses.values());
	}

	@Override
	public Course getCourse(Long id) {
		return courses.get(id);
	}

	@Override
	public Response createCourse(Course course) {
		course.setId(++currentId);
		courses.put(course.getId(), course);
		return Response.ok(course).build();
	}

	@Override
	public Response updateCourse(Course course) {
		Course currentCourse = courses.get(course.getId());
		Response response;
		if(currentCourse!=null) {
			courses.put(course.getId(), course);
			response = Response.ok().build();
		}else {
			response = Response.notModified().build();
		}
		return response;
	}

	@Override
	public Response deleteCourse(Long id) {
		Course currentCourse = courses.get(id);
		Response response;
		if(currentCourse!=null) {
			courses.remove(id);
			response = Response.ok().build();
		}else {
			response = Response.notModified().build();
		}
		return response;
	}
	
}
