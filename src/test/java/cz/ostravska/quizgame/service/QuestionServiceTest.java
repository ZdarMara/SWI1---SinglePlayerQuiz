package cz.ostravska.quizgame.service;

import cz.ostravska.quizgame.model.AnswerDirection;
import cz.ostravska.quizgame.model.Question;
import cz.ostravska.quizgame.model.UserAnswer;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class QuestionServiceTest {

    private final QuestionService questionService = new QuestionService();

    @Test
    void testGetAllQuestionsReturnsData() {
        List<Question> questions = questionService.getAllQuestions();
        assertFalse(questions.isEmpty(), "Seznam otázek by neměl být prázdný");
    }

    @Test
    void testGetRandomQuestionsReturnsCorrectCount() {
        int count = 5;
        List<Question> random = questionService.getRandomQuestions(count);
        assertEquals(count, random.size(), "Počet vrácených náhodných otázek musí odpovídat požadovanému počtu");
    }

    @Test
    void testEvaluateAnswersCorrectScoring() {
        UserAnswer answer = new UserAnswer();
        answer.setQuestionId(1L); // Slon v Africe: 350001, statement: 350 000
        answer.setDirection(AnswerDirection.MORE); // Správně => bod

        int score = questionService.evaluateAnswers(List.of(answer));
        assertEquals(1, score, "Měla by být připsána 1 správná odpověď");
    }
}
