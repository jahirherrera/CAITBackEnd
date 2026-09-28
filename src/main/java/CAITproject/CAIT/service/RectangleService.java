package CAITproject.CAIT.service;

import CAITproject.CAIT.DTO.RectanglesDTO;
import CAITproject.CAIT.model.ImageQuestions;
import CAITproject.CAIT.model.Rectangle;
import CAITproject.CAIT.repo.ImageRepo;
import CAITproject.CAIT.repo.RectangleRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RectangleService {

    @Autowired
    RectangleRepo rectangleRepo;

    @Autowired
    ImageRepo imageRepo;

    public void saveRect(List<RectanglesDTO> rect){

        ImageQuestions image = imageRepo.findById(rect.getFirst().getId_image()).orElseThrow(()->new EntityNotFoundException("Group couldn't be found"));

        for(RectanglesDTO rectangles : rect){
            rectangleRepo.save(new Rectangle(rectangles,image));
        }
    }

    public List<RectanglesDTO> getRectanglesFromImage(int id){
        List<Rectangle> rectangles = rectangleRepo.getRectanglesFromImage(id);

        return rectangles.stream().map(RectanglesDTO::new).toList();
    }

    public void deleteById(int id){
        rectangleRepo.deleteById(id);
    }
}
