package com.CourseManagementAPI.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CourseManagementAPI.Entity.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long>{

	Optional<Course> findByCourseCode(String courseCode);
}
