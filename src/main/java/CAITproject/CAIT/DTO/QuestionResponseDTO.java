package CAITproject.CAIT.DTO;

import CAITproject.CAIT.model.Answer;
import CAITproject.CAIT.model.Question;

public record QuestionResponseDTO(int id, String description, String explanation, boolean isEnable, String answer,int points, int groupId) {

    public QuestionResponseDTO(Question q){
        this(q.getId(),q.getDescription(),q.getExplanation(),q.isEnable(),q.getAnswers().stream().filter(Answer::isCorrect).map(Answer::getDescription).findFirst().orElse(""),q.getPoints(),q.getGroup().getId());
    }

}
