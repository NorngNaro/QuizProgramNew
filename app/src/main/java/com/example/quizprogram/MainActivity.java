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
 Button buttonexit;
 Button buttonhelp;
    Button buttonc;
    Button buttoncplus;
    Button buttonjava;
    Button buttonx;
    TextView style;
    TextView load;
    MediaPlayer sound;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        help();
        Exit();
        start();
        btnc();
        x();
        buttoncplus();
        buttonjava();

    }

    void start (){
        buttonstart = (Button) findViewById(R.id.btnStart);
        buttonstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonstart.setVisibility( View.INVISIBLE);
                buttonhelp = (Button) findViewById(R.id.btnhelp);
                buttonhelp.setVisibility( View.INVISIBLE);
                buttonexit =(Button) findViewById(R.id.btnExit);
                buttonexit.setVisibility( View.INVISIBLE);
                buttonc =(Button) findViewById(R.id.btnc);
                buttonc.setVisibility( View.VISIBLE);
                buttoncplus =(Button) findViewById(R.id.btncplus);
                buttoncplus.setVisibility( View.VISIBLE);
                buttonjava =(Button) findViewById(R.id.btnjava);
                buttonjava.setVisibility( View.VISIBLE);
                style = ( TextView) findViewById(R.id.textstyle);
                style.setVisibility( View.VISIBLE);
                buttonx=(Button) findViewById(R.id.btnx);
                buttonx.setVisibility(View.VISIBLE);
            }
        });
    }
    void help (){
        buttonhelp = (Button) findViewById(R.id.btnhelp);
        buttonhelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this, Help.class);
                startActivity(intent);


            }
        });
    }
    void btnc (){
        buttonc = (Button) findViewById(R.id.btnc);
        buttonc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loading();st();
                Intent intent= new Intent(MainActivity.this, Start.class);
                startActivity(intent);
                st();
            }
        });
    }
    void buttoncplus (){
        buttoncplus = (Button) findViewById(R.id.btncplus);
        buttoncplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this, Cplusplus.class);
                startActivity(intent);
                st();
            }
        });
    }
    void buttonjava (){
        buttonjava = (Button) findViewById(R.id.btnjava);
        buttonjava.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this, Java.class);
                startActivity(intent);
                st();
            }

        });

    }
    void Exit (){
        buttonexit = (Button) findViewById(R.id.btnExit);
        buttonexit.setOnClickListener(new View.OnClickListener() {
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
    void x(){
        buttonx = (Button) findViewById(R.id.btnx);
        buttonx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            st();
            }
        });
    }
    void st(){
        buttonstart = (Button) findViewById(R.id.btnStart);
        buttonstart.setVisibility( View.VISIBLE);
        buttonhelp = (Button) findViewById(R.id.btnhelp);
        buttonhelp.setVisibility( View.VISIBLE);
        buttonexit =(Button) findViewById(R.id.btnExit);
        buttonexit.setVisibility( View.VISIBLE);
        buttonc =(Button) findViewById(R.id.btnc);
        buttonc.setVisibility( View.INVISIBLE);
        buttoncplus =(Button) findViewById(R.id.btncplus);
        buttoncplus.setVisibility( View.INVISIBLE);
        buttonjava =(Button) findViewById(R.id.btnjava);
        buttonjava.setVisibility( View.INVISIBLE);
        style = ( TextView) findViewById(R.id.textstyle);
        style.setVisibility( View.INVISIBLE);
        buttonx=(Button) findViewById(R.id.btnx);
        buttonx.setVisibility(View.INVISIBLE);
        load = ( TextView) findViewById(R.id.loading);
        load.setVisibility(View.INVISIBLE);
    }
    void loading(){
       load = ( TextView) findViewById(R.id.loading);
       load.setVisibility(View.VISIBLE);
        buttonc =(Button) findViewById(R.id.btnc);
        buttonc.setVisibility( View.INVISIBLE);
        buttoncplus =(Button) findViewById(R.id.btncplus);
        buttoncplus.setVisibility( View.INVISIBLE);
        buttonjava =(Button) findViewById(R.id.btnjava);
        buttonjava.setVisibility( View.INVISIBLE);
        style = ( TextView) findViewById(R.id.textstyle);
        style.setVisibility( View.INVISIBLE);
        buttonx=(Button) findViewById(R.id.btnx);
        buttonx.setVisibility(View.INVISIBLE);
        buttonstart = (Button) findViewById(R.id.btnStart);
        buttonstart.setVisibility( View.INVISIBLE);
        buttonhelp = (Button) findViewById(R.id.btnhelp);
        buttonhelp.setVisibility( View.INVISIBLE);
        buttonexit =(Button) findViewById(R.id.btnExit);
        buttonexit.setVisibility( View.INVISIBLE);

    }


}

