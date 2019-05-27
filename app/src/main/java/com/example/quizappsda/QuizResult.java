package com.example.quizappsda;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class QuizResult extends AppCompatActivity {
    Button btnRestart;
    TextView txtTotalScore,txtTotalAnswers,txtTotalTime,txtAvgScore,txtRemarks;
    Intent send, receive;int score;int avgScore;long time;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_result);
        btnRestart=findViewById(R.id.btnRestartQuiz);
        txtTotalScore=findViewById(R.id.txtTotalScore);
        txtTotalAnswers=findViewById(R.id.txtTotalCorrect);
        txtTotalTime=findViewById(R.id.txtTotalTime);
        txtAvgScore=findViewById(R.id.txtAvgScore);
        txtRemarks=findViewById(R.id.txtRemarks);
        receive =getIntent();
        score= receive.getIntExtra("score",0);
        time =receive.getLongExtra("time",0);
        txtTotalTime.setText(time+" sec");
        txtTotalScore.setText(score+"");
        txtTotalAnswers.setText(score+"/20");
        avgScore=((score*100)/10);
        txtAvgScore.setText(avgScore+" %");
        if(avgScore<20)
        {
            txtRemarks.setText("\"On the bright side, you can only go up from here!\"");
        }
        else if(avgScore>20&&avgScore<70){

            txtRemarks.setText("\"Could be worse. At least it\'s not raining.\"");
        }
        else if(avgScore>70 && avgScore<90){

            txtRemarks.setText("\"Close, but no cigar! Smoking is bad for your health anyway.\"");
        }
        else if(avgScore>90){

            txtRemarks.setText("\"Sensational! Your parents must be so proud.\"");
        }

    }
}
