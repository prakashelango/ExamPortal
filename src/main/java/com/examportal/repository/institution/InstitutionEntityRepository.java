package com.examportal.repository.institution;

import org.springframework.data.jpa.domain.AbstractAuditable;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface InstitutionEntityRepository extends ReactiveMongoRepository<InstitutionEntityRepository, String> {
}
