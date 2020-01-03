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
    Button buttonanswer;
    TextView score;
    TextView quiz;
    TextView finishT;
    TextView scoretext;
    TextView congrate;
    TextView time;
    TextView textanswer;
    MediaPlayer click;
    CountDownTimer countDownTimer;
    Random random = new Random();
    int count = random.nextInt(14);
    int countscore = 0;
    double countnext = 1;
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
        quiz.setText(Quiz[count]);
        buttonch1 = findViewById(R.id.btnchoose1);
        buttonch1.setText(button1[count]);
        buttonch2 = findViewById(R.id.btnchoose2);
        buttonch2.setText(button2[count]);
        buttonch3 = findViewById(R.id.btnchoose3);
        buttonch3.setText(button3[count]);
    }
    int countButton = 0;
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
                    click();
                    buttonch1.setBackgroundDrawable(getResources().getDrawable(R.drawable.setcorrect));
                    countnext++;
                    if(countButton == 0)
                        scoreview();
                } else {
                    click();
                    buttonch1.setBackgroundDrawable(getResources().getDrawable(R.drawable.setwrong));
                    //showanswer();
                   // textanswer = (TextView) findViewById(R.id.Answer);
                    //textanswer.setText( Correct[count]);
                }

                //user can't chose this button again, after click button1.
                buttonch2.setEnabled(false);
                buttonch3.setEnabled(false);

                if (button2[count].equals(Correct[count])){
                    buttonch2.setBackgroundDrawable(getResources().getDrawable(R.drawable.setcorrect));
                }else if(button3[count].equals(Correct[count])){
                    buttonch3.setBackgroundDrawable(getResources().getDrawable(R.drawable.setcorrect));
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
                    click();
                    buttonch2.setBackgroundDrawable(getResources().getDrawable(R.drawable.setcorrect));
                   // countscore++;
                    countnext++;
                    if(countButton == 0)
                        scoreview();
                } else {
                    click();
                    buttonch2.setBackgroundDrawable(getResources().getDrawable(R.drawable.setwrong));
                    // showanswer();
                    // textanswer = (TextView) findViewById(R.id.Answer);
                    //textanswer.setText( Correct[count]);
                }
                buttonch3.setEnabled(false);
                buttonch1.setEnabled(false);

                if (button3[count].equals(Correct[count])){
                    buttonch3.setBackgroundDrawable(getResources().getDrawable(R.drawable.setcorrect));
                }else if(button1[count].equals(Correct[count])){
                    buttonch1.setBackgroundDrawable(getResources().getDrawable(R.drawable.setcorrect));
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
                    click();
                    buttonch3.setBackgroundDrawable(getResources().getDrawable(R.drawable.setcorrect));
                    countnext++;
                    if(countButton == 0) // count only one time for our score.
                        scoreview();
                } else {
                    click();
                    buttonch3.setBackgroundDrawable(getResources().getDrawable(R.drawable.setwrong));
                   // showanswer();
                   // textanswer = (TextView) findViewById(R.id.Answer);
                    //textanswer.setText( Correct[count]);
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

    void nextq() {
        button = findViewById(R.id.btnnext);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button = findViewById(R.id.btnnext);
                button.setEnabled(false);

                buttonch1 = findViewById(R.id.btnchoose1);
                buttonch1.setEnabled(true);
                buttonch2 = findViewById(R.id.btnchoose2);
                buttonch2.setEnabled(true);
                buttonch3 = findViewById(R.id.btnchoose3);
                buttonch3.setEnabled(true);

                countDownTimer.start();
                if (next == 1) {
                    click();
                    next = 0;
                    buttonch1.setBackgroundDrawable(getResources().getDrawable(R.drawable.question));
                    buttonch2.setBackgroundDrawable(getResources().getDrawable(R.drawable.question));
                    buttonch3.setBackgroundDrawable(getResources().getDrawable(R.drawable.question));
                    count = random.nextInt(14);
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
                String str = Integer.toString(countscore);
                finishT.setText("  Your score \n\n " + str);
                buttonbackhome = findViewById(R.id.btnbackhome);
                buttonbackhome.setVisibility(View.VISIBLE);

                // set visible time
                time.setVisibility(View.INVISIBLE);
            }
        });
    }

    void scoreview() {
        score = findViewById(R.id.Score);
       // String str = Integer.toString(countscore);
        int temp;
        temp = countscore + 1;
        score.setText(String.valueOf(temp));
    }

    void click() {
        click = MediaPlayer.create(Start.this, R.raw.btnclick);
        click.start();
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
            }
        }.start();
    }

}
