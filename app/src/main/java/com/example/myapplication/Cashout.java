package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Cashout extends AppCompatActivity {
    Position position;
    DbPositions dbPositions;
//    MyDBhelper dBhelper = new MyDBhelper();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cashout);
        Button Goback = findViewById(R.id.Goback6);
        dbPositions = new DbPositions(this);

        Goback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Goback = new Intent(Cashout.this, ThreeActivity.class);
                startActivity(Goback);
            }
        });

        TextView balance = findViewById(R.id.Cashout2);
        Button Cashout = findViewById(R.id.Cashout3);

        Cashout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String balancedata1 = balance.getText().toString();
                int balancedata = Integer.parseInt(balancedata1);
                DbPositions dbPos = new DbPositions(Cashout.this);
                String login = ThreeActivity.login;

                MyDBhelper myDB = new MyDBhelper(Cashout.this);
                int newbalance = dbPos.getUserBalance(login);
                myDB.UpdateData(String.valueOf(login), newbalance - balancedata);
            }
        });
    }
}