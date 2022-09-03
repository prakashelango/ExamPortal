package com.examportal.repository.course;

import com.examportal.model.course.CourseEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;


public interface CourseEntityRepository extends ReactiveMongoRepository<CourseEntity, String> {
    Mono<CourseEntity> findCourseEntityByCourseName(String courseName);
}
