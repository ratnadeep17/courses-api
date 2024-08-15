package com.CourseManagementAPI.Controller;


import org.springframework.beans.factory.annotation.Autowired;

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

	@DeleteMapping("courses/{courseId}")
	public ApiResponseDto deleteCourse(@PathVariable Long courseId) {
		return courseService.deleteCourse(courseId);
	}
}
