package cz.ostravska.quizgame.model;

public class Question {

    private Long id;
    private String statement; // Tvrzení
    private int actualValue;  // Skutečná hodnota

    public Question() {
    }

    public Question(Long id, String statement, int actualValue) {
        this.id = id;
        this.statement = statement;
        this.actualValue = actualValue;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatement() {
        return statement;
    }

    public void setStatement(String statement) {
        this.statement = statement;
    }

    public int getActualValue() {
        return actualValue;
    }

    public void setActualValue(int actualValue) {
        this.actualValue = actualValue;
    }
}
