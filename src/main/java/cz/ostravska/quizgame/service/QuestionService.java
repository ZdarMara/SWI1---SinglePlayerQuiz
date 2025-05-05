package cz.ostravska.quizgame.service;

import cz.ostravska.quizgame.model.Question;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuestionService {

    private final List<Question> questions = new ArrayList<>();

    public QuestionService() {
        questions.add(new Question(1L, "Kolik obyvatel má Německo?", List.of("83 milionů"), 83));
        questions.add(new Question(2L, "Kolik metrů měří Mount Everest?", List.of("8848"), 8848));
        questions.add(new Question(3L, "Kolik let je průměrná délka života v Japonsku?", List.of("84"), 84));
        questions.add(new Question(4L, "Kolik států má Evropská unie?", List.of("27"), 27));
        questions.add(new Question(5L, "Kolik zemí je členem OSN?", List.of("193"), 193));
        questions.add(new Question(6L, "Kolik zubů má dospělý člověk?", List.of("32"), 32));
        questions.add(new Question(7L, "Kolik je obvod Země kolem rovníku v km?", List.of("40075"), 40075));
        questions.add(new Question(8L, "Kolik obyvatel má Česká republika?", List.of("10.7 milionu"), 10700000));
        questions.add(new Question(9L, "Kolik nohou má pavouk?", List.of("8"), 8));
        questions.add(new Question(10L, "Kolik planet má sluneční soustava?", List.of("8"), 8));
        questions.add(new Question(11L, "Kolik let trvá studium medicíny v ČR?", List.of("6"), 6));
        questions.add(new Question(12L, "Kolik hráčů má fotbalový tým na hřišti?", List.of("11"), 11));
        questions.add(new Question(13L, "Kolik je 12 na druhou?", List.of("144"), 144));
        questions.add(new Question(14L, "Kolik minut má den?", List.of("1440"), 1440));
        questions.add(new Question(15L, "Kolik je průměrná rychlost zvuku ve vzduchu (m/s)?", List.of("343"), 343));
        questions.add(new Question(16L, "Kolik kostí má lidské tělo?", List.of("206"), 206));
        questions.add(new Question(17L, "Kolik let trvala druhá světová válka?", List.of("6"), 6));
        questions.add(new Question(18L, "Kolik hráčů je na ledě při hokeji v jednom týmu?", List.of("6"), 6));
        questions.add(new Question(19L, "Kolik kilometrů má maraton?", List.of("42.195"), 42));
        questions.add(new Question(20L, "Kolik let je nejvyšší dosažený lidský věk?", List.of("122"), 122));
        questions.add(new Question(21L, "Kolik kilogramů váží průměrný slon?", List.of("6000"), 6000));
        questions.add(new Question(22L, "Kolik znaků má česká abeceda?", List.of("42"), 42));
        questions.add(new Question(23L, "Kolik procent vody obsahuje lidské tělo?", List.of("60"), 60));
        questions.add(new Question(24L, "Kolik je obvyklý počet teček na hrací kostce?", List.of("21"), 21));
        questions.add(new Question(25L, "Kolik dní má přestupný rok?", List.of("366"), 366));
    }

    public List<Question> getAllQuestions() {
        return questions;
    }

    public List<Question> getRandomQuestions(int count) {
        List<Question> shuffled = new ArrayList<>(questions);
        Collections.shuffle(shuffled);
        return shuffled.stream().limit(count).collect(Collectors.toList());
    }
}
