package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Singupmenu extends AppCompatActivity {

    EditText loginView, PasswordView;
    Button Singup3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singupmenu);
        TextView loginView = findViewById(R.id.editTextTextPersonName5);
        TextView passwordView = findViewById(R.id.editTextTextPassword2);
        Button singButton = findViewById(R.id.Singup3);

        singButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                MyDBhelper myDB = new MyDBhelper(Singupmenu.this);
                myDB.addUser(loginView.getText().toString().trim() ,
                        PasswordView.getText().toString().trim(),
                        0);

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