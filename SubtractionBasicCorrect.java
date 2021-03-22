package com.example.funmathv2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SubtractionBasicCorrect extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subtraction_basic_correct);

        Button buttonSubtractionBasicBack = (Button) findViewById(R.id.buttonSubtractionBasicBack);
        buttonSubtractionBasicBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startMainActivity = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(startMainActivity);
            }
        });

        Button buttonSubtractionBasicAgain = (Button) findViewById(R.id.buttonSubtractionBasicAgain);
        buttonSubtractionBasicAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startSubtractionBasic = new Intent(getApplicationContext(), SubtractionBasic.class);
                    startActivity(startSubtractionBasic);
            }
        });
    }
}