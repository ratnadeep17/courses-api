package com.CourseManagementAPI.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CourseManagementAPI.Entity.Course;
import com.CourseManagementAPI.Repository.CourseRepository;
import com.CourseManagementAPI.ResponseDto.ApiResponseDto;

@Service
public class CourseService {

	@Autowired
	private CourseRepository courseRepository;

	@Autowired
	ApiResponseDto apiResponseDto;
	
//	@Autowired
//	private ModelMapper modelMapper;
	
	public ApiResponseDto createCourse(Course course) {
		Optional<Course> courseCode = courseRepository.findByCourseCode(course.getCourseCode());
		if(courseCode.isPresent()) {
			apiResponseDto.setData(null);
			apiResponseDto.setStatus("Failed");
			apiResponseDto.setStatusCode(400);
			apiResponseDto.setStatusMessage("Course Code is Already Exist");
			return apiResponseDto;
		}
//		Course courseEntity = new Course();
//		courseEntity.setTitle(course.getTitle());
//		courseEntity.setCourseCode(course.getCourseCode());
//		courseEntity.setDescription(course.getDescription());
		Course courseEntity = courseRepository.save(course);
//		CourseResponseDto courseResponseDto = modelMapper.map(courseEntity, CourseResponseDto.class);
		apiResponseDto.setData(courseEntity);
		apiResponseDto.setStatus("Success");
		apiResponseDto.setStatusCode(200);
		apiResponseDto.setStatusMessage("Course Created Successfully");
		return apiResponseDto;
	}

	public ApiResponseDto getAllCourses() {
		List<Course> courseList = courseRepository.findAll();
		if (courseList.isEmpty()) {
			apiResponseDto.setData(null);
			apiResponseDto.setStatus("Failed");
			apiResponseDto.setStatusCode(404);
			apiResponseDto.setStatusMessage("Courses Not Found");
			return apiResponseDto;
		}
		apiResponseDto.setData(courseList);
		apiResponseDto.setStatus("Success");
		apiResponseDto.setStatusCode(200);
		apiResponseDto.setStatusMessage("Courses Found");
		return apiResponseDto;
	}

	public ApiResponseDto getCourseById(Long courseId) {
		Optional<Course> course = courseRepository.findById(courseId);
		if(course.isEmpty()) {
			apiResponseDto.setData(null);
			apiResponseDto.setStatus("Failed");
			apiResponseDto.setStatusCode(404);
			apiResponseDto.setStatusMessage("Course Not Found");
			return apiResponseDto;
		}
		apiResponseDto.setData(course);
		apiResponseDto.setStatus("Success");
		apiResponseDto.setStatusCode(200);
		apiResponseDto.setStatusMessage("Course Found");
		return apiResponseDto;
	}

	public void deleteCourse(Long id) {
		courseRepository.deleteById(id);
	}

}
