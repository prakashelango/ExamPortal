package com.examportal.model.answer;

import com.examportal.model.course.CourseEntity;
import com.examportal.model.department.DepartmentEntity;
import com.examportal.model.question.QuestionEntity;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.jpa.domain.AbstractAuditable;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "answer")
@Data
public class AnswerEntity extends AbstractAuditable {
    @Id
    private String id;
    @DBRef
    private QuestionEntity question;
    private String answer;
    private boolean answerValid;
}
