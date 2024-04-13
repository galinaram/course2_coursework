package course2.coursework.coursework;

import course2.coursework.coursework.domain.Question;
import course2.coursework.coursework.service.JavaQuestionService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertThrows;


@SpringBootTest
public class JavaQuestionServiceTest {
    @Autowired
    public JavaQuestionService javaQuestionService;
    @Test
    public void addTest(){
        String question = "questionTest";
        String answer = "answerTest";

        Question addTest = javaQuestionService.add(question, answer);

        Assertions.assertEquals(addTest.getQuestion(), question);
        Assertions.assertEquals(addTest.getAnswer(), answer);
    }
    @Test
    public void removeTestException(){
        String question = "questionTest";
        String answer = "answerTest";
        Question question1 = new Question(question,answer);

        Question addTest = javaQuestionService.add(question1);

        assertThrows(RuntimeException.class, ()-> javaQuestionService.remove(question1));
    }
}
