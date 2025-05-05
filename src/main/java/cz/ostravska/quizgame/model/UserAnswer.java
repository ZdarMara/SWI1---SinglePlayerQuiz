package cz.ostravska.quizgame.model;

public class UserAnswer {
    private Long questionId;
    private AnswerDirection direction;

    public UserAnswer() {
    }

    public UserAnswer(Long questionId, AnswerDirection direction) {
        this.questionId = questionId;
        this.direction = direction;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public AnswerDirection getDirection() {
        return direction;
    }

    public void setDirection(AnswerDirection direction) {
        this.direction = direction;
    }
}
