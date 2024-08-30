package com.CourseManagementAPI.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CourseManagementAPI.Entity.Course;
import com.CourseManagementAPI.Entity.CourseInstance;
import com.CourseManagementAPI.Repository.CourseInstanceRepository;
import com.CourseManagementAPI.Repository.CourseRepository;
import com.CourseManagementAPI.RequestDto.CourseInstanceRequestDto;
import com.CourseManagementAPI.ResponseDto.ApiResponseDto;

@Service
public class CourseInstanceService {

	@Autowired
	private CourseInstanceRepository courseInstanceRepository;

	@Autowired
	CourseRepository courseRepository;

	@Autowired
	ApiResponseDto apiResponseDto;

	// Create a new instance of a course delivery
	public ApiResponseDto createCourseInstance(CourseInstanceRequestDto courseInstanceRequest) {
		Optional<Course> course = courseRepository.findById(courseInstanceRequest.getCourseId());
		if (course.isEmpty()) {
			apiResponseDto.setData(null);
			apiResponseDto.setStatus("Failed");
			apiResponseDto.setStatusCode(400);
			apiResponseDto.setStatusMessage("Course Not Found");
			return apiResponseDto;
		}
		CourseInstance courseInstance = new CourseInstance();
		courseInstance.setCourse(course.get());
		courseInstance.setSemester(courseInstanceRequest.getSemester());
		courseInstance.setYear(courseInstanceRequest.getYear());

		courseInstanceRepository.save(courseInstance);

		apiResponseDto.setData(courseInstance);
		apiResponseDto.setStatus("Success");
		apiResponseDto.setStatusCode(200);
		apiResponseDto.setStatusMessage("Course Instance Created Successfully");
		return apiResponseDto;
	}

	// list of courses delivered in year and semester
	public ApiResponseDto getCourseInstancesByYearAndSemester(int year, int semester) {
		List<CourseInstance> courseYear = courseInstanceRepository.findByYear(year);
		if (courseYear.isEmpty()) {
			apiResponseDto.setData(null);
			apiResponseDto.setStatus("Failed");
			apiResponseDto.setStatusCode(400);
			apiResponseDto.setStatusMessage("Course Year Not Found");
			return apiResponseDto;
		}
		List<CourseInstance> courseSemester = courseInstanceRepository.findBySemester(semester);
		if (courseSemester.isEmpty()) {
			apiResponseDto.setData(null);
			apiResponseDto.setStatus("Failed");
			apiResponseDto.setStatusCode(400);
			apiResponseDto.setStatusMessage("Course Semester Not Found");
			return apiResponseDto;
		}
		List<CourseInstance> courseInstances = courseInstanceRepository.findByYearAndSemester(year, semester);
		if (courseInstances.isEmpty()) {
			apiResponseDto.setData(null);
			apiResponseDto.setStatus("Failed");
			apiResponseDto.setStatusCode(400);
			apiResponseDto.setStatusMessage("Course Not Found");
			return apiResponseDto;
		}

		apiResponseDto.setData(courseInstances);
		apiResponseDto.setStatus("Success");
		apiResponseDto.setStatusCode(200);
		apiResponseDto.setStatusMessage("Course Fetched");
		return apiResponseDto;
	}

	// View detailed information about an instance of a course ID, delivered in year
	// and semester
	public ApiResponseDto getCourseInstanceByYearSemesterAndCourseId(int year, int semester, Long courseId) {
		Optional<Course> course = courseRepository.findById(courseId);
		if (course.isEmpty()) {
			apiResponseDto.setData(null);
			apiResponseDto.setStatus("Failed");
			apiResponseDto.setStatusCode(400);
			apiResponseDto.setStatusMessage("Course Not Found");
			return apiResponseDto;
		}

		List<CourseInstance> courseInstances = courseInstanceRepository
				.findByCourse_CourseIdAndYearAndSemester(courseId, year, semester);
		if (courseInstances.isEmpty()) {
			apiResponseDto.setData(null);
			apiResponseDto.setStatus("Failed");
			apiResponseDto.setStatusCode(400);
			apiResponseDto.setStatusMessage("Course Instances Not Found");
			return apiResponseDto;
		}
		apiResponseDto.setData(courseInstances);
		apiResponseDto.setStatus("Success");
		apiResponseDto.setStatusCode(200);
		apiResponseDto.setStatusMessage("Course Instances Found");
		return apiResponseDto;

	}

	// Delete an instance of a course
	public ApiResponseDto deleteCourseInstance(int year, int semester, Long courseId) {
		Optional<Course> course = courseRepository.findById(courseId);
		if (course.isEmpty()) {
			apiResponseDto.setData(null);
			apiResponseDto.setStatus("Failed");
			apiResponseDto.setStatusCode(400);
			apiResponseDto.setStatusMessage("Course Not Found");
			return apiResponseDto;
		}
		List<CourseInstance> courseInstances = courseInstanceRepository
				.findByCourse_CourseIdAndYearAndSemester(courseId, year, semester);
		if (courseInstances.isEmpty()) {
			apiResponseDto.setData(null);
			apiResponseDto.setStatus("Failed");
			apiResponseDto.setStatusCode(400);
			apiResponseDto.setStatusMessage("Course Instances Not Found");
			return apiResponseDto;
		}
		courseInstanceRepository.deleteAll(courseInstances);
		apiResponseDto.setData(null);
		apiResponseDto.setStatus("Success");
		apiResponseDto.setStatusCode(200);
		apiResponseDto.setStatusMessage("Course Instances Deleted Successfully");
		return apiResponseDto;
	}
	
	public ApiResponseDto getInstanceById(Long instanceId) {
		Optional<CourseInstance> courseInstance = courseInstanceRepository.findById(instanceId);
		if(courseInstance.isEmpty()) {
			apiResponseDto.setData(null);
			apiResponseDto.setStatus("Failed");
			apiResponseDto.setStatusCode(400);
			apiResponseDto.setStatusMessage("Course Instance Not Found");
			return apiResponseDto;
		}
		
		apiResponseDto.setData(courseInstance);
		apiResponseDto.setStatus("Success");
		apiResponseDto.setStatusCode(200);
		apiResponseDto.setStatusMessage("Course Instance Found");
		return apiResponseDto;
	}
}
