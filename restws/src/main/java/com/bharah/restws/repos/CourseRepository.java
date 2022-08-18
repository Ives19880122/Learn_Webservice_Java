package com.bharah.restws.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bharah.restws.model.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {

}
