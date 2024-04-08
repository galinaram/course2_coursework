package course2.coursework.coursework.service;

import course2.coursework.coursework.domain.Question;

import java.util.Collection;

public interface QuestionService {
    Question add(String question, String answer);
    Question add(Question q);
    Question remove (Question question);
    Collection<Question> getAll();
    Question getRandomQuestion();
}
