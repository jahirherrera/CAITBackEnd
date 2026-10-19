package CAITproject.CAIT.DTO;

import CAITproject.CAIT.model.Answer;

public record AnswerDTO(int id, String description, boolean isCorrect) {
    public AnswerDTO(Answer a){
        this(a.getId(), a.getDescription(), a.isCorrect());
    }
}
