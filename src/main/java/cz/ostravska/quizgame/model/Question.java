package cz.ostravska.quizgame.model;

import java.util.List;

public class Question {

    private Long id;
    private String text;
    private List<String> options;
    private int correctAnswerIndex;

    public Question() {
        // prázdný konstruktor pro případné potřeby Springu
    }

    public Question(Long id, String text, List<String> options, int correctAnswerIndex) {
        this.id = id;
        this.text = text;
        this.options = options;
        this.correctAnswerIndex = correctAnswerIndex;
    }

    // gettery a settery
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }

    public int getCorrectAnswerIndex() {
        return correctAnswerIndex;
    }
}
