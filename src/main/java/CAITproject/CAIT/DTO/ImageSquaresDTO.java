package CAITproject.CAIT.DTO;

import CAITproject.CAIT.model.Image;
import CAITproject.CAIT.model.Rectangle;

import java.util.List;

public record ImageSquaresDTO(int id, String url, int groupId, int points, List<RectangleDTO> rectangles) {

    public ImageSquaresDTO(Image image){
        this(image.getId(), image.getUrl_image(),image.getGroup().getId(),image.getPoints(),image.getRectangles().stream().map(RectangleDTO::new).toList());
    }
}
