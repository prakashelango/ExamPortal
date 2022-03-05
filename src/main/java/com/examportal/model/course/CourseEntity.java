package com.examportal.model.course;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.jpa.domain.AbstractAuditable;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;
import javax.persistence.Table;

@Document(collection = "course")
@Data
public class CourseEntity extends AbstractAuditable {

    @Id
    private String id;
    private String courseName;
    private String courseImagePath;
}
