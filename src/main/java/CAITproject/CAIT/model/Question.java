package CAITproject.CAIT.model;

import CAITproject.CAIT.DTO.QuestionDTO;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String description;
    private String explanation;
    private int points;
    private boolean isEnable;

    @OneToMany(mappedBy = "question")
    private List<Answer> answers = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;


    public Question() {
    }

    public Question(String explanation, String description, int points, boolean isEnable, Group group) {
        this.explanation = explanation;
        this.description = description;
        this.points = points;
        this.isEnable = isEnable;
        this.group = group;
    }

    public Question(int id, String description, String explanation, int points, List<Answer> answers, boolean isEnable, Group group) {
        this.id = id;
        this.description = description;
        this.explanation = explanation;
        this.points = points;
        this.answers = answers;
        this.isEnable = isEnable;
        this.group = group;
    }

    public Question(QuestionDTO questionDTO,Group group) {
        this.description = questionDTO.description();
        this.explanation = questionDTO.explanation();
        this.points = questionDTO.points();
        this.isEnable = questionDTO.isEnable();
        this.group = group;
        this.id = questionDTO.id();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public boolean isEnable() {
        return isEnable;
    }

    public void setEnable(boolean enable) {
        isEnable = enable;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }
}
