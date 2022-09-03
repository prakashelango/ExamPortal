package com.examportal.controllers.question.upload;

import com.examportal.model.question.Question;
import com.examportal.model.question.QuestionEntity;
import com.examportal.service.question.QuestionUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/questions")
public class QuestionsUploadController {

    @Autowired
    private QuestionUploadService questionUploadService;
    @GetMapping(value = "/all")
    public Flux<Question> getAllQuestions() {
        return questionUploadService.getAllQuestions();
    }

    @PostMapping(value = "/create")
    public Flux<QuestionEntity> create(@RequestBody Flux<Question> question) {
        return questionUploadService.createQuestion(question);
                /*.flatMap(o -> {
                    if (OrderStatus.FAILURE.equals(o.getOrderStatus())) {
                        return Mono.error(new RuntimeException("Order processing failed, please try again later. " + o.getResponseMessage()));
                    } else {
                        return Mono.just(o);
                    }
                });*/
    }
}
