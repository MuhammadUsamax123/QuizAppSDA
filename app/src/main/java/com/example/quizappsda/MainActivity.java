package com.example.quizappsda;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnStartQuiz;
    Intent mainIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnStartQuiz=findViewById(R.id.btnStartQuiz);
        btnStartQuiz.setOnClickListener(this);
        mainIntent= new Intent(this,Question1.class);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case (R.id.btnStartQuiz):
                startActivity(mainIntent);
                break;
        }
    }
}
