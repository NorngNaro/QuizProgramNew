package com.example.quizprogram;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
 Button button  = null;
    MediaPlayer sound;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        help();
        Exit();
        start();

    }

    void start (){
        button = (Button) findViewById(R.id.btnStart);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this, Start.class);
                startActivity(intent);

            }
        });
    }
    void help (){
        button = (Button) findViewById(R.id.btnhelp);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this, Help.class);
                startActivity(intent);


            }
        });
    }
    void Exit (){
        button = (Button) findViewById(R.id.btnExit);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                close();
            }
        });

    }
    void close() {
        finish();
        System.exit(0);
    }


}

