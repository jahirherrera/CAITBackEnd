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
    public void addingQuestion(QuestionAnswerDTO q){


        Group group = groupRepo.findById(q.groupId()).orElseThrow(()->new EntityNotFoundException("image cannot be found"));

        Question question = new Question(q.questionDTO().explanation(),q.questionDTO().description(),0,true ,group);

        questionRepo.save(question);

        for(AnswerDTO answers : q.answerDTO()){
            Answer answer = new Answer(question,answers.isCorrect(),answers.description());

            answerRepo.save(answer);
        }

    }

    public List<QuestionResponseDTO> getQuestions(int id){

        return questionRepo.getQuestionFromGroup(id).stream().map(QuestionResponseDTO::new).toList();

    }

    @Transactional
    public void deleteQuestion(int id){

        answerRepo.deleteAllAnswerFromQuestion(id);

        questionRepo.deleteById(id);
    }

    public List<QuestionAnswerDTO> getQuestionsTest(int id) {
        List<Question> questions = questionRepo.getQuestionFromGroup(id);

        return questions.stream().map(question -> new QuestionAnswerDTO(id,new QuestionDTO(question),question.getAnswers().stream().map(AnswerDTO::new).toList())).toList();
    }
}
