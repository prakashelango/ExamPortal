package com.examportal.model.course;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "course")
@Data
@Builder
public class CourseEntity {

    @Id
    private String id;
    private String courseName;
    private String courseImagePath;
}
