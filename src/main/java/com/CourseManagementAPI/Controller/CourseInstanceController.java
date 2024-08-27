package com.CourseManagementAPI.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CourseManagementAPI.RequestDto.CourseInstanceRequestDto;
import com.CourseManagementAPI.ResponseDto.ApiResponseDto;
import com.CourseManagementAPI.Service.CourseInstanceService;

@RestController
@RequestMapping("/api/")
public class CourseInstanceController {

	@Autowired
	private CourseInstanceService courseInstanceService;

	@PostMapping("instances")
	public ApiResponseDto createCourseInstance(@RequestBody CourseInstanceRequestDto courseInstanceRequest) {
		return courseInstanceService.createCourseInstance(courseInstanceRequest);
	}

	@GetMapping("instances/{year}/{semester}")
	public ApiResponseDto getCourseInstancesByYearAndSemester(@PathVariable int year, @PathVariable int semester) {
		return courseInstanceService.getCourseInstancesByYearAndSemester(year, semester);
	}

	@GetMapping("instances/{year}/{semester}/{courseId}")
	public ApiResponseDto getCourseInstanceByYearSemesterAndCourseId(@PathVariable int year, @PathVariable int semester,
			@PathVariable Long courseId) {
		return courseInstanceService.getCourseInstanceByYearSemesterAndCourseId(year, semester, courseId);
	}

	@DeleteMapping("instances/{year}/{semester}/{courseId}")
	public ApiResponseDto deleteCourseInstance(@PathVariable int year, @PathVariable int semester,
			@PathVariable Long courseId) {
		return courseInstanceService.deleteCourseInstance(year,semester,courseId);
	}
}
