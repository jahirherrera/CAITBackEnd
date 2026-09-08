package CAITproject.CAIT.DTO;


import CAITproject.CAIT.model.ImageQuestions;

public class ImageResponseDTO {

    private int id;
    private String url;
    private int groupId;

    public ImageResponseDTO() {
    }

    public ImageResponseDTO(int groupId, int id, String url) {
        this.groupId = groupId;
        this.id = id;
        this.url = url;
    }

    public ImageResponseDTO(ImageQuestions image) {
        this.id = image.getId();
        this.url = image.getUrl_image();
        this.groupId = image.getGroup().getId();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    @Override
    public String toString() {
        return "ImageResponseDTO{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", groupId=" + groupId +
                '}';
    }
}
