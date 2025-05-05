package cz.ostravska.quizgame.service;

import cz.ostravska.quizgame.model.AnswerDirection;
import cz.ostravska.quizgame.model.Question;
import cz.ostravska.quizgame.model.UserAnswer;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
public class QuestionService {

    private final List<Question> questions = new ArrayList<>();

    public QuestionService() {
        questions.add(new Question(1L, "V Africe žije 12000 slonů", 12000));
        questions.add(new Question(2L, "V USA je 50 států", 50));
        questions.add(new Question(3L, "ČR má 10,7 milionu obyvatel", 10700000));
        questions.add(new Question(4L, "Mount Everest měří 8800 metrů", 8848));
        questions.add(new Question(5L, "V EU je 27 členských států", 27));
        questions.add(new Question(6L, "Rok má 360 dní", 365));
        questions.add(new Question(7L, "Ve vesmíru je 8 planet", 8));
        questions.add(new Question(8L, "Lidské tělo má 206 kostí", 206));
        questions.add(new Question(9L, "Amazonka je dlouhá 6500 km", 6400));
        questions.add(new Question(10L, "Teplota varu vody je 100 stupňů", 100));
        questions.add(new Question(11L, "Pivo se vaří už přes 7000 let", 7000));
        questions.add(new Question(12L, "V lidském těle je asi 5 litrů krve", 5));
        questions.add(new Question(13L, "Internet vznikl v roce 1980", 1983));
        questions.add(new Question(14L, "Průměrná teplota Země je 15 °C", 15));
        questions.add(new Question(15L, "Slunce je vzdálené 150 milionů km", 150000000));
        questions.add(new Question(16L, "V lidském těle je 10 prstů", 10));
        questions.add(new Question(17L, "Průměrný věk v Japonsku je 84 let", 84));
        questions.add(new Question(18L, "Hranice mezi ČR a Slovenskem je 250 km", 251));
        questions.add(new Question(19L, "Tesla vznikla v roce 2000", 2003));
        questions.add(new Question(20L, "Fotbalový míč váží 300 gramů", 450));
        questions.add(new Question(21L, "Pyramida v Gíze je vysoká 140 metrů", 138));
        questions.add(new Question(22L, "Ve školním roce je 200 dní výuky", 190));
        questions.add(new Question(23L, "V ČR je přes 6000 obcí", 6250));
        questions.add(new Question(24L, "Ve světě je 200 států", 195));
        questions.add(new Question(25L, "Člověk má 32 zubů", 32));
    }

    public List<Question> getAllQuestions() {
        return questions;
    }

    public List<Question> getRandomQuestions(int count) {
        List<Question> shuffled = new ArrayList<>(questions);
        Collections.shuffle(shuffled);
        return shuffled.stream().limit(count).collect(Collectors.toList());
    }

    public int evaluateAnswers(List<UserAnswer> userAnswers) {
        int score = 0;

        for (UserAnswer answer : userAnswers) {
            Optional<Question> question = questions.stream()
                    .filter(q -> q.getId().equals(answer.getQuestionId()))
                    .findFirst();

            if (question.isPresent()) {
                int statementValue = extractNumberFromStatement(question.get().getStatement());
                int actual = question.get().getActualValue();

                if ((answer.getDirection() == AnswerDirection.MORE && actual > statementValue) ||
                        (answer.getDirection() == AnswerDirection.LESS && actual < statementValue)) {
                    score++;
                }
            }
        }
        return score;
    }

    private int extractNumberFromStatement(String statement) {
        Matcher matcher = Pattern.compile("\\d+").matcher(statement);
        int max = 0;

        while (matcher.find()) {
            int number = Integer.parseInt(matcher.group());
            if (number > max) {
                max = number;
            }
        }

        return max;
    }
}
