package com.example.quizprogram;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Help extends AppCompatActivity {
Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
        back();
    }
    public void back() {
        button = findViewById(R.id.btnhelpback);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backhelp();
            }
        });
    }
        void backhelp(){
            finish();
        }
}
