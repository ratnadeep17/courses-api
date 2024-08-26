package com.CourseManagementAPI.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CourseManagementAPI.Entity.CourseInstance;
import com.CourseManagementAPI.Repository.CourseInstanceRepository;

@Service
public class CourseInstanceService {

	@Autowired
	private CourseInstanceRepository courseInstanceRepository;

	public CourseInstance createCourseInstance(CourseInstance courseInstance) {
		return courseInstanceRepository.save(courseInstance);
	}

	public List<CourseInstance> getCourseInstancesByYearAndSemester(int year, int semester) {
		return courseInstanceRepository.findByYearAndSemester(year, semester);
	}

//	public Optional<CourseInstance> getCourseInstanceByYearSemesterAndCourseId(int year, int semester, Long courseId) {
//		return courseInstanceRepository.findByYearAndSemesterAndCourseId(year, semester, courseId).stream().findFirst();
//	}

	public void deleteCourseInstance(Long id) {
		courseInstanceRepository.deleteById(id);
	}
}
