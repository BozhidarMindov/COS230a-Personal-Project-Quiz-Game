/**

 * File: Main.java

 * Author: Bozhidar Mindov

 * Date: 11/27/2002

 */

import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        //Creating an object of the data class.
        QuizData data = new QuizData();

        //Storing the questions and the answers into variables (for improved readability).
        String[] questions = data.getQuestions();
        boolean[] answers = data.getAnswers();

        //Creating an ArrayList of all questions.
        ArrayList<Question> allQuestionList = new ArrayList<Question>();

        //Adding all questions, and their answers, into an ArrayList.
        for (int i =0; i < questions.length; i++){
              String question = questions[i];
              boolean answer = answers[i];
              Question q = new Question(question, answer);
              allQuestionList.add(q);
        }

        //Choosing randomly 10 questions that will be in the quiz.
        ArrayList<Question> finalList = getRandomList(allQuestionList, 10);

        //Constructing the quiz object.
        Quiz quiz = new Quiz(finalList);

        //Creating the GUI for the quiz.
        QuizInterface quizUI = new QuizInterface(quiz);
    }
    public static ArrayList<Question> getRandomList(ArrayList<Question> list, int totalItems) {
        //This function picks 10 random questions and places them into an Arraylist, that will be used for the quiz.

        Random random = new Random();

        //Creates a list that will contain the 10 questions.
        ArrayList<Question> finalList = new ArrayList<>();

        for (int i = 0; i < totalItems; i++) {
            //Takes a random index between 0 to the size of the list (10 in this case)
            int randomIndex = random.nextInt(list.size());

            //Adds the elements to the final list.
            finalList.add(list.get(randomIndex));

            //Removes the selected question from initial list. This ensures the question cannot be picked more than 1 time.
            list.remove(randomIndex);
        }
        return finalList;
    }
}