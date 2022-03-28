package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Debug;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    Position position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button loginButton = findViewById(R.id.login1);
        position = new Position();


        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView loginView = findViewById(R.id.editTextTextPersonName4);
                TextView passwordView = findViewById(R.id.editTextTextPassword);
                loginView.getText().toString();

                String loginData    = loginView.getText().toString();
                String passwordData = passwordView.getText().toString();
                position = new Position(1, loginData, passwordData, 0);

                DbPositions dbPos = new DbPositions(MainActivity.this);
                Position pos = dbPos.getOne(loginData, passwordData);



                if (pos != null) {
                    Intent inten = new Intent(MainActivity.this, ThreeActivity.class);
                    Log.d("login", loginData);
                    inten.putExtra("login", loginData);
                    startActivity(inten);
                }
            }
        });

        Button singButton = findViewById(R.id.Singup1);
        singButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent singup = new Intent(MainActivity.this, Singupmenu.class);
                startActivity(singup);
            }
        });
    }
}
