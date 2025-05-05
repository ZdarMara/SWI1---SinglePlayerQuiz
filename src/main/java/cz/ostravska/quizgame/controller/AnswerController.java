package cz.ostravska.quizgame.controller;

import cz.ostravska.quizgame.model.QuizResult;
import cz.ostravska.quizgame.model.UserAnswer;
import cz.ostravska.quizgame.service.QuestionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class AnswerController {

    private final QuestionService questionService;

    public AnswerController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @PostMapping("/submit")
    public QuizResult submitAnswers(@RequestBody List<UserAnswer> userAnswers) {
        int correct = questionService.evaluateAnswers(userAnswers);
        return new QuizResult(userAnswers.size(), correct);
    }
}
