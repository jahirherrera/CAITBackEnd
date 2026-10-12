package CAITproject.CAIT.DTO;

import org.springframework.web.multipart.MultipartFile;

public record ImageDTO(int id, MultipartFile file, int groupId) {
}
