package course2.coursework.coursework.service;

import course2.coursework.coursework.domain.Question;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class ExaminerServiceImpl implements ExaminerService{
    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    public Collection<Question> getQuestions(){
        Collection<Question> randomQuestions = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            randomQuestions.add(questionService.getRandomQuestion());
        }
        return randomQuestions;
    }
}
