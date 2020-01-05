package com.example.quizprogram;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.Random;

public class Java extends AppCompatActivity {
    Button buttonfi;   // button finish
    Button buttonch1;  // button chosse answer 1
    Button buttonch2;   // button chosse answer 2
    Button buttonch3;   // button chosse answer 3
    Button button;
    Button buttonbackhome;
    TextView score;
    TextView quiz;
    TextView finishT;
    TextView scoretext;
    TextView congrate;
    MediaPlayer click;
    Random random = new Random();
    int count =random.nextInt(3);
    int countscore=0;
    double countnext=1;
    int next ;

    // timer
    CountDownTimer countDownTimer;
    TextView time;
    String [] Quiz = {"What is the size of a Char in Java?","In a “for” loop, what section of the loop is not included in the parentheses after “for”?",
            "Which one is not correct?"};

    String [] Correct = {"16 bits","loop Body","Class and object are just different names for the same thing "};

    String [] button1={" 8 bits ","Test statement","Class and object are just different names for the same thing "};

    String [] button2={" 4 bits ","loop Body","An object is a variable, where its type is the class used to declare the variable"};

    String [] button3={"16 bits","Update","An object exists in memory in run time"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java);
        fini();
        nextQuestion();
        // timer(max,min);
        setButton3();
        setButtonch1();
        setButton2();
        back();
        timer();

