package com.example.funmathv2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonAddition = (Button) findViewById(R.id.buttonAddition);
        buttonAddition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startAdditionMenu = new Intent(getApplicationContext(), AdditionMenu.class);
                startActivity(startAdditionMenu);
            }
        });

        Button buttonSubtraction = (Button) findViewById(R.id.buttonSubtraction);
        buttonSubtraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startSubtractionMenu = new Intent(getApplicationContext(), SubtractionMenu.class);
                startActivity(startSubtractionMenu);
            }
        });

        Button buttonMultiplication = (Button) findViewById(R.id.buttonMultiplication);
        buttonMultiplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startMultiplicationMenu = new Intent(getApplicationContext(), MultiplicationMenu.class);
                startActivity(startMultiplicationMenu);
            }
        });

        Button buttonDivision = (Button) findViewById(R.id.buttonDivision);
        buttonDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startDivisionMenu = new Intent(getApplicationContext(), DivisionMenu.class);
                startActivity(startDivisionMenu);
            }
        });

    }
}