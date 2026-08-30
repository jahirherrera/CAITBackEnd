package CAITproject.CAIT.model;

import jakarta.persistence.*;

@Entity
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String description;
    private String answer;


    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;


    public Question() {
    }

    public Question(String description, String answer, Group group) {
        this.description = description;
        this.answer = answer;
        this.group = group;
    }

    public Question(int id, Group group, String answer, String description) {
        this.id = id;
        this.group = group;
        this.answer = answer;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", answer='" + answer + '\'' +
                ", group=" + group +
                '}';
    }
}
