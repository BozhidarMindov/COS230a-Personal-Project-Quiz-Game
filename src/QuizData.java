/**

 * File: QuizData.java

 * Author: Bozhidar Mindov

 * Date: 11/27/2002

 */

public class QuizData {
    //The question's index matches the answer's index.

    private String[] questions;

    private boolean[] answers;

    // Constructor.
    public QuizData(){
        setQuestions();
        setAnswers();
    }

    //Setters.
    public void setQuestions(){
        this.questions = new String[]{
                "AUBG is in Bulgaria.", //0
                "Everest is the tallest peak in the world.", //1
                "Linux was first created as an alternative to Windows XP.", //2
                "Plovdiv is the capital of Bulgaria.", //3
                "Germany won the World Cup in 2018.", //4
                "The C programming language is object-oriented.", //5
                "The world’s largest island is Greenland.", //6
                "Aladdin’s character was inspired by Tom Cruise.", //7
                "J.K. Rowling authored the famous Harry Potter book series.", //8
                "Pigs don’t like being cleaned and hence they roll in the mud.", //9
                "Kangaroos keep food in their pouches next to their children.", //10
                "Italy is where the Caesar salad is from.",  //11
                "The capital of Australia is Sydney.",  //11
                "Polar bears can only live in the Arctic region, not in the Antarctic.", //13
                "Vatican City is a country.", //14
                "RAM stands for Random Access Memory.", //15
                "In the movie \"The Revenant\", DiCaprio's character hunts down the killer of his son.", //16
                "The United States of America was the first country to launch a man into space.", //17
                "The United States was a member of the League of Nations.", //18
                "Rabbits are carnivores.", //19
                "California is larger than Japan.", //20
                "There are no deserts in Europe.", //21
                "There is a city called Rome in every continent on Earth.", //22
                "The Great Wall of China is visible from the moon.", //23
                "Pluto is a planet." //24
            };
    }

    public void setAnswers(){
        this.answers = new boolean[]{
                true, //0
                true, //1
                true, //2
                false, //3
                true, //4
                false, //5
                true, //6
                true, //7
                true, //8
                false, //9
                false, //10
                false, //11
                false, //12
                true, //13
                true, //14
                true, //15
                true, //16
                false, //17
                false, //18
                false, //19
                true, //20
                true, //21
                false, //22
                false, //23
                false, //24
        };
    }

    //Getters.
    public String[] getQuestions(){
        return questions;
    }

    public boolean[] getAnswers(){
        return answers;
    }
}
