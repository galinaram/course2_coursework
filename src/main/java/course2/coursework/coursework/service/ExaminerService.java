package course2.coursework.coursework.service;

import course2.coursework.coursework.domain.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions(int amount);
}
