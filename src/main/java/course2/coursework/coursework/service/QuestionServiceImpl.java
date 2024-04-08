package course2.coursework.coursework.service;

import course2.coursework.coursework.domain.Question;
import org.springframework.stereotype.Service;

import java.util.*;
@Service
public class QuestionServiceImpl implements QuestionService{
    private final List<Question> questions = new ArrayList<>();

    public Question add(String question, String answer) {
        Question question1 = new Question(question, answer);
        if(questions.contains(question1)) {
            throw new RuntimeException("такой вопрос уже есть");
        }
        questions.add(question1);
        return question1;
    }
    public Question add(Question q){
        if(questions.contains(q)) {
            throw new RuntimeException("такой вопрос уже есть");
        }
        questions.add(q);
        return q;
    }
    public Question remove (Question question){
        if (questions.contains(question)){
            questions.remove(question);
            return question;
        }
        throw new RuntimeException();
    }
    public Collection<Question> getAll(){
        return Collections.unmodifiableCollection(questions);
    }
    public Question getRandomQuestion(){
        Random random = new Random();
        return questions.get(random.nextInt(questions.size()));
    }
}
