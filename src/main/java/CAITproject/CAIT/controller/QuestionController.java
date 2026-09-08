package CAITproject.CAIT.controller;

import CAITproject.CAIT.DTO.GroupDTO;
import CAITproject.CAIT.DTO.QuestionDTO;
import CAITproject.CAIT.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @PostMapping("/addQuestion")
    public void addingQuestion(@RequestBody QuestionDTO questionDTO){
        questionService.addingQuestion(questionDTO);
    }

    @DeleteMapping("/deletingQuestion/{id}")
    public void deletingQuestion(@PathVariable("id") int id){
        questionService.deleteQuestion(id);
    }

    @GetMapping("/getQuestions/{id}")
    public List<QuestionDTO> getQues(@PathVariable("id")int id){
        return questionService.getQuestions(id);
    }
}
