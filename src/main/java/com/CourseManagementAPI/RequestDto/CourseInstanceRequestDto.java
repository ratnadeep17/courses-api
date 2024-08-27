package com.CourseManagementAPI.RequestDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CourseInstanceRequestDto {

    private int year;
    private int semester;
    private Long courseId;

}
