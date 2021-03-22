package com.example.funmathv2;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SubtractionBasic extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subtraction_basic);

        TextView SubBasicFirstNumber = (TextView) findViewById(R.id.SubBasicFirstNumber);
        TextView SubBasicSecondNumber = (TextView) findViewById(R.id.SubBasicSecondNumber);

        int subBasicFirst;
        int subBasicSecond;

        if ((getIntent().hasExtra(("funMath.subBFirstNumber")) && (getIntent().hasExtra("funMath.subBSecondNumber")))) {
            subBasicFirst = getIntent().getExtras().getInt("funMath.subBFirstNumber"); // to be the same names in incorrect.class
            subBasicSecond = getIntent().getExtras().getInt("funMath.subBSecondNumber");
        } else {
            subBasicSecond = 1 + (int)(Math.random()*9);
            subBasicFirst = subBasicSecond + 1 + (int)(Math.random()*9);
        }

        SubBasicFirstNumber.setText(subBasicFirst + "");
        SubBasicSecondNumber.setText(subBasicSecond + "");

        int subBasicCorrectAnswer = subBasicFirst - subBasicSecond;

        EditText SubBasicAnswer = (EditText) findViewById(R.id.SubBasicAnswerEditText);
        SubBasicAnswer.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                String enteredString = SubBasicAnswer.getText().toString();
                if (enteredString.startsWith("0")){
                    if(enteredString.length() > 1){
                        SubBasicAnswer.setText(enteredString.substring(1));
                    } else {
                        SubBasicAnswer.setText("");
                    }
                }
            }
        });
        Button buttonSubtractionBasicCheck = (Button) findViewById(R.id.buttonSubtractionBasicCheck);
        buttonSubtractionBasicCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    int answer = Integer.parseInt(SubBasicAnswer.getText().toString());
                    if(answer == subBasicCorrectAnswer){
                        Intent startSubBasicCorrect = new Intent(getApplicationContext(), SubtractionBasicCorrect.class);
                        startActivity(startSubBasicCorrect);
                    } else {
                        Intent startSubBasicIncorrect = new Intent(getApplicationContext(), SubtractionBasicIncorrect.class);
                        startSubBasicIncorrect.putExtra("funMath.subBasicFirst", subBasicFirst);
                        startSubBasicIncorrect.putExtra("funMath.subBasicSecond", subBasicSecond);
                        startActivity(startSubBasicIncorrect);
                    }
                } catch (NumberFormatException ex){
                    Intent startSubBasicIncorrect = new Intent(getApplicationContext(), SubtractionBasicIncorrect.class);
                    startSubBasicIncorrect.putExtra("funMath.subBasicFirst", subBasicFirst);
                    startSubBasicIncorrect.putExtra("funMath.subBasicSecond", subBasicSecond);
                    startActivity(startSubBasicIncorrect);
                }
            }
        });
    }
}