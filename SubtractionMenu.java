package com.example.funmathv2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SubtractionMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subtraction_menu);

        Button buttonSubtractionBasic = (Button) findViewById(R.id.buttonSubtractionBasic);
        buttonSubtractionBasic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startSubtractionBasic = new Intent(getApplicationContext(), SubtractionBasic.class);
                startActivity(startSubtractionBasic);
            }
        });
    }
}