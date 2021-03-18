package com.example.funmathv2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AdditionMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addition_menu);

        Button buttonAdditionBasic = (Button) findViewById(R.id.buttonAdditionBasic);
        buttonAdditionBasic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startAdditionBasic = new Intent(getApplicationContext(), AdditionBasic.class);
                startActivity(startAdditionBasic);
            }
        });
    }
}