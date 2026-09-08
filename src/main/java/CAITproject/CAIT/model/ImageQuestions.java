package CAITproject.CAIT.model;

import jakarta.persistence.*;

@Entity
public class ImageQuestions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String url_image;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;

    public ImageQuestions() {
    }

    public ImageQuestions(String url_image, Group group) {
        this.url_image = url_image;
        this.group = group;
    }

    public ImageQuestions(int id, String url_image, Group group) {
        this.id = id;
        this.url_image = url_image;
        this.group = group;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl_image() {
        return url_image;
    }

    public void setUrl_image(String url_image) {
        this.url_image = url_image;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return "ImageQuestions{" +
                "id=" + id +
                ", url_image='" + url_image + '\'' +
                ", group=" + group +
                '}';
    }
}
