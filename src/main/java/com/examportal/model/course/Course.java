package com.examportal.model.course;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Course {

    private String id;
    private String courseName;
    private String courseImagePath;
}
