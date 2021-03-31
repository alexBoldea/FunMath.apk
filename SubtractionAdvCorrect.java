package com.example.funmathv2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SubtractionAdvCorrect extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subtraction_adv_correct);

        Button buttonSubtractionAdvBack = (Button) findViewById(R.id.buttonSubtractionAdvBack);
        buttonSubtractionAdvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startMainActivity = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(startMainActivity);
            }
        });

        Button buttonSubtractionAdvAgain = (Button) findViewById(R.id.buttonSubtractionAdvAgain);
        buttonSubtractionAdvAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startSubtractionAdv = new Intent(getApplicationContext(), SubtractionAdv.class);
                startActivity(startSubtractionAdv);
            }
        });
    }
}