package com.example.quizprogram;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.Random;

public class Start extends AppCompatActivity {
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
    TextView mark;
    TextView cross;
    TextView mark2;
    TextView cross2;
    TextView mark3;
    TextView cross3;
    TextView time;
    MediaPlayer click;
    MediaPlayer pass;
    MediaPlayer achievement;
    MediaPlayer wrong;
    CountDownTimer countDownTimer;
    Random random = new Random();
    int count = 1;
    int countscore = 0;
    int countnext = 1;
    int Wrong=0;
    int next;
    String[] Quiz = {"How many main () function we can have in our project?",
            "Which programming language is more faster among these?",
            "When C Language was invented?", " Can we declare function inside structure of C Programming?",
            " Decrement operator, −−, decreases the value of variable by what number? ",
            "Which right shift operator preserves the sign of the value?",
            "Which of these keywords is used to make a class?",
            "Which of the following is a valid declaration of an object of class Box?",
            "Which of these is an incorrect array declaration?",
            "What is the extension of java code files?",
            "Which component is used to compile, debug and execute java program?",
            "Which of these is an incorrect string literal?",
            "Who is known as the founder of C language?",
            "How would you insert pre-written code into a current program?",
            "In a C program, the first statement that will be executed is:"};

    String[] Correct = {" 1 ",
            " C ",
            " 1972 ",
            " No ",
            " 1 ",
            ">>",
            " class ",
            "Box obj = new Box();",
            "int arr[] = int [5] new",
            ".java", "JDK",
            "\"Hello\n" +
                    "\tworld\"",
            "Dennis Ritchie", "#include", "The first executable statement of the main() function"};


    String[] button1 = {" 1 ",
            " Java ",
            " 1970 ",
            " Yes ",
            " 1 ",
            " <<= ",
            "struct",
            "Box obj = new Box();",
            "int arr[] = new int[5]",
            ".txt", "JVM",
            "“Hello World”",
            "Martin Richard", "#include", "The first executable statement of the program."};

    String[] button2 = {" 2",
            " C ",
            " 1975 ",
            " No ",
            " 2 ",
            " << ",
            " class ",
            "obj = new Box();",
            "int [] arr = new int[5]",
            ".java", "JRE",
            "\"Hello\n" +
                    "\tworld\"",
            "James Gosling", "#get", "The first executable statement of the main() function"};

