package CAITproject.CAIT.controller;

import CAITproject.CAIT.DTO.RectangleDTO;
import CAITproject.CAIT.service.RectangleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RectanglesController {

    @Autowired
    RectangleService rectangleService;

    @PostMapping("/rectangle")
    public void saveRectangle(@RequestBody List<RectangleDTO> rectangles){
        if(rectangles==null) return;

        rectangleService.saveRect(rectangles);
    }

    @GetMapping("/rectangle/{id_image}")
    public List<RectangleDTO> getRectanglesFromImage(@PathVariable("id_image")int id){
        return rectangleService.getRectanglesFromImage(id);
    }

    @DeleteMapping("/rectangle/{id}")
    public void deletingRectangle(@PathVariable("id")int id){
        rectangleService.deleteById(id);
    }

}
