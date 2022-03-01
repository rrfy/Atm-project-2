package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
//import androidx.room.Database;
//import androidx.room.Room;
//import androidx.room.RoomDatabase;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        AppDataBase db = Room.databaseBuilder(getApplicationContext(), AppDataBase.class, "user_db").fallbackToDestructiveMigration().build();

        BlankFragment fragment = new BlankFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.BlankFragmentWrap, fragment).commit();

        Button loginButton = findViewById(R.id.login1);

//        AsyncTask.execute(() -> {
//            User u = new User(1234, 0000, 322);
//            UserDao userDao = db.userdao();
//
//            userDao.save(u);
//            userDao.save(u);
//            userDao.save(u);
//            userDao.save(u);
//            userDao.save(u);
//            userDao.save(u);
//
//            System.out.println("Smth here?");
//        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView loginView = findViewById(R.id.loginView);
                TextView passwordView = findViewById(R.id.PasswordView);
                loginView.getText().toString();

                String loginData    = loginView.getText().toString();
                String passwordData = passwordView.getText().toString();

                Toast.makeText(MainActivity.this, "Login was undefined", Toast.LENGTH_SHORT);


                if(passwordData.equals("123")){
                    Intent intent = new Intent(MainActivity.this, Three.class);
                    startActivity(intent);
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