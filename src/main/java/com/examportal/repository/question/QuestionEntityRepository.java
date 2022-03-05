package com.examportal.repository.question;

import com.examportal.model.question.QuestionEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface QuestionEntityRepository extends ReactiveMongoRepository<QuestionEntity, String> {
}
