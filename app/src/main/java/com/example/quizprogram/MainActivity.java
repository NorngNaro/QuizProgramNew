package com.example.quizprogram;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.concurrent.TimeUnit;




public class MainActivity extends AppCompatActivity {
 Button buttonstart;
 Button buttonhelp;
 MediaPlayer click;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        help();
        start();


    }

    void start (){
        buttonstart = findViewById(R.id.btnStart);
        buttonstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click();
                Intent intent= new Intent(MainActivity.this, Languages.class);
                startActivity(intent);
            }
        });
    }
    void help (){
        buttonhelp = findViewById(R.id.btnhelp);
        buttonhelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click();
                Intent intent= new Intent(MainActivity.this, Help.class);
                startActivity(intent);

            }
        });
    }

    void close() {
        finish();
        System.exit(0);
    }
    void click() {
        click = MediaPlayer.create(MainActivity.this, R.raw.keyboard_tap);
        click.start();
    }

}

