package com.examportal.repository.department;

import com.examportal.model.department.DepartmentEntity;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface DepartmentEntityRepository extends ReactiveMongoRepository<DepartmentEntity, String> {
}
