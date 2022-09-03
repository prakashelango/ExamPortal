package com.examportal.model.question;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Question {

    private String id;
    private String questionLabel;
    private List<String> options;
    /*private String option2;
    private String option3;
    private String option4;
    private String option5;*/
    private String courseName;
}
