package course2.coursework.coursework.controller;

import course2.coursework.coursework.service.ExaminerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExaminerController {
    @Autowired
    ExaminerServiceImpl examinerService;

    @GetMapping
    public String getQuestions(@RequestParam int amount){
        return examinerService.getQuestions(amount).toString();
    }
}
