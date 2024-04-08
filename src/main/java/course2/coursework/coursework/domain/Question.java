package course2.coursework.coursework.domain;

public class Question {
    private final String question;
    private final String answer;
    public Question(String question, String answer){
        this.question = question;
        this.answer = answer;
    }
    public String getQuestion(){
        return question;
    }
    public String getAnswer(){
        return answer;
    }
    public String toString(){
        return "question: " + question + " answer: " + answer;
    }

}

