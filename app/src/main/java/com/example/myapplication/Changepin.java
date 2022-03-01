package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Changepin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_changepin);
        Button Changepin = findViewById(R.id.Change);
        Changepin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        Button Goback = findViewById(R.id.Goback5);

        Goback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Goback = new Intent(Changepin.this, Three.class);
                startActivity(Goback);
            }
        });
    }
}