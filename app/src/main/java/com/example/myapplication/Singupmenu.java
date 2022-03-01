package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Singupmenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singupmenu);

        BlankFragment fragment = new BlankFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.constraintLayout, fragment).commit();

        Button singButton = findViewById(R.id.Singup3);
        singButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView loginView = findViewById(R.id.loginView);
                TextView passwordView = findViewById(R.id.PasswordView);
                loginView.getText().toString();

                String loginData    = loginView.getText().toString();
                String passwordData = passwordView.getText().toString();

                if (!passwordData.equals("")) {
                    Intent intent = new Intent(Singupmenu.this, MainActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(Singupmenu.this, "Login or password was undefined", Toast.LENGTH_SHORT);
                }
            }
        });
        Button gobackButton = findViewById(R.id.Goback3);
        gobackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Singupmenu.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}