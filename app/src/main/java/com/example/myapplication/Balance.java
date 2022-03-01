package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Balance extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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