    String[] button3 = {" No limit",
            " PHP ",
            " 1972 ",
            " Depends on Compiler ",
            " 3 ", ">>",
            "none of the mentioned",
            "new Box obj;",
            "int arr[] = int [5] new",
            ".class", "JDK",
            "“Hello\\nWorld”",
            "Dennis Ritchie", ".#read", "The first executable statement after the comment /* start here*/"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        fini();
        nextq();
        // timer(max,min);
        setButtonch3();
        setButtonch1();
        setButtonch2();
        back();
        timer();
        button = findViewById(R.id.btnnext);
        button.setEnabled(false);

        score = findViewById(R.id.Score);
        score.setText("0");
        next = 0;
        quiz = findViewById(R.id.Quiz);
        quiz.setText(Quiz[count]); // Question table is visitable.
        buttonch1 = findViewById(R.id.btnchoose1);
        buttonch1.setText(button1[count]);
        buttonch2 = findViewById(R.id.btnchoose2);
        buttonch2.setText(button2[count]);
        buttonch3 = findViewById(R.id.btnchoose3);
        buttonch3.setText(button3[count]);
    }
   // int countButton = 0;
    void setButtonch1() {
        buttonch1 = findViewById(R.id.btnchoose1);
        buttonch1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button = findViewById(R.id.btnnext);
                button.setEnabled(true);
                next = 1;
                countDownTimer.cancel();
                if (button1[count].equals(Correct[count])) { // when this button is match use equal building in function.
                    pass();
                    mark= (TextView) findViewById(R.id.Mark);
                    mark.setVisibility(View.VISIBLE);
                    countscore++;
                    scoreview();
                } else {
                    wrong();
                    Wrong++;
                    cross= (TextView) findViewById(R.id.Cross);
                    cross.setVisibility(View.VISIBLE);
                }

                //user can't chose this button again, after click button1.
                buttonch1.setEnabled(false);
                buttonch2.setEnabled(false);
                buttonch3.setEnabled(false);

                if (button2[count].equals(Correct[count])){
                    mark2= (TextView) findViewById(R.id.Mark2);
                    mark2.setVisibility(View.VISIBLE);
                }else if(button3[count].equals(Correct[count])){
                    mark3= (TextView) findViewById(R.id.Mark3);
                    mark3.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    void setButtonch2() {
        buttonch2 = findViewById(R.id.btnchoose2);
        buttonch2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button = findViewById(R.id.btnnext);
                button.setEnabled(true);
                next = 1;
                countDownTimer.cancel();
                if (button2[count].equals(Correct[count])) {
                    button = findViewById(R.id.btnnext);
                    button.setEnabled(true);
                    pass();
                    mark2= (TextView) findViewById(R.id.Mark2);
                    mark2.setVisibility(View.VISIBLE);
                    countscore++;
                    scoreview();
                } else {
                    wrong();
                    Wrong++;
                    cross2= (TextView) findViewById(R.id.Cross2);
                    cross2.setVisibility(View.VISIBLE);
                }
                buttonch3.setEnabled(false);
                buttonch2.setEnabled(false);
                buttonch1.setEnabled(false);

                if (button3[count].equals(Correct[count])){
                    mark3= (TextView) findViewById(R.id.Mark3);
                    mark3.setVisibility(View.VISIBLE);
                }else if(button1[count].equals(Correct[count])){
                    mark= (TextView) findViewById(R.id.Mark);
                    mark.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    void setButtonch3() {
        buttonch3 = findViewById(R.id.btnchoose3);
        buttonch3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button = findViewById(R.id.btnnext);
                button.setEnabled(true);
                next = 1;
                countDownTimer.cancel();
                if (button3[count].equals(Correct[count])) {
                    pass();
                    mark3= (TextView) findViewById(R.id.Mark3);
                    mark3.setVisibility(View.VISIBLE);
                    countscore++;
                    scoreview();
                   /* if(countButton == 0) // count only one time for our score.
                        scoreview();*/
                } else {
                    wrong();
                    Wrong++;
                    cross3= (TextView) findViewById(R.id.Cross3);
                    cross3.setVisibility(View.VISIBLE);
                }
                buttonch2.setEnabled(false);
                buttonch1.setEnabled(false);
                buttonch3.setEnabled(false);

                if (button2[count].equals(Correct[count])){
                    mark2= (TextView) findViewById(R.id.Mark2);
                    mark2.setVisibility(View.VISIBLE);
                }else if(button1[count].equals(Correct[count])){
                    mark= (TextView) findViewById(R.id.Mark);
                    mark.setVisibility(View.VISIBLE);
                }
            }
        });

    }

    void nextq() {
        button = findViewById(R.id.btnnext);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click();
                countnext++;
                count++;
                button = findViewById(R.id.btnnext);
                button.setEnabled(false);
                buttonch1 = findViewById(R.id.btnchoose1);
                buttonch1.setEnabled(true);
                buttonch2 = findViewById(R.id.btnchoose2);
                buttonch2.setEnabled(true);
                buttonch3 = findViewById(R.id.btnchoose3);
                buttonch3.setEnabled(true);
                cross= (TextView) findViewById(R.id.Cross);
                cross.setVisibility(View.INVISIBLE);
                mark= (TextView) findViewById(R.id.Mark);
                mark.setVisibility(View.INVISIBLE);
                cross2= (TextView) findViewById(R.id.Cross2);
                cross2.setVisibility(View.INVISIBLE);
                mark2= (TextView) findViewById(R.id.Mark2);
                mark2.setVisibility(View.INVISIBLE);
                cross3= (TextView) findViewById(R.id.Cross3);
                cross3.setVisibility(View.INVISIBLE);
                mark3= (TextView) findViewById(R.id.Mark3);
                mark3.setVisibility(View.INVISIBLE);

                countDownTimer.start();
                if (next == 1) {
                        click();
                        next = 0;
                        buttonch1.setBackgroundDrawable(getResources().getDrawable(R.drawable.question));
                        buttonch2.setBackgroundDrawable(getResources().getDrawable(R.drawable.question));
                        buttonch3.setBackgroundDrawable(getResources().getDrawable(R.drawable.question));
                       // count = random.nextInt(14);
                        buttonch1.setEnabled(true);
                        buttonch2.setEnabled(true);
                        buttonch3.setEnabled(true);
                        quiz = findViewById(R.id.Quiz);
                        quiz.setText(Quiz[count]);
                        buttonch1 = findViewById(R.id.btnchoose1);
                        buttonch1.setText(button1[count]);
                        buttonch2 = findViewById(R.id.btnchoose2);
                        buttonch2.setText(button2[count]);
                        buttonch3 = findViewById(R.id.btnchoose3);
                        buttonch3.setText(button3[count]);

                } else {
                    click();
                }
            }
        });
    }

    void fini() {
        buttonfi = findViewById(R.id.btnFinishC);
        buttonfi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click();
                if(next==1){
                    achievement();
                finishT = findViewById(R.id.finish);
                finishT.setVisibility(View.VISIBLE);
                buttonch1.setVisibility(View.INVISIBLE);
                buttonch2.setVisibility(View.INVISIBLE);
                buttonch3.setVisibility(View.INVISIBLE);
                quiz.setVisibility(View.INVISIBLE);
                buttonfi.setVisibility(View.INVISIBLE);
                button = findViewById(R.id.btnnext);
                button.setVisibility(View.INVISIBLE);
                score.setVisibility(View.INVISIBLE);
                scoretext = findViewById(R.id.scoretext);
                scoretext.setVisibility(View.INVISIBLE);
                congrate = findViewById(R.id.congrate);
                congrate.setVisibility(View.VISIBLE);
                String strscore = Integer.toString(countscore);
                String strnext = Integer.toString(countnext);
                String strwrong = Integer.toString(Wrong);
                finishT.setText("Total Question: "+strnext +"\n Correct:  " + strscore+"\n Wrong: "+strwrong);
                buttonbackhome = findViewById(R.id.btnbackhome);
                buttonbackhome.setVisibility(View.VISIBLE);
                // set visible time
                time.setVisibility(View.INVISIBLE);
                mark= (TextView) findViewById(R.id.Mark);
                mark.setVisibility(View.INVISIBLE);
                mark2= (TextView) findViewById(R.id.Mark2);
                mark2.setVisibility(View.INVISIBLE);
                mark3= (TextView) findViewById(R.id.Mark3);
                mark3.setVisibility(View.INVISIBLE);
                cross = (TextView) findViewById(R.id.Cross);
                cross.setVisibility(View.INVISIBLE);
                cross2= (TextView) findViewById(R.id.Cross2);
                cross2.setVisibility(View.INVISIBLE);
                cross3= (TextView) findViewById(R.id.Cross3);
                cross3.setVisibility(View.INVISIBLE);
                }

            }
        });
    }

    void scoreview() {
        score = findViewById(R.id.Score);
        String str = Integer.toString(countscore);
        score.setText(String.valueOf(str));
    }

    void click() {
        click = MediaPlayer.create(Start.this, R.raw.keyboard_tap);
        click.start();
    }
    void pass(){
        pass = MediaPlayer.create(Start.this, R.raw.correct);
        pass.start();
    }
    void wrong(){
        wrong = MediaPlayer.create(Start.this,R.raw.wrong_multi_choice);
        wrong.start();
    }
    void achievement(){
        wrong = MediaPlayer.create(Start.this,R.raw.achievement);
        wrong.start();
    }

    void back() {
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
                Wrong++;
            }
        }.start();
    }

}
