package com.CourseManagementAPI.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CourseManagementAPI.Entity.Course;
import com.CourseManagementAPI.ResponseDto.ApiResponseDto;
import com.CourseManagementAPI.Service.CourseService;

@RestController
@RequestMapping("/api/")
public class CourseController {

	@Autowired
	private CourseService courseService;

	@Autowired
	ApiResponseDto apiResponseDto;

	@PostMapping("courses")
	public ApiResponseDto createCourse(@RequestBody Course course) {
		return courseService.createCourse(course);
	}

	@GetMapping("courses")
	public ApiResponseDto getAllCourses() {
		return courseService.getAllCourses();
	}

	@GetMapping("courses/{courseId}")
	public ApiResponseDto getCourseById(@PathVariable Long courseId) {
		return courseService.getCourseById(courseId);

	}

	@DeleteMapping("courses/{id}")
	public ResponseEntity<Void> deleteCourse(@PathVariable Long id) {
		courseService.deleteCourse(id);
		return ResponseEntity.noContent().build();
	}
}
