package com.example.quizappsda;

import android.content.Intent;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Question5 extends AppCompatActivity {

    Button btnNext;
    boolean correctAnswer;
    TextView txtScore,txtQuestCount,txtTimer;
    RadioGroup quizOptions;
    RadioButton option1,option2,option3,option4;
    Intent send, receive;
    int score,qCount;long time;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question5);
        correctAnswer=false;
        qCount=score=0;
        btnNext=findViewById(R.id.btnNext);
        txtScore=findViewById(R.id.txtScore);
        txtQuestCount=findViewById(R.id.txtQuestCount);
        txtTimer=findViewById(R.id.txtTime);
        quizOptions = findViewById(R.id.radioQuizOptions);
        option1=findViewById(R.id.radioOption1);
        option2=findViewById(R.id.radioOption2);
        option3=findViewById(R.id.radioOption3);
        option4=findViewById(R.id.radioOption4);
        receive =getIntent();
        score= receive.getIntExtra("score",0);
        qCount= receive.getIntExtra("qCount",0);
        time= receive.getLongExtra("time",0);
        qCount++;
        txtScore.setText(""+score);
        txtQuestCount.setText(""+qCount);
        quizOptions.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(option1.isChecked()){

                    correctAnswer=false;
                }
                if(option2.isChecked()){

                    correctAnswer=false;
                }
                if(option3.isChecked()){

                    correctAnswer=false;
                }
                if(option4.isChecked()){

                    correctAnswer=true;
                }
            }
        });
        send = new Intent(this,Question6.class);
        new CountDownTimer(15000, 1000) {

            public void onTick(long millisUntilFinished) {

                long seconds=millisUntilFinished/1000;
                time+=seconds;
                txtTimer.setText(""+String.format("%02d:%02d", seconds / 60, seconds % 60));

            }

            public void onFinish() {
                txtTimer.setText("00:00");
                correctAnswer=false;
                changeState();
            }

        }.start();
    }

    private void changeState(){
        for(int i = 0; i < quizOptions.getChildCount(); i++){
            quizOptions.getChildAt(i).setEnabled(false);
        }
        option1.setTextColor(Color.parseColor("#00D400"));
        option2.setTextColor(Color.parseColor("#FF0015"));
        option3.setTextColor(Color.parseColor("#FF0015"));
        option4.setTextColor(Color.parseColor("#FF0015"));
    }
    public void onbtnNextClicked(View view){
        if(correctAnswer==false){
            changeState();
            send.putExtra("score",score);
            send.putExtra("qCount",qCount);
            send.putExtra("time",time);
            startActivity(send);
        }
        else if(correctAnswer){
            score++;
            send.putExtra("score",score);
            send.putExtra("qCount",qCount);
            send.putExtra("time",time);
            startActivity(send);
        }
    }
}
