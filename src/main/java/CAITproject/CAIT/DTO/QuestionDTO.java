package CAITproject.CAIT.DTO;

import CAITproject.CAIT.model.Question;

import java.util.List;

public record QuestionDTO(int id, String description, String explanation, int points, boolean isEnable) {

    public QuestionDTO(Question q){
        this(q.getId(), q.getDescription(), q.getExplanation(), q.getPoints(), q.isEnable());
    }

}
