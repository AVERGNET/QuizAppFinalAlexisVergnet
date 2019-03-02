/*
 * CSE41246 - Android Java Fundamentals
 * Fall 2019
 * Project #1
 * <Alexis>, <Vergnet>
 */
package com.example.extstudent.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnSTART = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.btnSTART = (Button) findViewById(R.id.btnSTART);
        this.btnSTART.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startGame();
            }
        });
    }
    private void startGame(){
        startActivity(new Intent(MainActivity.this, com.example.extstudent.quizapp.QuizActivity.class));
    }


}
