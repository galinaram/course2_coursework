package course2.coursework.coursework.controller;

import course2.coursework.coursework.domain.Question;
import course2.coursework.coursework.service.JavaQuestionService;
import course2.coursework.coursework.service.QuestionService;
import course2.coursework.coursework.service.QuestionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/exam/java")
public class JavaQuestionController {
    @Autowired
    private  QuestionService questionService;

    @GetMapping("/add")
    public Question addQuestion(@RequestParam String question, @RequestParam String answer){
        return questionService.add(question, answer);
    }
    @GetMapping("/remove")
    public Question removeQuestion(@RequestParam String question, @RequestParam String answer){
        Question removed = new Question(question, answer);
        return questionService.remove(removed);
    }
    @GetMapping
    public Collection<Question> getQuestions(){
        return questionService.getAll();
    }
    @GetMapping("/test")
    public String test(){
        return "test";
    }
}
