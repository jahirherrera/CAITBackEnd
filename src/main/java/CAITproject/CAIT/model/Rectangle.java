package CAITproject.CAIT.model;



import CAITproject.CAIT.DTO.RectangleDTO;
import jakarta.persistence.*;

@Entity
public class Rectangle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int x;
    private int y;
    private int width;
    private int height;

    @ManyToOne
    @JoinColumn(name = "image_id")
    private Image image;

    public Rectangle() {
    }

    public Rectangle(int x, int width, int y, int height) {
        this.x = x;
        this.width = width;
        this.y = y;
        this.height = height;
    }

    public Rectangle(int y, int x, int width, int height, Image image) {
        this.y = y;
        this.x = x;
        this.width = width;
        this.height = height;
        this.image = image;
    }

    public Rectangle(int id, int y, int x, int width, int height, Image image) {
        this.id = id;
        this.y = y;
        this.x = x;
        this.width = width;
        this.height = height;
        this.image = image;
    }

    public Rectangle(RectangleDTO rectanglesDTO, Image image){
        this.y = rectanglesDTO.y();
        this.x = rectanglesDTO.x();
        this.width = rectanglesDTO.width();
        this.height = rectanglesDTO.height();
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "id=" + id +
                ", x=" + x +
                ", y=" + y +
                ", width=" + width +
                ", height=" + height +
                ", image=" + image +
                '}';
    }
}
