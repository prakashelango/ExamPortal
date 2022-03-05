package com.examportal.repository.answer;

import com.examportal.model.answer.AnswerEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface AnswerEntityRepository extends ReactiveMongoRepository<AnswerEntity, String> {
}
