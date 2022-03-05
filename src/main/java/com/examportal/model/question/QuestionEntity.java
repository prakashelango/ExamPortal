package com.examportal.model.question;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Document(collection = "question")
@Data
public class QuestionEntity {
    @Id
    private String id;
    private String questionLabel;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String option5;
    private String answer;
    private boolean deleted;
}
