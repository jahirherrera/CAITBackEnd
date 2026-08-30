package CAITproject.CAIT.controller;

import CAITproject.CAIT.DTO.GroupDTO;
import CAITproject.CAIT.DTO.QuestionDTO;
import CAITproject.CAIT.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @PostMapping("addQuestion")
    public void addingQuestion(@RequestBody QuestionDTO questionDTO){
        questionService.addingQuestion(questionDTO);

    }
}
