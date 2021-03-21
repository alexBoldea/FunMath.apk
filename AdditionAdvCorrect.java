package com.example.funmathv2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AdditionAdvCorrect extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addition_adv_correct);

        Button buttonAdditionAdvBack = (Button) findViewById(R.id.buttonAdditionAdvBack);
        buttonAdditionAdvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startMainActivity = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(startMainActivity);
            }
        });

        Button buttonAdditionAdvAgain = (Button) findViewById(R.id.buttonAdditionAdvAgain);
        buttonAdditionAdvAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startAdditionAdv = new Intent(getApplicationContext(), AdditionAdv.class);
                startActivity(startAdditionAdv);
            }
        });
    }
}