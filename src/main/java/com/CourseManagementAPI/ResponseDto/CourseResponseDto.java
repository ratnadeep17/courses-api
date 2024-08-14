package com.CourseManagementAPI.ResponseDto;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Component
public class CourseResponseDto {

	private Long courseId;

	private String title;

	private String courseCode;

	private String description;
}
