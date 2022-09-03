package com.examportal.service.course;

import com.examportal.model.course.Course;
import com.examportal.model.course.CourseEntity;
import com.examportal.repository.course.CourseEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.function.Function;

@Service
public class CourseService {

    @Autowired
    private CourseEntityRepository courseRepository;

    public Mono<Course> createCourse(final Course course) {
        return Mono.just(course)
                .map(convertCourseToCourseEntity)
                .flatMap(courseRepository::save)
                .map(convertCourseEntityToCourse);
    }

    public Function<Course, CourseEntity> convertCourseToCourseEntity = c -> CourseEntity.builder()
            .id(c.getId())
            .courseName(c.getCourseName())
            .courseImagePath(c.getCourseImagePath())
            .build();

    private Function<CourseEntity, Course> convertCourseEntityToCourse = c -> Course.builder()
                .id(c.getId())
                .courseName(c.getCourseName())
                .courseImagePath(c.getCourseImagePath())
                .build();

    public Flux<Course> getAllCourse() {
        return courseRepository.findAll()
                .map(convertCourseEntityToCourse);
    }

    public Mono<Course> getCourseByNameAsCourse(final String course) {
        return getCourseByName(course)
                .map(convertCourseEntityToCourse);
    }

    public Mono<CourseEntity> getCourseByName(final String course) {
        return courseRepository.findCourseEntityByCourseName(course);
    }
}
