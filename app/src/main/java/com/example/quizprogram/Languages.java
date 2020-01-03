package com.example.quizprogram;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Languages extends AppCompatActivity {
    Button buttonc;
    Button buttoncplus;
    Button buttonjava;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_languages);
        btnc();
        buttoncplus();
        buttonjava();
    }
    void btnc (){
        buttonc = findViewById(R.id.btnc);
        buttonc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Languages.this, Start.class);
                startActivity(intent);

            }
        });
    }
    void buttoncplus (){
        buttoncplus = findViewById(R.id.btncplus);
        buttoncplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Languages.this, Cplusplus.class);
                startActivity(intent);
            }
        });
    }
    void buttonjava (){
        buttonjava = findViewById(R.id.btnjava);
        buttonjava.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Languages.this, Java.class);
                startActivity(intent);
            }

        });

    }
}
