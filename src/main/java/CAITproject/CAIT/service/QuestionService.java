package CAITproject.CAIT.service;


import CAITproject.CAIT.DTO.QuestionDTO;
import CAITproject.CAIT.model.Group;
import CAITproject.CAIT.model.Question;
import CAITproject.CAIT.repo.GroupRepo;
import CAITproject.CAIT.repo.QuestionRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {

    @Autowired
    QuestionRepo questionRepo;

    @Autowired
    GroupRepo groupRepo;

    public void addingQuestion(QuestionDTO questionDTO){


        Group group = groupRepo.findById(questionDTO.getGroupId()).orElseThrow(()->new EntityNotFoundException("Group couldn't be found"));

        Question question = new Question(questionDTO.getDescription(),questionDTO.getAnswer(),group);

        questionRepo.save(question);

    }

    public List<QuestionDTO> getQuestions(int id){
        return questionRepo.getQuestionFromGroup(id).stream().map(QuestionDTO::new).toList();
    }

    public void deleteQuestion(int id){
        questionRepo.deleteById(id);
    }
}
