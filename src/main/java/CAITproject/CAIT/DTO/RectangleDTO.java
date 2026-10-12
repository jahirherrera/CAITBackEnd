package CAITproject.CAIT.DTO;

import CAITproject.CAIT.model.Rectangle;

public record RectangleDTO(int id, int x, int y, int width, int height, int imageId) {

    public RectangleDTO(Rectangle rect ){
        this(rect.getId(), rect.getX(), rect.getY(), rect.getWidth(), rect.getHeight(), rect.getImage().getId());
    }
}
