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
    private String nextReview;

    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "group")
    private List<Question> question = new ArrayList<>();

    @OneToMany(mappedBy = "group")
    private List<Image> images = new ArrayList<>();

    public Group() {
    }

    public Group(String name, User user) {
        this.name = name;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
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

    public String getNextReview() {
        return nextReview;
    }

    public void setNextReview(String nextReview) {
        this.nextReview = nextReview;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
