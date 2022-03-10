package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Balance extends AppCompatActivity {
    Position position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView balance = findViewById(R.id.Balance2);
        DbPositions dbPos = new DbPositions(Balance.this);
        int newbalance = dbPos.getBal(position);
        balance.setText(newbalance);



        setContentView(R.layout.activity_balance);
        Button Goback = findViewById(R.id.Goback7);

        Goback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Balance = new Intent(Balance.this, Three.class);
                startActivity(Balance);
            }
        });


    }
}