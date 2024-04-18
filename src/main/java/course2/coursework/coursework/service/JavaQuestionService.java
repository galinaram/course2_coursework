package course2.coursework.coursework.service;

import course2.coursework.coursework.domain.Question;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.Random;
import java.util.Set;
@Service
public class JavaQuestionService {
    private final Set<Question> questions;

    public JavaQuestionService(Set<Question> questions) {
        this.questions = questions;
    }

    public Question add(String question, String answer){
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
        else {
        throw new RuntimeException();
        }
    }
    public Collection<Question> getAll(){
        return Collections.unmodifiableCollection(questions);
    }
    public Question getRandomQuestion(){
        if (questions == null || questions.isEmpty()) {
            throw new IllegalArgumentException("The Set cannot be empty.");
        }
        int randomIndex = new Random().nextInt(questions.size());
        int i = 0;
        for (Question element : questions) {
            if (i == randomIndex) {
                return element;
            }
            i++;
        }
        throw new RuntimeException("something went wrong");
    }
}
