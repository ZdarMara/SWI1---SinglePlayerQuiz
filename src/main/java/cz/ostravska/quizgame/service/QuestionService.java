package cz.ostravska.quizgame.service;

import cz.ostravska.quizgame.model.Question;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    private final List<Question> questions = new ArrayList<>();

    public QuestionService() {
        questions.add(new Question(1L, "Kolik je 2 + 2?", List.of("3", "4", "5"), 1));
        questions.add(new Question(2L, "Jaká je barva oblohy?", List.of("Modrá", "Zelená", "Červená"), 0));
        questions.add(new Question(3L, "Hlavní město ČR?", List.of("Brno", "Praha", "Ostrava"), 1));
    }

    public List<Question> getAllQuestions() {
        return questions;
    }
}
