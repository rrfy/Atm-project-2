package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Singupmenu extends AppCompatActivity {
    DbPositions positions;
    ArrayList<Position> users = new ArrayList<>();


    EditText loginView, PasswordView;
    Button Singup3;
    MyDBhelper myDB;
    ArrayList<String> user_id, user_login, user_password, user_balance;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singupmenu);

        try {
            positions = new DbPositions(Singupmenu.this);
        } catch (Exception e) {
            e.printStackTrace();
        }

        TextView loginView = findViewById(R.id.editTextTextPersonName5);
        TextView passwordView = findViewById(R.id.editTextTextPassword2);
        Button singButton = findViewById(R.id.Singup3);

        singButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                loginView.getText().toString();

                String loginData    = loginView.getText().toString();
                String passwordData = passwordView.getText().toString();

                positions = DbPositions.getOne(loginData, passwordData);

                if (positions != positions) {
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