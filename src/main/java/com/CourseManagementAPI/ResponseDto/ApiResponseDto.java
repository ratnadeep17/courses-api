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
public class ApiResponseDto {

	private Integer statusCode;

	private String status;
	
	private String statusMessage;

	private Object data;
}
