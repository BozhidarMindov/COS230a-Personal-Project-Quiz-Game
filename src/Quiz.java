/**

 * File: Quiz.java

 * Author: Bozhidar Mindov

 * Date: 11/27/2022

 */

import java.util.ArrayList;

public class Quiz {
    //This class creates the quiz object that will later be displayed through a GUI.

    private int questionNumber;
    private int score;
    private ArrayList<Question> questionList;

    private Question currentQuestion;

    //Parameter Constructor.
    public Quiz(ArrayList<Question> questionList){
        setQuestionNumber();
        setScore();
        setQuestionList(questionList);
        setCurrentQuestion();
    }

    //Setters.
    public void setScore(){
        this.score = 0;
    }
    public void setQuestionNumber(){
        this.questionNumber=0;
    }
    public void setQuestionList(ArrayList<Question> questionList){
        this.questionList = questionList;
    }
    public void setCurrentQuestion(){
        this.currentQuestion = null;
    }

    //Getters.
    public int getQuestionNumber(){
        return questionNumber;
    }

    public ArrayList<Question> getQuestionList(){
        return questionList;
    }
    public int getScore(){
        return score;
    }

    public Question getCurrentQuestion(){
        //This method returns the current question.

        return questionList.get(questionNumber);
    }

    public boolean questions_left(){
        //This method determines if there are any questions left in the quiz.

        return questionNumber < questionList.size();
    }

    public String displayThisQuestion(){
        //This method returns a formatted string of the current question.

        currentQuestion = getCurrentQuestion();
        return "Q." + (questionNumber + 1) + ": " + currentQuestion.getQuestion();
    }

    public void checkAnswer(boolean userAnswer, boolean answer){
        //This method checks if the answer, that the user chose, matches the real answer to the question.
        //If the answers match, the user's score is incremented.

        if (userAnswer == answer){
            score++;
        }
    }

    public void incrementQuestionNumber(){
        //This method acts as a counter to the number of questions. Used simultaneously wih the `displayThisQuestion` method.
        //If invoked, it increments the questionNumber by 1.

        questionNumber++;
    }
}
