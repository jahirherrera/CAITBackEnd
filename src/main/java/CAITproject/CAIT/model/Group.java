package CAITproject.CAIT.model;

import CAITproject.CAIT.DTO.GroupDTO;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "subject")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "group")
    private List<Question> question = new ArrayList<>();

    @OneToMany(mappedBy = "group")
    private List<ImageQuestions> images = new ArrayList<>();

    public Group() {
    }

    public Group(String name) {
        this.name = name;
    }

    public Group(List<Question> question, String name) {
        this.question = question;
        this.name = name;
    }

    public Group(GroupDTO groupDTO) {
        this.name = groupDTO.getName();

    }

    public Group(String name, User user) {
        this.name = name;
        this.user = user;
    }


    public Group(int id, List<Question> question, String name) {
        this.id = id;
        this.question = question;
        this.name = name;
    }

    public Group(List<ImageQuestions> images, List<Question> question, User user, String name, int id) {
        this.images = images;
        this.question = question;
        this.user = user;
        this.name = name;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Question> getQuestion() {
        return question;
    }

    public void setQuestion(List<Question> question) {
        this.question = question;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<ImageQuestions> getImages() {
        return images;
    }

    public void setImages(List<ImageQuestions> images) {
        this.images = images;
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", user=" + user +
                ", question=" + question +
                ", images=" + images +
                '}';
    }
}
