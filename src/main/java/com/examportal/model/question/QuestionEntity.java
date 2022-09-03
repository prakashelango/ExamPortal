package com.examportal.model.question;

import com.examportal.model.course.CourseEntity;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "question")
@Data
@Builder
public class QuestionEntity {
    @Id
    private String id;
    private String questionLabel;
    private List<String> options;
    /*private String option2;
    private String option3;
    private String option4;
    private String option5;*/
    private String answer;
    private boolean deleted;
    @DBRef
    private CourseEntity course;
}
