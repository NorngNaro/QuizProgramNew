package com.example.quizprogram;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class Cplusplus extends AppCompatActivity {
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
    int count =random.nextInt(8);
    int countscore = 0;
    double countnext=1;
    int next ;

    // do the time
    CountDownTimer countDownTimer;
    TextView time;
    String [] Quiz = {"The default access specifer for the class members is","Which of the following is not the keyword in C++?","Who is Designer of C++ programming language?"
            ,"Which operator is used to resolve the scope of the global variable?","A single line comment in C++ language source code can begin with _____",
    "Which is not a correct variable type in C++ ?","In C++, the keyword void is used to","Which of the following operators could be overloaded?"};

    String [] Correct = {"Private","extends","Bjarne Stroustrup","::","//","real","All the above","+"};


    String [] button1={"Public"," volatile","Bjarne Stroustrup", "*",";","float","indicate an empty argument list to a function","+"};

    String [] button2={"Private","friend","Charles Babbage","::","//","int","specify the return type of function when it is not returning any value","Size of"};

    String [] button3={"Protected","extends","Brain Kernighan",".","/*","real","All the above","+="};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cplusplus);
        fini();
        nextq();
        // timer(max,min);
        setButton1();
        setButton2();
        setButton3();
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
    void setButton1(){
        buttonch1= findViewById(R.id.btnchoose1);
        buttonch1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button= findViewById(R.id.btnnext);
                button.setEnabled(true);
                countDownTimer.cancel();
                next=1;
                if( button1[count].equals( Correct[count])){
                    click();
                    buttonch1.setBackgroundDrawable(getResources().getDrawable(R.drawable.setcorrect));
                    countnext++;
                    if(countButton == 0)
                        scoreview();
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
                countDownTimer.cancel();
                next=1;
                if( button2[count].equals(Correct[count])){
                    button= findViewById(R.id.btnnext);
                    button.setEnabled(true);
                    click();
                    buttonch2.setBackgroundDrawable(getResources().getDrawable(R.drawable.setcorrect));
                    countnext++;
                    if(countButton == 0)
                        scoreview();
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
                countDownTimer.cancel();
                next=1;
                if( button3[count].equals( Correct[count])){
                    click();
                    buttonch3.setBackgroundDrawable(getResources().getDrawable(R.drawable.setcorrect));
                    countnext++;
                    if(countButton == 0)
                        scoreview();
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


    void fini(){
        buttonfi= findViewById(R.id.btnFinishCpp);
        buttonfi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishT= findViewById(R.id.finish);
                finishT.setVisibility( View.VISIBLE);
                buttonch1.setVisibility( View.INVISIBLE);
                buttonch2.setVisibility( View.INVISIBLE);
                buttonch3.setVisibility( View.INVISIBLE);
                quiz.setVisibility( View.INVISIBLE);
                buttonfi.setVisibility(View.INVISIBLE);
                button= findViewById(R.id.btnnext);
                button.setVisibility(View.INVISIBLE);
                score.setVisibility(View.INVISIBLE);
                scoretext= findViewById(R.id.scoretext);
                scoretext.setVisibility( View.INVISIBLE);
                congrate= findViewById(R.id.congrate);
                congrate.setVisibility( View.VISIBLE);
                String str=Integer.toString(countscore);
                finishT.setText("  Your score \n\n "      +str);
                buttonbackhome= findViewById(R.id.btnbackhome);
                buttonbackhome.setVisibility(View.VISIBLE);

                time.setVisibility(View.INVISIBLE);
            }
        });
    }

    void timer(){
        countDownTimer = new CountDownTimer(30000, 1000) {
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
    void nextq(){
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
                    count = random.nextInt(8);
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
    void scoreview(){
        score= findViewById(R.id.Score);
       int temp = countscore + 1;
        score.setText(String.valueOf(temp));
    }

    void click(){
        click = MediaPlayer.create(Cplusplus.this,R.raw.btnclick);
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
    }

}


