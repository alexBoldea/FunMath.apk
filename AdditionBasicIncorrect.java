package com.example.funmathv2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AdditionBasicIncorrect extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addition_basic_incorrect);

        int addBasicFirst;
        int addBasicSecond;

        if ((getIntent().hasExtra(("funMath.addBasicFirst")) && (getIntent().hasExtra("funMath.addBasicSecond")))) {
            addBasicFirst = getIntent().getExtras().getInt("funMath.addBasicFirst"); // to be the same names in incorrect.class
            addBasicSecond = getIntent().getExtras().getInt("funMath.addBasicSecond");
        } else {
            addBasicFirst = 0;
            addBasicSecond = 0;
        }

        Button buttonAdditionBasicTryAgain = (Button) findViewById(R.id.buttonAdditionBasicTryAgain);
        buttonAdditionBasicTryAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startAdditionBasic = new Intent(getApplicationContext(), AdditionBasic.class);
                startAdditionBasic.putExtra("funMath.addBFirstNumber", addBasicFirst);
                startAdditionBasic.putExtra("funMath.addBSecondNumber", addBasicSecond);
                startActivity(startAdditionBasic);
            }
        });

        Button buttonAdditionBasicBack = (Button) findViewById(R.id.buttonAdditionBasicBack);
        buttonAdditionBasicBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startMainActivity = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(startMainActivity);
            }
        });
    }
}