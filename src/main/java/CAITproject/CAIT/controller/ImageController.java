package CAITproject.CAIT.controller;

import CAITproject.CAIT.DTO.ImageDTO;
import CAITproject.CAIT.DTO.ImageResponseDTO;
import CAITproject.CAIT.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;


@RestController
public class ImageController {

    @Autowired
    private ImageService imageService;

    //@ModelAttribute is used for FormData, if you @RequestBody and send a json it will throw you error
    @PostMapping("/image")
    public void uploadingImage(@ModelAttribute ImageDTO imageDTO) throws IOException {
        imageService.uploadingImage(imageDTO);
    }

    @GetMapping("/image/{groupId}")
    public List<ImageResponseDTO> getAllImagesFromGroup(@PathVariable("groupId") int groupId){
        return imageService.getAllImagesFromGroup(groupId);

    }
}
