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

public class AdditionAdv extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addition_adv);

        TextView AddAdvFirstNumber = (TextView) findViewById(R.id.AddAdvFirstNumber);
        TextView AddAdvSecondNumber = (TextView) findViewById(R.id.AddAdvSecondNumber);

        int addAdvFirst;
        int addAdvSecond;

        if ((getIntent().hasExtra(("funMath.addAFirstNumber")) && (getIntent().hasExtra("funMath.addASecondNumber")))) {
            addAdvFirst = getIntent().getExtras().getInt("funMath.addAFirstNumber"); // to be the same names in incorrect.class
            addAdvSecond = getIntent().getExtras().getInt("funMath.addASecondNumber");
        } else {
            addAdvFirst = 10 + (int)(Math.random()*90);
            addAdvSecond = 10 + (int)(Math.random()*90);
        }

        AddAdvFirstNumber.setText(addAdvFirst + "");
        AddAdvSecondNumber.setText(addAdvSecond + "");

        int addAdvCorrectAnswer = addAdvFirst + addAdvSecond;

        EditText AddAdvAnswer = (EditText) findViewById(R.id.AddAdvAnswerEditText);
        AddAdvAnswer.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                String enteredString = AddAdvAnswer.getText().toString();
                if (enteredString.startsWith("0")){
                    if(enteredString.length() > 0){
                        AddAdvAnswer.setText(enteredString.substring(1));
                    } else {
                        AddAdvAnswer.setText("");
                    }
                }
            }
        });

        Button buttonAdditionAdvCheck = (Button) findViewById(R.id.buttonAdditionAdvCheck);
        buttonAdditionAdvCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    int answer = Integer.parseInt(AddAdvAnswer.getText().toString());
                    if(answer == addAdvCorrectAnswer){
                        Intent startAddAdvCorrect = new Intent(getApplicationContext(), AdditionAdvCorrect.class);
                        startActivity(startAddAdvCorrect);
                    } else {
                        Intent startAddAdvIncorrect = new Intent(getApplicationContext(), AdditionAdvIncorrect.class);
                        startAddAdvIncorrect.putExtra("funMath.addAdvFirst", addAdvFirst);
                        startAddAdvIncorrect.putExtra("funMath.addAdvSecond", addAdvSecond);
                        startActivity(startAddAdvIncorrect);
                    }
                } catch (NumberFormatException ex){
                    Intent startAddAdvIncorrect = new Intent(getApplicationContext(), AdditionAdvIncorrect.class);
                    startAddAdvIncorrect.putExtra("funMath.addAdvFirst", addAdvFirst);
                    startAddAdvIncorrect.putExtra("funMath.addAdvSecond", addAdvSecond);
                    startActivity(startAddAdvIncorrect);
                }
            }
        });

    }
}