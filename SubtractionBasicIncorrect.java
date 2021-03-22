package com.example.funmathv2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SubtractionBasicIncorrect extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subtraction_basic_incorrect);

        int subBasicFirst;
        int subBasicSecond;

        if ((getIntent().hasExtra(("funMath.subBasicFirst")) && (getIntent().hasExtra("funMath.subBasicSecond")))) {
            subBasicFirst = getIntent().getExtras().getInt("funMath.subBasicFirst"); // to be the same names in incorrect.class
            subBasicSecond = getIntent().getExtras().getInt("funMath.subBasicSecond");
        } else {
            subBasicFirst = 0;
            subBasicSecond = 0;
        }

        Button buttonSubtractionBasicTryAgain = (Button) findViewById(R.id.buttonSubtractionBasicTryAgain);
        buttonSubtractionBasicTryAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startSubtractionBasic = new Intent(getApplicationContext(), SubtractionBasic.class);
                startSubtractionBasic.putExtra("funMath.subBFirstNumber", subBasicFirst);
                startSubtractionBasic.putExtra("funMath.subBSecondNumber", subBasicSecond);
                startActivity(startSubtractionBasic);
            }
        });

        Button buttonSubtractionBasicBack = (Button) findViewById(R.id.buttonSubtractionBasicBack);
        buttonSubtractionBasicBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startMainActivity = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(startMainActivity);
            }
        });
    }
}