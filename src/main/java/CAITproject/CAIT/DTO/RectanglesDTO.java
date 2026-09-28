package CAITproject.CAIT.DTO;

import CAITproject.CAIT.model.Rectangle;

public class RectanglesDTO {

    private int id;
    private int x;
    private int y;
    private int width;
    private int height;
    private int id_image;

    public RectanglesDTO() {
    }

    public RectanglesDTO(int height, int y, int x, int width, int id_image) {
        this.height = height;
        this.y = y;
        this.x = x;
        this.width = width;
        this.id_image = id_image;
    }

    public RectanglesDTO(int id, int x, int y, int width, int height, int id_image) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.id_image = id_image;
    }

    public RectanglesDTO(Rectangle rec){
        this.id=rec.getId();
        this.x = rec.getX();
        this.y = rec.getY();
        this.width = rec.getWidth();
        this.height = rec.getHeight();
        this.id_image = rec.getImage().getId();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_image() {
        return id_image;
    }

    public void setId_image(int id_image) {
        this.id_image = id_image;
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

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    @Override
    public String toString() {
        return "RectanglesDTO{" +
                "id=" + id +
                ", x=" + x +
                ", y=" + y +
                ", width=" + width +
                ", height=" + height +
                ", id_image=" + id_image +
                '}';
    }
}
