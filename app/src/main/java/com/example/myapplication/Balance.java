package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Balance extends AppCompatActivity {
    Position position;
    DbPositions dbPositions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_balance);

        Button Refresh = findViewById(R.id.refresh);


        Refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView balance = findViewById(R.id.Balance2);
                String login = ThreeActivity.login;

                DbPositions dbPos = new DbPositions(Balance.this);
                int newbalance = dbPos.getUserBalance(login);


                balance.setText(Integer.toString(newbalance));
            }
        });



        Button Goback = findViewById(R.id.Goback7);


        Goback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Balance = new Intent(Balance.this, ThreeActivity.class);
                startActivity(Balance);
            }
        });


    }
}