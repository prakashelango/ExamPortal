package com.examportal.service.question;

import com.examportal.model.course.CourseEntity;
import com.examportal.model.question.Question;
import com.examportal.model.question.QuestionEntity;
import com.examportal.repository.question.QuestionEntityRepository;
import com.examportal.service.course.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.function.Function;
import java.util.function.Predicate;

@Service
public class QuestionUploadService {

    @Autowired
    private QuestionEntityRepository questionRepository;

    @Autowired
    private CourseService courseService;

    private Predicate<Question> isQuestionInputsNotNull = q -> q.getQuestionLabel() != null &&
            q.getOptions()!=null && q.getOptions().size()>0;
            /*( q.getOption1() != null || q.getOption2() != null || q.getOption3() != null
            || q.getOption4() != null || q.getOption5()!=null)*/

    public Flux<Question> getAllQuestions() {
        return questionRepository.findAll().map(this::convertQuestionEntityToQuestion);
    }

    private Question convertQuestionEntityToQuestion(QuestionEntity questionEntity) {
        return Question.builder()
                .id(questionEntity.getId())
                .questionLabel(questionEntity.getQuestionLabel())
                .options(questionEntity.getOptions())
                /*.option2(questionEntity.getOption2())
                .option3(questionEntity.getOption3())
                .option4(questionEntity.getOption4())
                .option5(questionEntity.getOption5())*/
                .courseName(questionEntity.getCourse().getCourseName())
                .build();
    }

    private Function<Question, Flux<QuestionEntity>> convertQuestionToQuestionEntity(CourseEntity course) {
        return q -> Flux.just(QuestionEntity.builder()
                .id(q.getId())
                .questionLabel(q.getQuestionLabel())
                .options(q.getOptions())
                /*.option2(q.getOption2())
                .option3(q.getOption3())
                .option4(q.getOption4())
                .option5(q.getOption5())*/
                .course(course)
                .build());
    }

    public Flux<QuestionEntity> createQuestion(Flux<Question> question) {
        return question
                .thenMany(validateQuestions(question))
                .flatMap(questionRepository::save);
                /*.map(o -> {
                    orderProducer.sendMessage(o.setOrderStatus(OrderStatus.INITIATION_SUCCESS));
                    return o;
                })
                .onErrorResume(err -> {
                    return Mono.just(order.setOrderStatus(OrderStatus.FAILURE)
                            .setResponseMessage(err.getMessage()));
                })
                .flatMap(QuestionEntityRepository::save)*/
    }

    private Flux<QuestionEntity> validateQuestions(Flux<Question> question)  {
            return question.filter(isQuestionInputsNotNull)
                    .filter(q -> courseService.getCourseByNameAsCourse(q.getCourseName()).blockOptional().isPresent())
                    .flatMap(q -> convertQuestionToQuestionEntity(courseService.getCourseByName(q.getCourseName()).block()).apply(q));


            //TODO add validation for each type of fields and return to user.
            // return null;
            //throw new QuestionValidationException();
    }
}
