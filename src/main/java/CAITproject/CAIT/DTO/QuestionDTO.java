package CAITproject.CAIT.DTO;

import CAITproject.CAIT.model.Question;

public class QuestionDTO {

    private int id;
    private String description;
    private String answer;
    private String groupName;

    public QuestionDTO() {
    }

    public QuestionDTO(String description, String answer, String groupName) {
        this.description = description;
        this.answer = answer;
        this.groupName = groupName;
    }

    public QuestionDTO(int id, String description, String groupName, String answer) {
        this.id = id;
        this.description = description;
        this.groupName = groupName;
        this.answer = answer;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "QuestionDTO{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", answer='" + answer + '\'' +
                ", groupName='" + groupName + '\'' +
                '}';
    }
}
