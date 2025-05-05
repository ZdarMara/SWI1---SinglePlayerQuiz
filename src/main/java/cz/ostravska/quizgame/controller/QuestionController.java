package cz.ostravska.quizgame.controller;

import cz.ostravska.quizgame.model.Question;
import cz.ostravska.quizgame.model.UserAnswer;
import cz.ostravska.quizgame.service.QuestionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/questions")
public class QuestionController {

    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping
    public List<Question> getAllQuestions() {
        return questionService.getAllQuestions();
    }

    @GetMapping("/quiz/start")
    public List<Question> startQuiz(@RequestParam(defaultValue = "10") int count) {
        return questionService.getRandomQuestions(count);
    }

    @PostMapping("/quiz/submit")
    public int submitAnswers(@RequestBody List<UserAnswer> userAnswers) {
        return questionService.evaluateAnswers(userAnswers);
    }
}
