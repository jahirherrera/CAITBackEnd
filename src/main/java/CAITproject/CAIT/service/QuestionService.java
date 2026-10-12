package CAITproject.CAIT.service;


import CAITproject.CAIT.DTO.AnswerDTO;
import CAITproject.CAIT.DTO.QuestionAnswerDTO;
import CAITproject.CAIT.DTO.QuestionDTO;
import CAITproject.CAIT.DTO.QuestionResponseDTO;
import CAITproject.CAIT.model.Answer;
import CAITproject.CAIT.model.Group;
import CAITproject.CAIT.model.Question;
import CAITproject.CAIT.repo.AnswerRepo;
import CAITproject.CAIT.repo.GroupRepo;
import CAITproject.CAIT.repo.QuestionRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {

    @Autowired
    QuestionRepo questionRepo;

    @Autowired
    GroupRepo groupRepo;

    @Autowired
    AnswerRepo answerRepo;


    //this is adding the question with the answers
    @Transactional
    public void addingQuestion(QuestionResponseDTO q){


        Group group = groupRepo.findById(q.groupId()).orElseThrow(()->new EntityNotFoundException("image cannot be found"));

        Question question = new Question(q.explanation(),q.description(),0,true ,group);

        questionRepo.save(question);

        Answer answer = new Answer(question,true,q.answer());

        answerRepo.save(answer);

    }

    public List<QuestionResponseDTO> getQuestions(int id){

        return questionRepo.getQuestionFromGroup(id).stream().map(QuestionResponseDTO::new).toList();

    }

    public void deleteQuestion(int id){
        questionRepo.deleteById(id);
    }
}
