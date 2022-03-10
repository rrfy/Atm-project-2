package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Deposit extends AppCompatActivity {
    Position position;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deposit);

        Button Deposit = findViewById(R.id.Deposit1);
        TextView balance = findViewById(R.id.editCash);

        Deposit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String balancedata1 = balance.getText().toString();
                int balancedata = Integer.parseInt(balancedata1);
                DbPositions dbPos = new DbPositions(Deposit.this);
                dbPos.editOne(position, balancedata * -1);
            }
        });

        Button Goback4 = findViewById(R.id.Goback4);

        Goback4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goback = new Intent(Deposit.this, Three.class);
                startActivity(goback);
            }
        });
    }
}