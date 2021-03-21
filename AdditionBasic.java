package com.example.funmathv2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AdditionBasic extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addition_basic);

        TextView AddBasicFirstNumber = (TextView) findViewById(R.id.AddBasicFirstNumber);
        TextView AddBasicSecondNumber = (TextView) findViewById(R.id.AddBasicSecondNumber);

        int addBasicFirst;
        int addBasicSecond;

        if ((getIntent().hasExtra(("funMath.addBFirstNumber")) && (getIntent().hasExtra("funMath.addBSecondNumber")))) {
            addBasicFirst = getIntent().getExtras().getInt("funMath.addBFirstNumber"); // to be the same names in incorrect.class
            addBasicSecond = getIntent().getExtras().getInt("funMath.addBSecondNumber");
        } else {
            addBasicFirst = 1 + (int)(Math.random()*9);
            addBasicSecond = 1 + (int)(Math.random()*9);
        }

        AddBasicFirstNumber.setText(addBasicFirst + "");
        AddBasicSecondNumber.setText(addBasicSecond + "");

        int addBasicCorrectAnswer = addBasicFirst + addBasicSecond;

        EditText AddBasicAnswer = (EditText) findViewById(R.id.AddBasicAnswerEditText);
        AddBasicAnswer.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                String enteredString = AddBasicAnswer.getText().toString();
                if (enteredString.startsWith("0")){
                    if(enteredString.length() > 0){
                        AddBasicAnswer.setText(enteredString.substring(1));
                    } else {
                        AddBasicAnswer.setText("");
                    }
                }
            }
        });

        Button buttonAdditionBasicCheck = (Button) findViewById(R.id.buttonAdditionBasicCheck);
        buttonAdditionBasicCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    int answer = Integer.parseInt(AddBasicAnswer.getText().toString());
                    if(answer == addBasicCorrectAnswer){
                        Intent startAddBasicCorrect = new Intent(getApplicationContext(), AdditionBasicCorrect.class);
                        startActivity(startAddBasicCorrect);
                    } else {
                        Intent startAddBasicIncorrect = new Intent(getApplicationContext(), AdditionBasicIncorrect.class);
                        startAddBasicIncorrect.putExtra("funMath.addBasicFirst", addBasicFirst);
                        startAddBasicIncorrect.putExtra("funMath.addBasicSecond", addBasicSecond);
                        startActivity(startAddBasicIncorrect);
                    }
                } catch (NumberFormatException ex){
                    Intent startAddBasicIncorrect = new Intent(getApplicationContext(), AdditionBasicIncorrect.class);
                    startAddBasicIncorrect.putExtra("funMath.addBasicFirst", addBasicFirst);
                    startAddBasicIncorrect.putExtra("funMath.addBasicSecond", addBasicSecond);
                    startActivity(startAddBasicIncorrect);
                }
            }
        });
    }
}
