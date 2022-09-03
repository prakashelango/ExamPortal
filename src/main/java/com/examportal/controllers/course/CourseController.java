package com.examportal.controllers.course;

import com.examportal.model.course.Course;
import com.examportal.model.question.QuestionEntity;
import com.examportal.service.course.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping(value = "/create")
    public Mono<Course> create(@RequestBody Course course) {
        return courseService.createCourse(course);
    }

    @GetMapping(value = "/getall")
    public Flux<Course> getAllCourse() {
        return courseService.getAllCourse();
    }
}
