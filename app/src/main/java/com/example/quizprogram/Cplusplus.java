package com.example.quizprogram;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;
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
    int countscore=0;
    double countnext=1;
    int next ;
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
        setButtonch3();
        setButtonch1();
        setButtonch2();
        back();
        button=(Button) findViewById(R.id.btnnext);
        button.setEnabled(false);

        score= (TextView) findViewById(R.id.Score);
        score.setText("0");
        next=0;
        quiz= (TextView)findViewById(R.id.Quiz);
        quiz.setText(Quiz[count]);
        buttonch1=(Button) findViewById(R.id.btnchoose1);
        buttonch1.setText(button1[count]);
        buttonch2=(Button) findViewById(R.id.btnchoose2);
        buttonch2.setText(button2[count]);
        buttonch3=(Button) findViewById(R.id.btnchoose3);
        buttonch3.setText(button3[count]);
    }
    void fini(){
        buttonfi=(Button) findViewById(R.id.btnfinish);
        buttonfi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishT=(TextView) findViewById(R.id.finish);
                finishT.setVisibility( View.VISIBLE);
                buttonch1.setVisibility( View.INVISIBLE);
                buttonch2.setVisibility( View.INVISIBLE);
                buttonch3.setVisibility( View.INVISIBLE);
                quiz.setVisibility( View.INVISIBLE);
                buttonfi.setVisibility(View.INVISIBLE);
                button=(Button)findViewById(R.id.btnnext);
                button.setVisibility(View.INVISIBLE);
                score.setVisibility(View.INVISIBLE);
                scoretext=(TextView) findViewById(R.id.scoretext);
                scoretext.setVisibility( View.INVISIBLE);
                congrate=(TextView) findViewById(R.id.congrate);
                congrate.setVisibility( View.VISIBLE);
                String str=Integer.toString(countscore);
                finishT.setText("  Your score \n\n "      +str);
                buttonbackhome=(Button)findViewById(R.id.btnbackhome);
                buttonbackhome.setVisibility(View.VISIBLE);

            }
        });
    }
    void setButtonch1(){
        buttonch1=(Button) findViewById(R.id.btnchoose1);
        buttonch1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button=(Button) findViewById(R.id.btnnext);
                button.setEnabled(true);
                next=1;
                if( button1[count].equals( Correct[count])){
                    click();
                    buttonch1.setBackgroundDrawable(getResources().getDrawable(R.drawable.setcorrect));
                    countscore++;
                    countnext++;
                    scoreview();
                }else {
                    click();
                    buttonch1.setBackgroundDrawable(getResources().getDrawable(R.drawable.setwrong));
                }
                buttonch3.setEnabled(false);
                buttonch2.setEnabled(false);
            }
        });
    }
    void setButtonch3(){
        buttonch3=(Button) findViewById(R.id.btnchoose3);
        buttonch3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button=(Button) findViewById(R.id.btnnext);
                button.setEnabled(true);
                next=1;
                if( button3[count].equals( Correct[count])){
                    click();
                    buttonch3.setBackgroundDrawable(getResources().getDrawable(R.drawable.setcorrect));
                    countscore++;
                    countnext++;
                    scoreview();
                }else {
                    click();
                    buttonch3.setBackgroundDrawable(getResources().getDrawable(R.drawable.setwrong));
                }
                buttonch2.setEnabled(false);
                buttonch1.setEnabled(false);
            }
        });

    }

    void setButtonch2(){
        buttonch2=(Button) findViewById(R.id.btnchoose2);
        buttonch2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button=(Button) findViewById(R.id.btnnext);
                button.setEnabled(true);
                next=1;
                if( button2[count].equals(Correct[count])){
                    button=(Button) findViewById(R.id.btnnext);
                    button.setEnabled(true);
                    click();
                    buttonch2.setBackgroundDrawable(getResources().getDrawable(R.drawable.setcorrect));
                    countscore++;
                    countnext++;
                    scoreview();
                }else {
                    click();
                    buttonch2.setBackgroundDrawable(getResources().getDrawable(R.drawable.setwrong));
                }
                buttonch1.setEnabled(false);
                buttonch3.setEnabled(false);
            }
        });
    }

    void nextq(){
        button=(Button) findViewById(R.id.btnnext);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button=(Button) findViewById(R.id.btnnext);
                button.setEnabled(false);
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
                    quiz= (TextView)findViewById(R.id.Quiz);
                    quiz.setText(Quiz[count]);
                    buttonch1=(Button) findViewById(R.id.btnchoose1);
                    buttonch1.setText(button1[count]);
                    buttonch2=(Button) findViewById(R.id.btnchoose2);
                    buttonch2.setText(button2[count]);
                    buttonch3=(Button) findViewById(R.id.btnchoose3);
                    buttonch3.setText(button3[count]);
                }else {
                    click();
                }

            }
        });
    }
    void scoreview(){
        score= (TextView) findViewById(R.id.Score);
        String str=Integer.toString(countscore);
        score.setText(str);
    }
    void click(){
        click = MediaPlayer.create(Cplusplus.this,R.raw.btnclick);
        click.start();
    }
    void back (){
        button = (Button) findViewById(R.id.btnbackhome);
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


