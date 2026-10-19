package CAITproject.CAIT.controller;

import CAITproject.CAIT.DTO.GroupDTO;
import CAITproject.CAIT.DTO.QuestionAnswerDTO;
import CAITproject.CAIT.DTO.QuestionDTO;
import CAITproject.CAIT.DTO.QuestionResponseDTO;
import CAITproject.CAIT.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @PostMapping("/addQuestion")
    public void addingQuestion(@RequestBody QuestionAnswerDTO question){
        questionService.addingQuestion(question);
    }

    @DeleteMapping("/deletingQuestion/{id}")
    public void deletingQuestion(@PathVariable("id") int id){
        questionService.deleteQuestion(id);
    }

    @GetMapping("/getQuestions/{id}")
    public List<QuestionResponseDTO> getQues(@PathVariable("id")int id){
        return questionService.getQuestions(id);
    }

    @GetMapping("/getQuestionsTest/{id}")
    public List<QuestionAnswerDTO> getQuestionTest(@PathVariable("id")int id){
        return questionService.getQuestionsTest(id);
    }


}
