package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Changepin extends AppCompatActivity {
    Position position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_changepin);
        Button Changepin = findViewById(R.id.Change);
        TextView newpin = findViewById(R.id.editTextTextPersonName);
        Changepin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newpin1 = newpin.getText().toString();
//                int newpin = Integer.parseInt(newpin1);
//                DbPositions dbPos = new DbPositions(Changepin.this);
                position.setPassword(newpin1);


            }
        });
        Button Goback = findViewById(R.id.Goback5);

        Goback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Goback = new Intent(Changepin.this, ThreeActivity.class);
                startActivity(Goback);
            }
        });
    }
}