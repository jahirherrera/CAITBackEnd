package CAITproject.CAIT.service;

import CAITproject.CAIT.DTO.ImageDTO;
import CAITproject.CAIT.DTO.ImageResponseDTO;
import CAITproject.CAIT.DTO.ImageSquaresDTO;
import CAITproject.CAIT.DTO.RectangleDTO;
import CAITproject.CAIT.model.Group;
import CAITproject.CAIT.model.Image;
import CAITproject.CAIT.repo.GroupRepo;
import CAITproject.CAIT.repo.ImageRepo;
import CAITproject.CAIT.repo.RectangleRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class ImageService {

    @Autowired
    ImageRepo imageRepo;

    @Autowired
    GroupRepo groupRepo;

    @Autowired
    RectangleRepo rectangleRepo;

    @Autowired
    private CloudinaryService cloudinaryService;

    public void uploadingImage(ImageDTO imageDTO) throws IOException {
        String url = cloudinaryService.uploadImage(imageDTO.file());

        Group group = groupRepo.findById(imageDTO.groupId()).orElseThrow(()->new EntityNotFoundException("Group couldn't be found"));

        imageRepo.save(new Image(url,group));
    }

    public List<ImageResponseDTO> getAllImagesFromGroup(int id){
        return imageRepo.getImagesFromGroup(id).stream().map(image -> new ImageResponseDTO(image.getId(), image.getUrl_image(), image.getPoints(), image.getGroup().getId())).toList();
    }

    public void deleteImage(int id)throws IOException{

        Image image = imageRepo.findById(id).orElseThrow(()->new EntityNotFoundException("image cannot be found"));

        cloudinaryService.deleteImage(image.getUrl_image());

        rectangleRepo.deleteAllSquareFromImage(id);

        imageRepo.deleteImageFromUrl(image.getUrl_image());
    }

    public List<ImageSquaresDTO> imageSquares(int groupId) {

        return imageRepo.getImagesFromGroup(groupId).stream().map(ImageSquaresDTO::new).toList();

    }
}
