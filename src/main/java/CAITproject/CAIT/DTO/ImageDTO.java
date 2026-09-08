package CAITproject.CAIT.DTO;


import org.springframework.web.multipart.MultipartFile;

public class ImageDTO {

    private int id;
    private MultipartFile file;
    private int groupId;

    public ImageDTO() {
    }

    public ImageDTO(MultipartFile file, int groupId) {
        this.file = file;
        this.groupId = groupId;
    }

    public ImageDTO(int id, MultipartFile file, int groupId) {
        this.id = id;
        this.file = file;
        this.groupId = groupId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    @Override
    public String toString() {
        return "ImageDTO{" +
                "id=" + id +
                ", file=" + file +
                ", groupId=" + groupId +
                '}';
    }
}
