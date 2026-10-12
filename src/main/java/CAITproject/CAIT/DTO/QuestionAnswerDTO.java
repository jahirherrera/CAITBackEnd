package CAITproject.CAIT.DTO;

import java.util.List;

public record QuestionAnswerDTO(int groupId, QuestionDTO questionDTO, List<AnswerDTO> answerDTO) {

}
