package CAITproject.CAIT.DTO;

import CAITproject.CAIT.model.Question;

public class QuestionDTO {

    private int id;
    private String description;
    private String answer;
    private int groupId;

    public QuestionDTO() {
    }

    public QuestionDTO(String description, int groupId, String answer) {
        this.description = description;
        this.groupId = groupId;
        this.answer = answer;
    }

    public QuestionDTO(String description, String answer, int groupId, int id) {
        this.description = description;
        this.answer = answer;
        this.groupId = groupId;
        this.id = id;
    }

    public QuestionDTO(Question question) {
        this.description = question.getDescription();
        this.answer = question.getAnswer();
        this.groupId = question.getGroup().getId();
        this.id = question.getId();
    }



    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
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
                ", groupId=" + groupId +
                '}';
    }
}
