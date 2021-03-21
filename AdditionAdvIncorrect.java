package com.example.funmathv2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AdditionAdvIncorrect extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addition_adv_incorrect);

        int addAdvFirst;
        int addAdvSecond;

        if ((getIntent().hasExtra(("funMath.addAdvFirst")) && (getIntent().hasExtra("funMath.addAdvSecond")))) {
            addAdvFirst = getIntent().getExtras().getInt("funMath.addAdvFirst"); // to be the same names in incorrect.class
            addAdvSecond = getIntent().getExtras().getInt("funMath.addAdvSecond");
        } else {
            addAdvFirst = 0;
            addAdvSecond = 0;
        }

        Button buttonAdditionAdvTryAgain = (Button) findViewById(R.id.buttonAdditionAdvTryAgain);
        buttonAdditionAdvTryAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startAdditionAdv = new Intent(getApplicationContext(), AdditionAdv.class);
                startAdditionAdv.putExtra("funMath.addAFirstNumber", addAdvFirst);
                startAdditionAdv.putExtra("funMath.addASecondNumber", addAdvSecond);
                startActivity(startAdditionAdv);
            }
        });

        Button buttonAdditionAdvBack = (Button) findViewById(R.id.buttonAdditionAdvBack);
        buttonAdditionAdvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startMainActivity = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(startMainActivity);
            }
        });
    }
}