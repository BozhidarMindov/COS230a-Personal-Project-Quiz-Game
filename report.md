### HW3 Design Your Own Homework
### Bozhidar Mindov's Personal Java Project
### 27/11/2022

# Quiz GUI Game  - Report

## Description of the program
___

### The aim of the program is to create a *Quiz Game*, where the user could be able to give answers to various different *true/false* questions.

- The program uses a **GUI** to visualize the game and make it more interactive.
- The program picks `10` questions **at random** from the improvised database and with them, it initializes the quiz.
- The user will be able to see the current question of the quiz.
- The user is able to choose from 2 options - `true` or `false`. They lock in their choice by clicking their desired button.
- When the user answers the question **right**, their score will be **incremented**.
- After answering the last question, their percentage of right answers will be displayed along the user's final score.

## Classes:
___
The program has `5` classes in total:

### QuestionData
**The aim of this class is to store the data for all questions and answers.**

#### Data Attributes

- `private String[] questions;` - array of strings that stores all questions' data.

- `private boolean[] answers;` - array of booleans that stores all the true/false answers.

**All indexes of the two arrays match, so we can expect to have a certain question and the matching answer in the corresponding arrays under the same index.**

#### Methods

`public QuizData()` - a constructor. When invoked, an object of class `QuizData` is created. Doesn't accept any parameters.

- Getters

  `public String[] getQuestions()`

  `public boolean[] getAnswers()`

- Setters
  
  `public void setQuestions()`
  
  `public void setAnswers()`

  **The data is already pre-set in the setters, so it is going to be the same each time the program is run.**

___

### Question
**This class is used for creating `Question` objects. It is later utilized by the `Quiz` and `QuizInterface` classes.**

#### Data Attributes

- `private String question;` - stores the question.
- `private boolean answer;` - stores the answer to the question.

#### Methods

`public Question(String question, boolean answers)` - parameter constructor. When invoked, an object of class `Question` is created.

- Getters

    `public String getQuestion()`

    `public boolean getAnswer()`


- Setters
    
    `public void setQuestion(String question)`

    `public void setAnswer(boolean question)`
___

### Quiz
**This class' purpose is to construct the final quiz that will later be displayed to the user.**

#### Data Attributes

- `private int questionNumber;` - keeps track of the current question number.
- `private int score;` - keeps track of the user's score.
- `private ArrayList <Question> questionList;` - the quiz's data, stored in an `ArrayList` of questions.
- `private Question currentQuestion;` - the current question, the one displayed on the screen.

#### Methods

`public Quiz(ArrayList<Question> questionList)` - parameter constructor, accepts only the `ArrayList` with quiz data. Everything else is set to `0` or `null` at the beginning. When the constructor is invoked, an object of class `Quiz` is created.

- Getters

    `public int getQuestionNumber()`

    `public ArrayList<Question> getQuestionList()`

    `public int getScore()`

    `public Question getCurrentQuestion()`


- Setters

    `public void setScore()`

    `public void setQuestionNumber()`

    `public void setQuestionList(ArrayList<Question> questionList)`

    `public void setCurrentQuestion()`


- Other methods

    `public boolean questions_left()` - determines whether there are any questions left.
  
    `public String displayThisQuestion()` - displays the current question, formatted to fit the question text pane in the GUI.

    `public void checkAnswer(boolean userAnswer, boolean answer)` - checks if the user answered correctly - if yes - the total score is incremented.

    `public void incrementQuestionNumber()` - increments the question number. Used simultaneously with the `displayThisQuestion` method.
___

### QuizInterface `extends JFrame implements ActionListener`
**This class is used to build the GUI that the user will be interacting with. It uses a `Quiz` object to operate. The class inherits the `JFrame` class and makes use of some of its functionality. It also implements the `ActionListener` interface, which gives functionality to the buttons**.

#### Data Attributes

- `Quiz quiz;` - represents the quiz that the user will see.
- `JTextPane questionTextPane;` - the text pane, that each question will be placed into.
- `JLabel scoreLabel;` - the label, which will display the user's score.
- `JLabel finalScoreLabel;` - the label, which will display the final user's score using percentages. Will be made visible after the end of the quiz.
- `JButton trueButton;` - the button, which the user will click if they think the answer to the current question is **true**.
- `JButton falseButton;` - the button, which the user will click if they think the answer to the current question is **false**.

#### Methods

`public QuizInterface(Quiz quiz)` - parameter constructor, accepts only a `Quiz` object. All the buttons, labels and the text pane of the GUI are also added here. The first question is initialized in here, as well. When invoked, an object of class `QuizInterface` is created.

```
@Override
public void actionPerformed(ActionEvent e)
``` 
The method above is implemented from the `ActionListener` interface. It gives functionality to the two buttons and checks if the user's answer is **correct**. It also changes the score and the questions.

`public void showNextQuestion()` - displays the next question. If there are no more questions to be displayed, this method displays the final text, along with the user's percentage score, and disables the buttons.

`public void disableButtons()` - disables all buttons. The method is invoked at the end of the quiz, when there are no questions left.
___

### Main
**This is the driver class of the project. It groups the functionality of every other class and puts the quiz together.**

#### Methods

`public static void main(String[] args)` - the main method of the program, where all class objects are created.

- Firstly, the data for the quiz is initialized.
- Then, all questions and answers are put into an `ArrayList`. I chose to use an `ArrayList` because it makes it is easier to add or remove elements.
- After that, we pick `10` questions at random, and store them in a new `ArrayList`.
- With that new `ArrayList`, a `Quiz` object is initialized, and with it, a new `QuizUI`object, which displays the quiz to the user.

`public static ArrayList<Question> getRandomList(ArrayList<Question> list, int totalItems)` - **picks 10 random elements from an ArrayList**.
The method returns an `ArrayList` with the size of `10`, containing random questions. The elements are always different from each other, because when an element is picked and placed in the final `ArrayList`, it is removed from the initial one, that we are picking from. This ensures we won't end up with 2 questions that are the same in the final quiz.
___





