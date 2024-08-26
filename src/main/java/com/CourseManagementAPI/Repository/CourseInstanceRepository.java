package com.CourseManagementAPI.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CourseManagementAPI.Entity.CourseInstance;

@Repository
public interface CourseInstanceRepository extends JpaRepository<CourseInstance, Long> {

	List<CourseInstance> findByYearAndSemester(int year, int semester);

//    List<CourseInstance> findByYearAndSemesterAndCourseId(int year, int semester, Long courseId);

}
