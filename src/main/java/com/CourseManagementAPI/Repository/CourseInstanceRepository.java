package com.CourseManagementAPI.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.CourseManagementAPI.Entity.CourseInstance;

@Repository
public interface CourseInstanceRepository extends JpaRepository<CourseInstance, Long> {

	List<CourseInstance> findByYearAndSemester(int year, int semester);

	List<CourseInstance> findByYear(int year);

	List<CourseInstance> findBySemester(int semester);

	List<CourseInstance> findByCourse_CourseIdAndYearAndSemester(Long courseId, int year, int semester);

}
