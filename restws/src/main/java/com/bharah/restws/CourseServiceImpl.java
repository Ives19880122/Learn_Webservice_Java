package com.bharah.restws;

import java.util.List;
import java.util.Optional;

import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bharah.restws.model.Course;
import com.bharah.restws.repos.CourseRepository;

@Service
public class CourseServiceImpl implements CourseService {
	
	@Autowired
	CourseRepository repo;
	
	@Override
	public List<Course> getCourses() {
		return repo.findAll();
	}

	@Override
	public Course getCourse(Long id) {
		return repo.findById(id).get();
	}

	@Override
	public Response createCourse(Course course) {
		Course savedCourse = repo.save(course);
		return Response.ok(savedCourse).build();
	}

	@Override
	public Response updateCourse(Course course) {
		Optional<Course> updateCourse = repo.findById(course.getId());
		Response response;
		if(updateCourse.isPresent()) {
			repo.save(course);
			response = Response.ok(course).build();
		}else {
			response = Response.notModified().build();
		}
		return response;
	}

	@Override
	public Response deleteCourse(Long id) {
		Optional<Course> currentCourse = repo.findById(id);
		Response response;
		if(currentCourse.isPresent()) {
			repo.delete(currentCourse.get());
			response = Response.ok().build();
		}else {
			response = Response.notModified().build();
		}
		return response;
	}
	
}
