/**

 * File: QuizInterface.java

 * Author: Bozhidar Mindov

 * Date: 11/27/2002

 */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class QuizInterface extends JFrame implements ActionListener {
    //This class creates and operates a GUI that the user will use to complete his quiz.

    Quiz quiz;

    JTextPane questionTextPane;

    JLabel scoreLabel;

    JLabel finalScoreLabel;
    JButton trueButton;
    JButton falseButton;

    //Parameter constructor.
    public QuizInterface(Quiz quiz){
        this.quiz = quiz;

        //Creating the main window.
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exits on close
        this.setResizable(false); //prevents this from being resized
        this.setTitle("Quiz Game");
        this.setSize(640, 540);
        ImageIcon image = new ImageIcon("icons/quiz.png"); //Setting an icon to the main window
        this.setIconImage(image.getImage());
        this.getContentPane().setBackground(new Color(44, 56, 99));
        this.setLayout(null);

        //Creating a question label.
        questionTextPane = new JTextPane();
        questionTextPane.setBounds(80,60,450,150);
        questionTextPane.setBackground(new Color(238,238,238));
        questionTextPane.setForeground(new Color(52, 52, 52));
        questionTextPane.setFont(new Font("Roboto",Font.BOLD,28));
        questionTextPane.setEditable(false);
        questionTextPane.setFocusable(false);
        questionTextPane.setOpaque(true);

        //Creating a score label.
        scoreLabel = new JLabel();
        scoreLabel.setBounds(220,230,180,50);
        scoreLabel.setForeground(new Color(255, 255, 255));
        scoreLabel.setFont(new Font("Roboto",Font.BOLD,30));
        scoreLabel.setHorizontalTextPosition(JLabel.CENTER);
        scoreLabel.setVerticalTextPosition(JLabel.CENTER);
        scoreLabel.setHorizontalAlignment(JLabel.CENTER);
        scoreLabel.setVerticalAlignment(JLabel.CENTER);
        scoreLabel.setFocusable(false);

        //Creating a final score label. It will display the user's final score in percentages.
        finalScoreLabel = new JLabel();
        finalScoreLabel.setBounds(220,290,180,50);
        finalScoreLabel.setForeground(new Color(255,255,255));
        finalScoreLabel.setFont(new Font("Roboto",Font.BOLD,30));
        finalScoreLabel.setHorizontalTextPosition(JLabel.CENTER);
        finalScoreLabel.setVerticalTextPosition(JLabel.CENTER);
        finalScoreLabel.setHorizontalAlignment(JLabel.CENTER);
        finalScoreLabel.setVerticalAlignment(JLabel.CENTER);
        finalScoreLabel.setFocusable(false);

        //Creating true button.
        trueButton = new JButton("True");
        trueButton.addActionListener(this);
        trueButton.setFocusable(false);
        ImageIcon trueIcon = new ImageIcon("icons/true.png");
        trueButton.setBounds(80, 300, trueIcon.getIconWidth() - 10, trueIcon.getIconHeight());
        trueButton.setIcon(trueIcon);

        //Creating a false button.
        falseButton = new JButton("False");
        falseButton.addActionListener(this);
        falseButton.setFocusable(false);
        ImageIcon falseIcon = new ImageIcon("icons/false.png");
        falseButton.setIcon(falseIcon);
        falseButton.setBounds(440, 300, falseIcon.getIconWidth() - 10, falseIcon.getIconHeight());

        //Adding all components to the frame (GUI window).
        this.add(questionTextPane);
        this.add(scoreLabel);
        this.add(trueButton);
        this.add(falseButton);
        this.setVisible(true); // //Making the frame visible

        //Fetching the first question to start the quiz.
        showNextQuestion();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //This method implementation gives functionality to the true and false buttons.

        //When the user presses the `true` button.
        if (e.getSource() == trueButton){
            //checks if the answer is correct
            quiz.checkAnswer(true, quiz.getCurrentQuestion().getAnswer());
        }
        //When the user presses the `false` button.
        else if (e.getSource() == falseButton){
            //checks if the answer is correct.
            quiz.checkAnswer(false, quiz.getCurrentQuestion().getAnswer());
        }

        //Fetching the next question
        quiz.incrementQuestionNumber();
        showNextQuestion();
    }

    public void showNextQuestion(){
        //This method displays the next question in the textPanel of the GUI until there are no questions left.
        //When there are no questions left, the final message and the user's final score in percentages are shown. All buttons are disabled.

        scoreLabel.setText("Score: " + quiz.getScore() + "/" + quiz.getQuestionNumber());
        if (quiz.questions_left()){
            questionTextPane.setText(quiz.displayThisQuestion());
        }
        else{
            questionTextPane.setText("You have completed the quiz!");

            this.add(finalScoreLabel);
            double percentageScore = ((double)quiz.getScore() / 10) * 100;
            finalScoreLabel.setText((int) percentageScore + "%");

            disableButtons();
        }
    }

    public void disableButtons(){
        //This method disables the true and false buttons. Invoked after the last question has been answered.

        trueButton.setEnabled(false);
        falseButton.setEnabled(false);
    }
}
