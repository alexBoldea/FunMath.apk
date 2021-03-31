package com.example.funmathv2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SubtractionAdv extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subtraction_adv);

        TextView SubAdvFirstNumber = (TextView) findViewById(R.id.SubAdvFirstNumber);
        TextView SubAdvSecondNumber = (TextView) findViewById(R.id.SubAdvSecondNumber);

        int subAdvFirst;
        int subAdvSecond;

        if ((getIntent().hasExtra(("funMath.subAFirstNumber")) && (getIntent().hasExtra("funMath.subASecondNumber")))) {
            subAdvFirst = getIntent().getExtras().getInt("funMath.subAFirstNumber"); // to be the same names in incorrect.class
            subAdvSecond = getIntent().getExtras().getInt("funMath.subASecondNumber");
        } else {
            subAdvSecond = (int)(Math.random()*90);
            subAdvFirst = subAdvSecond + (int)(Math.random()*90);
        }

        SubAdvFirstNumber.setText(subAdvFirst + "");
        SubAdvSecondNumber.setText(subAdvSecond + "");

        int subAdvCorrectAnswer = subAdvFirst - subAdvSecond;

        EditText SubAdvAnswer = (EditText) findViewById(R.id.SubAdvAnswerEditText);
        SubAdvAnswer.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                String enteredString = SubAdvAnswer.getText().toString();
                if (enteredString.startsWith("0")){
                    if(enteredString.length() > 1){
                        SubAdvAnswer.setText(enteredString.substring(1));
                    }
                }
            }
        });

        Button buttonSubtractionAdvCheck = (Button) findViewById(R.id.buttonSubtractionAdvCheck);
        buttonSubtractionAdvCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    int answer = Integer.parseInt(SubAdvAnswer.getText().toString());
                    if(answer == subAdvCorrectAnswer){
                        Intent startSubAdvCorrect = new Intent(getApplicationContext(), SubtractionAdvCorrect.class);
                        startActivity(startSubAdvCorrect);
                    } else {
                        Intent startSubAdvIncorrect = new Intent(getApplicationContext(), SubtractionAdvIncorrect.class);
                        startSubAdvIncorrect.putExtra("funMath.subAdvFirst", subAdvFirst);
                        startSubAdvIncorrect.putExtra("funMath.subAdvSecond", subAdvSecond);
                        startActivity(startSubAdvIncorrect);
                    }
                } catch (NumberFormatException ex){
                    Intent startSubAdvIncorrect = new Intent(getApplicationContext(), SubtractionAdvIncorrect.class);
                    startSubAdvIncorrect.putExtra("funMath.subAdvFirst", subAdvFirst);
                    startSubAdvIncorrect.putExtra("funMath.subAdvSecond", subAdvSecond);
                    startActivity(startSubAdvIncorrect);
                }
            }
        });
    }
}