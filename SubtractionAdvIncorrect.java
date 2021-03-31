package com.example.funmathv2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SubtractionAdvIncorrect extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subtraction_adv_incorrect);

        int subAdvFirst;
        int subAdvSecond;

        if ((getIntent().hasExtra(("funMath.subAdvFirst")) && (getIntent().hasExtra("funMath.subAdvSecond")))) {
            subAdvFirst = getIntent().getExtras().getInt("funMath.subAdvFirst"); // to be the same names in incorrect.class
            subAdvSecond = getIntent().getExtras().getInt("funMath.subAdvSecond");
        } else {
            subAdvFirst = 0;
            subAdvSecond = 0;
        }

        Button buttonSubtractionAdvTryAgain = (Button) findViewById(R.id.buttonSubtractionAdvTryAgain);
        buttonSubtractionAdvTryAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startSubtractionAdv = new Intent(getApplicationContext(), SubtractionAdv.class);
                startSubtractionAdv.putExtra("funMath.subAFirstNumber", subAdvFirst);
                startSubtractionAdv.putExtra("funMath.subASecondNumber", subAdvSecond);
                startActivity(startSubtractionAdv);
            }
        });

        Button buttonSubtractionAdvBack = (Button) findViewById(R.id.buttonSubtractionAdvBack);
        buttonSubtractionAdvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startMainActivity = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(startMainActivity);
            }
        });
    }
}