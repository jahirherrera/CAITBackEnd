package CAITproject.CAIT.service;

import CAITproject.CAIT.DTO.ImageDTO;
import CAITproject.CAIT.DTO.ImageResponseDTO;
import CAITproject.CAIT.DTO.QuestionDTO;
import CAITproject.CAIT.model.Group;
import CAITproject.CAIT.model.ImageQuestions;
import CAITproject.CAIT.repo.GroupRepo;
import CAITproject.CAIT.repo.ImageRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class ImageService {

    @Autowired
    ImageRepo imageRepo;

    @Autowired
    GroupRepo groupRepo;

    @Autowired
    private CloudinaryService cloudinaryService;

    public void uploadingImage(ImageDTO imageDTO) throws IOException {
        String url = cloudinaryService.uploadImage(imageDTO.getFile());

        Group group = groupRepo.findById(imageDTO.getGroupId()).orElseThrow(()->new EntityNotFoundException("Group couldn't be found"));

        imageRepo.save(new ImageQuestions(url,group));
    }

    public List<ImageResponseDTO> getAllImagesFromGroup(int id){
        return imageRepo.getImagesFromGroup(id).stream().map(ImageResponseDTO::new).toList();
    }
}
