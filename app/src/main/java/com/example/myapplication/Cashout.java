package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Cashout extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cashout);
        Button Goback = findViewById(R.id.Goback6);

        Goback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Goback = new Intent(Cashout.this, Three.class);
                startActivity(Goback);
            }
        });
        Button Cashout = findViewById(R.id.Cashout3);

        Cashout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}