        button= findViewById(R.id.btnnext);
        button.setEnabled(false);
        score= findViewById(R.id.Score);
        score.setText("0");
        next=0;
        quiz= findViewById(R.id.Quiz);
        quiz.setText(Quiz[count]);
        buttonch1= findViewById(R.id.btnchoose1);
        buttonch1.setText(button1[count]);
        buttonch2= findViewById(R.id.btnchoose2);
        buttonch2.setText(button2[count]);
        buttonch3= findViewById(R.id.btnchoose3);
        buttonch3.setText(button3[count]);
    }
    int countButton = 0;
    void setButtonch1(){
        buttonch1= findViewById(R.id.btnchoose1);
        buttonch1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button= findViewById(R.id.btnnext);
                button.setEnabled(true);
                next=1;
                countDownTimer.cancel();
                if( button1[count].equals( Correct[count])){
                    click();
                    buttonch1.setBackgroundDrawable(getResources().getDrawable(R.drawable.setcorrect));
                    countnext++;
                    if(countButton == 0)
                        scoreView();
                }else {
                    click();
                    buttonch1.setBackgroundDrawable(getResources().getDrawable(R.drawable.setwrong));
                }
                buttonch3.setEnabled(false);
                buttonch2.setEnabled(false);

                if (button2[count].equals(Correct[count])){
                    buttonch2.setBackgroundDrawable(getResources().getDrawable(R.drawable.setcorrect));
                }else if(button3[count].equals(Correct[count])){
                    buttonch3.setBackgroundDrawable(getResources().getDrawable(R.drawable.setcorrect));
                }

            }
        });
    }

    void setButton2(){
        buttonch2= findViewById(R.id.btnchoose2);
        buttonch2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button= findViewById(R.id.btnnext);
                button.setEnabled(true);
                next=1;
                countDownTimer.cancel();
                if( button2[count].equals(Correct[count])){
                    button= findViewById(R.id.btnnext);
                    button.setEnabled(true);
                    click();
                    buttonch2.setBackgroundDrawable(getResources().getDrawable(R.drawable.setcorrect));
                    countnext++;
                    if(countButton == 0)
                        scoreView();
                }else {
                    click();
                    buttonch2.setBackgroundDrawable(getResources().getDrawable(R.drawable.setwrong));
                }
                buttonch1.setEnabled(false);
                buttonch3.setEnabled(false);

                if (button1[count].equals(Correct[count])){
                    buttonch1.setBackgroundDrawable(getResources().getDrawable(R.drawable.setcorrect));
                }else if(button3[count].equals(Correct[count])){
                    buttonch3.setBackgroundDrawable(getResources().getDrawable(R.drawable.setcorrect));
                }
            }
        });
    }

    void setButton3(){
        buttonch3= findViewById(R.id.btnchoose3);
        buttonch3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button= findViewById(R.id.btnnext);
                button.setEnabled(true);
                next=1;
                countDownTimer.cancel();
                if( button3[count].equals( Correct[count])){
                    click();
                    buttonch3.setBackgroundDrawable(getResources().getDrawable(R.drawable.setcorrect));
                    countnext++;
                    if(countButton == 0)
                        scoreView();
                }else {
                    click();
                    buttonch3.setBackgroundDrawable(getResources().getDrawable(R.drawable.setwrong));
                }
                buttonch2.setEnabled(false);
                buttonch1.setEnabled(false);

                if (button2[count].equals(Correct[count])){
                    buttonch2.setBackgroundDrawable(getResources().getDrawable(R.drawable.setcorrect));
                }else if(button1[count].equals(Correct[count])){
                    buttonch1.setBackgroundDrawable(getResources().getDrawable(R.drawable.setcorrect));
                }
            }
        });

    }
    void nextQuestion(){
        button= findViewById(R.id.btnnext);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button= findViewById(R.id.btnnext);
                button.setEnabled(false);

                buttonch1 = findViewById(R.id.btnchoose1);
                buttonch1.setEnabled(true);
                buttonch2 = findViewById(R.id.btnchoose2);
                buttonch2.setEnabled(true);
                buttonch3 = findViewById(R.id.btnchoose3);
                buttonch3.setEnabled(true);

                countDownTimer.start();
                if(next==1){
                    click();
                    next=0;
                    buttonch1.setBackgroundDrawable(getResources().getDrawable(R.drawable.question));
                    buttonch2.setBackgroundDrawable(getResources().getDrawable(R.drawable.question));
                    buttonch3.setBackgroundDrawable(getResources().getDrawable(R.drawable.question));
                    count = random.nextInt(3);
                    buttonch1.setEnabled(true);
                    buttonch2.setEnabled(true);
                    buttonch3.setEnabled(true);
                    quiz= findViewById(R.id.Quiz);
                    quiz.setText(Quiz[count]);
                    buttonch1= findViewById(R.id.btnchoose1);
                    buttonch1.setText(button1[count]);
                    buttonch2= findViewById(R.id.btnchoose2);
                    buttonch2.setText(button2[count]);
                    buttonch3= findViewById(R.id.btnchoose3);
                    buttonch3.setText(button3[count]);
                }else {
                    click();
                }
            }
        });
    }
    void timer(){
        countDownTimer = new CountDownTimer(30000, 1000) { // delete 0 one
            public void onTick(long millisUntilFinished) {
                time = findViewById(R.id.time);
                time.setText("Time: " + millisUntilFinished / 1000);
            }
            public void onFinish() {
                time = findViewById(R.id.time);
                time.setText("Time out");
                time.getResources().getDrawable(R.drawable.timeout);
                buttonch1 = findViewById(R.id.btnchoose1);
                buttonch1.setEnabled(false);
                buttonch2 = findViewById(R.id.btnchoose2);
                buttonch2.setEnabled(false);
                buttonch3 = findViewById(R.id.btnchoose3);
                buttonch3.setEnabled(false);

                button = findViewById(R.id.btnnext);
                button.setEnabled(true);
            }
        }.start();
    }


    void fini() {
        buttonfi = findViewById(R.id.btnFinishJava);
        buttonfi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishT = (TextView) findViewById(R.id.finish);
                finishT.setVisibility(View.VISIBLE);
                buttonch1.setVisibility(View.INVISIBLE);
                buttonch2.setVisibility(View.INVISIBLE);
                buttonch3.setVisibility(View.INVISIBLE);
                quiz.setVisibility(View.INVISIBLE);
                buttonfi.setVisibility(View.INVISIBLE);
                button = (Button) findViewById(R.id.btnnext);
                button.setVisibility(View.INVISIBLE);
                score.setVisibility(View.INVISIBLE);
                scoretext =(TextView) findViewById(R.id.scoretext);
                scoretext.setVisibility(View.INVISIBLE);
                //congrate =(TextView) findViewById(R.id.congrate);
                //congrate.setVisibility(View.VISIBLE);
                //String str = Integer.toString(countscore);

              finishT.setText("  Your score \n\n " + Integer.toString(countscore));
                buttonbackhome =(Button) findViewById(R.id.btnbackhome);
                buttonbackhome.setVisibility(View.VISIBLE);

                time.setVisibility(View.INVISIBLE);
            }
        });
    }

    void scoreView(){
        score= findViewById(R.id.Score);
        countscore = countscore + 1;
        score.setText(String.valueOf(countscore));
    }
    void click(){
        click = MediaPlayer.create(Java.this,R.raw.btnclick);
        click.start();
    }
    void back (){
        button = findViewById(R.id.btnbackhome);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                close();
            }
            void close() {
                finish();
            }
        });
    }}

