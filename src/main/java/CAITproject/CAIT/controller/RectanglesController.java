package CAITproject.CAIT.controller;


import CAITproject.CAIT.DTO.RectanglesDTO;
import CAITproject.CAIT.service.RectangleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RectanglesController {

    @Autowired
    RectangleService rectangleService;

    @PostMapping("/rectangle")
    public void saveRectangle(@RequestBody List<RectanglesDTO> rectangles){
        if(rectangles==null) return;

        rectangleService.saveRect(rectangles);
    }

    @GetMapping("/rectangle/{id_image}")
    public List<RectanglesDTO> getRectanglesFromImage(@PathVariable("id_image")int id){
        return rectangleService.getRectanglesFromImage(id);
    }

    @DeleteMapping("/rectangle/{id}")
    public void deletingRectangle(@PathVariable("id")int id){
        rectangleService.deleteById(id);
    }

}
