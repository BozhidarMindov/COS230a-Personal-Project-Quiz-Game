/**

 * File: Question.java

 * Author: Bozhidar Mindov

 * Date: 11/27/2002

 */

public class Question {
    //This class stores the information about question/answers of the question list.

    private String question;
    private boolean answer;

    //Parameter constructor.
    Question(String question, boolean answer) {
        setQuestion(question);
        setAnswer(answer);
    }

    //Setters.
    public void setQuestion(String question) {
        this.question = question;
    }
    public void setAnswer(boolean answer) {
        this.answer = answer;
    }

    //Getters.
    public String getQuestion() {
        return question;
    }
    public boolean getAnswer() {
        return answer;
    }
}
