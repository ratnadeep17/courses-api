package com.CourseManagementAPI.Controller;

import java.util.List;
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

import com.CourseManagementAPI.Entity.CourseInstance;
import com.CourseManagementAPI.Service.CourseInstanceService;

@RestController
@RequestMapping("/api/instances")
public class CourseInstanceController {

	@Autowired
	private CourseInstanceService courseInstanceService;

	@PostMapping
	public ResponseEntity<CourseInstance> createCourseInstance(@RequestBody CourseInstance courseInstance) {
		CourseInstance createdInstance = courseInstanceService.createCourseInstance(courseInstance);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdInstance);
	}

	@GetMapping("/{year}/{semester}")
	public ResponseEntity<List<CourseInstance>> getCourseInstancesByYearAndSemester(@PathVariable int year,
			@PathVariable int semester) {
		List<CourseInstance> instances = courseInstanceService.getCourseInstancesByYearAndSemester(year, semester);
		return ResponseEntity.ok(instances);
	}

//	@GetMapping("/{year}/{semester}/{courseId}")
//	public ResponseEntity<CourseInstance> getCourseInstanceByYearSemesterAndCourseId(@PathVariable int year,
//			@PathVariable int semester, @PathVariable Long courseId) {
//		Optional<CourseInstance> instance = courseInstanceService.getCourseInstanceByYearSemesterAndCourseId(year,
//				semester, courseId);
//		return instance.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
//	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteCourseInstance(@PathVariable Long id) {
		courseInstanceService.deleteCourseInstance(id);
		return ResponseEntity.noContent().build();
	}
}
