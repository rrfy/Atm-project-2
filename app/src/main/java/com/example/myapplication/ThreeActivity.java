package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ThreeActivity extends AppCompatActivity {

    public static int id;
    public static String login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);

        Button logout = findViewById(R.id.Logout2);

        Bundle extras = getIntent().getExtras();

        if(extras != null){
            login = extras.getString("login");
        }




        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent main = new Intent(ThreeActivity.this, MainActivity.class);
                startActivity(main);
            }
        });
        Button Deposit = findViewById(R.id.Deposit);

        Deposit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Deposit = new Intent(ThreeActivity.this, Deposit.class);
                startActivity(Deposit);
            }
        });
        Button Changepin = findViewById(R.id.Changepin);

        Changepin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Changepin = new Intent(ThreeActivity.this, Changepin.class);
                startActivity(Changepin);
            }
        });
        Button Cashout = findViewById(R.id.Cashout);

        Cashout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Cashout = new Intent(ThreeActivity.this, Cashout.class);
                startActivity(Cashout);
            }
        });
        Button Balance = findViewById(R.id.Balance);

        Balance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Balance = new Intent(ThreeActivity.this, Balance.class);
                startActivity(Balance);
            }
        });



    }
}
