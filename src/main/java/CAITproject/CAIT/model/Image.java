package CAITproject.CAIT.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String url_image;

    @OneToMany(mappedBy = "image")
    private List<Rectangle> rectangles;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;

    private int points;

    public Image() {
    }

    public Image(String url_image, Group group) {
        this.url_image = url_image;
        this.group = group;
    }

    public Image(int id, String url_image, Group group) {
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

    public List<Rectangle> getRectangles() {
        return rectangles;
    }

    public void setRectangles(List<Rectangle> rectangles) {
        this.rectangles = rectangles;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
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
