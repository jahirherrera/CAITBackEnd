package CAITproject.CAIT.model;


import CAITproject.CAIT.DTO.AnswerDTO;
import jakarta.persistence.*;

@Entity
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String description;
    private boolean isCorrect;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

    public Answer() {
    }

    public Answer(Question question, boolean isCorrect, String description) {
        this.question = question;
        this.isCorrect = isCorrect;
        this.description = description;
    }

    public Answer(int id, Question question, boolean isCorrect, String description) {
        this.id = id;
        this.question = question;
        this.isCorrect = isCorrect;
        this.description = description;
    }

    public Answer(Question question, AnswerDTO answerDTO) {
        this.question = question;
        this.isCorrect = answerDTO.isCorrect();
        this.description = answerDTO.description();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}
