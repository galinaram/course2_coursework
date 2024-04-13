package course2.coursework.coursework;

import course2.coursework.coursework.domain.Question;
import course2.coursework.coursework.service.ExaminerService;
import course2.coursework.coursework.service.ExaminerServiceImpl;
import course2.coursework.coursework.service.QuestionService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {
    private final Question question1 = new Question("question1", "answer1");
    private final Question question2 = new Question("question2", "answer2");
    @Mock
    QuestionService questionServiceMock;
    @InjectMocks
    ExaminerServiceImpl examinerService;
    @Test
    public void getQuestionTestNotNull(){
        Mockito.when(questionServiceMock.getAll()).thenReturn(List.of(question1, question2));

        assertThrows(RuntimeException.class, ()->examinerService.getQuestions(1));
    }
    @Test
    public void getQuestionsTest(){
        Mockito.when(questionServiceMock.getAll()).thenReturn(List.of(question1, question2));
        Collection<Question> fullListTest = List.of(question1, question2);

        Collection<Question> getAll = examinerService.getQuestions(5);

        assertThat(fullListTest).containsExactlyInAnyOrderElementsOf(getAll);
        verify(questionServiceMock, times(5)).getRandomQuestion();
    }
}
