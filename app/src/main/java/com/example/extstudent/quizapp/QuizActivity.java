package com.example.extstudent.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;

public class QuizActivity extends AppCompatActivity {

    //Widgets
    private ArrayList<QuizQuestion> quizQuestionList = null;
    QuizQuestion currentQuestion = null;
    int currentQuestionNumber = 1;

    private int currentScore = 0;
    private int maxScore = 0;

    TextView textViewQuestionTitle = null;
    TextView textViewQuestion = null;
    TextView textViewScore = null;

    RadioGroup radioGroupQuestion = null;
    RadioButton radioButtonA = null;
    RadioButton radioButtonB = null;
    RadioButton radioButtonC = null;
    RadioButton radioButtonD = null;

    Button buttonSubmit = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        // Initialize widgets.
        this.textViewQuestionTitle = (TextView)findViewById(R.id.textViewQuestionTitle);    // The question title
        this.textViewQuestion = (TextView)findViewById(R.id.textViewQuestion);              // The question asked.
        this.textViewScore = (TextView)findViewById(R.id.textViewScore);                    // The current score.

        // Initialize the radio buttons for question multiple choice answers.
        radioGroupQuestion = (RadioGroup)findViewById(R.id.radioGroup);             // Create a group for radio buttons.
        radioButtonA = (RadioButton)findViewById(R.id.ChoiceA);
        radioButtonB = (RadioButton)findViewById(R.id.ChoiceB);
        radioButtonC = (RadioButton)findViewById(R.id.ChoiceC);
        radioButtonD = (RadioButton)findViewById(R.id.ChoiceD);

        // Initialize the submit question answer along with the callback function.
        buttonSubmit = (Button)findViewById(R.id.buttonSubmit);
        this.buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validateAnswer()) {
                    if(currentQuestionNumber < maxScore) {
                        currentQuestion = quizQuestionList.get(currentQuestionNumber);
                        setQuestionView(currentQuestion);
                        currentQuestionNumber++;
                    }
                    else {
                        Intent inent = new Intent(com.example.extstudent.quizapp.QuizActivity.this, com.example.extstudent.quizapp.ResultsActivity.class);
                        inent.putExtra("current_score", currentScore);
                        inent.putExtra("max_score", maxScore);
                        startActivity(inent);
                    }
                }
            }
        });

         // Initiate all questions first.
        this.initQuestions();

        // Ask use the first question when this activity loads.
        this.setQuestionView(this.currentQuestion);
    }

    QuizQuestion firstQuestion = null;
    QuizQuestion secondQuestion = null;
    QuizQuestion thridQuestion = null;

    private void initQuestions() {
        this.quizQuestionList = new ArrayList<QuizQuestion>();  // Initialize our question array.
        //Question 1
        firstQuestion = new QuizQuestion();
        firstQuestion.setQuestion("What country offered presidency to Albert Einstein in 1952?");
        firstQuestion.setChoiceA("Egypt");
        firstQuestion.setChoiceB("Israel");
        firstQuestion.setChoiceC("Germany");
        firstQuestion.setChoiceD("France");
        firstQuestion.setCorrectAnswer("Israel");
        quizQuestionList.add(firstQuestion);
        //Question 2
        secondQuestion = new QuizQuestion();
        secondQuestion.setQuestion("The scientific unit named after Sir Isaac Newton measures what?");
        secondQuestion.setChoiceA("Distance");
        secondQuestion.setChoiceB("Speed");
        secondQuestion.setChoiceC("Force");
        secondQuestion.setChoiceD("Atomic Decay");
        secondQuestion.setCorrectAnswer("Force");
        quizQuestionList.add(secondQuestion);
        //Question 3
        thridQuestion = new QuizQuestion();
        thridQuestion.setQuestion("What color do you get from adding all the colors of light?");
        thridQuestion.setChoiceA("Blue");
        thridQuestion.setChoiceB("Black");
        thridQuestion.setChoiceC("White");
        thridQuestion.setChoiceD("Rainbow");
        thridQuestion.setCorrectAnswer("White");
        quizQuestionList.add(thridQuestion);



        ///////////////////////////////////////////////////////////////////////////////////////////////////////
        // TO-DO: Set your currentQuestion to point to your first question here (uncomment out the code below).
        ///////////////////////////////////////////////////////////////////////////////////////////////////////

        //this.currentQuestion = /*Your first question*/;
        this.currentQuestion = firstQuestion;

        // Set the current, score, and total question size.
        this.currentQuestionNumber = 1;
        this.maxScore = this.quizQuestionList.size();
        this.currentScore = 0;
    }

    private void setQuestionView(QuizQuestion quizQuestion) {
        if(quizQuestion == null) {
            Log.d("[DEBUG]", "quizQuestion is null in setQuestionView.");
            return;
        }

        // Clear the radio button checks just encase it was been set previously.
        radioGroupQuestion.clearCheck();

       //TODO
        // - Set the score view with the current score (remeber to convert integer to string).
        //   Example: Score: 2
        textViewScore.setText("Score: " + Integer.toString(currentScore));
        textViewQuestion.setText(currentQuestion.getQuestion());
        radioButtonA.setText(currentQuestion.getChoiceA());
        radioButtonB.setText(currentQuestion.getChoiceB());
        radioButtonC.setText(currentQuestion.getChoiceC());
        radioButtonD.setText(currentQuestion.getChoiceD());
        textViewQuestionTitle.setText("Question #" + currentQuestionNumber);
    }


    private boolean validateAnswer() {
        // Validate the current answer selected.
        int selectedButtonId = this.radioGroupQuestion.getCheckedRadioButtonId();
        if(selectedButtonId != -1) {
            String answerSelectedStr = ((RadioButton)findViewById(selectedButtonId)).getText().toString();

            if (currentQuestion.isCorrectAnswer(answerSelectedStr)) {
                // Answer is correct.
                Log.d("ANSWER: ", "Correct");
                currentScore++;
            }
            else {
                Log.d("ANSWER: ", "Incorrect");
            }
            return true; // Allow to continue to next question.
        }
        else {
            // No answer selected.
            Toast.makeText(getApplicationContext(), "Please Select An Answer",
                    Toast.LENGTH_SHORT).show();
            return false;
        }
    }
}