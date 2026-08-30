package CAITproject.CAIT.service;


import CAITproject.CAIT.DTO.QuestionDTO;
import CAITproject.CAIT.model.Group;
import CAITproject.CAIT.model.Question;
import CAITproject.CAIT.repo.GroupRepo;
import CAITproject.CAIT.repo.QuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionService {

    @Autowired
    QuestionRepo questionRepo;

    @Autowired
    GroupRepo groupRepo;

    public void addingQuestion(QuestionDTO questionDTO){

        Group group = groupRepo.findByName(questionDTO.getGroupName());

        Question question = new Question(questionDTO.getDescription(),questionDTO.getAnswer(),group);

        questionRepo.save(question);

    }
}
