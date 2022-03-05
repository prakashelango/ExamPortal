package com.examportal.repository.course;

import com.examportal.model.course.CourseEntity;
import com.examportal.model.department.DepartmentEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface CourseEntityRepository extends ReactiveMongoRepository<CourseEntity, String> {
}
