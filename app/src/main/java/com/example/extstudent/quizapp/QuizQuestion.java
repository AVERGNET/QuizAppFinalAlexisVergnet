package com.example.extstudent.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

public class QuizQuestion extends AppCompatActivity {

    private String question;
    private String choiceA;
    private String choiceB;
    private String choiceC;
    private String choiceD;
    private String correctAnswer;

    // Constructor
    QuizQuestion() {

    }

    protected void setQuestion(String question) {
        this.question = question;
    }

    protected void setChoiceA(String answer) {
        this.choiceA = answer;
    }

    protected void setChoiceB(String answer) {
        this.choiceB = answer;
    }

    protected void setChoiceC(String answer) {
        this.choiceC = answer;
    }

    protected void setChoiceD(String answer) {
        this.choiceD = answer;
    }

    protected void setCorrectAnswer(String correctAnswer) {
       this.correctAnswer = correctAnswer;
    }

    protected String getQuestion() {
       return question;
    }

    protected String getChoiceA() {
       return choiceA;
    }

    protected String getChoiceB() {
        return choiceB;
    }

    protected String getChoiceC() {
        return choiceC;
    }

    protected String getChoiceD() {
        return choiceD;
    }

    protected String getCorrectAnswer() {return  correctAnswer;}

    protected boolean isCorrectAnswer(String answer) {
        if (this.correctAnswer == null) {
            return false;
        }
        if (getCorrectAnswer() == answer){
            return true;
        }
        return false;
    }
}