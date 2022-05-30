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

import java.io.IOException;
import java.util.ArrayList;
import java.util.SplittableRandom;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;



interface UserGet {
    @GET("/usermodel/getformlogin")
    Call<com.example.myapplication.UserDto> getOne(@Query("login") String login, @Query("password") String password);
}


public class MainActivity extends AppCompatActivity {
    Position position;


    private Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://192.168.72.252:8080")
            .addConverterFactory(GsonConverterFactory.create())
            .build();


    public class GetUsserbybalance extends AsyncTask<String, String, String> {

        @Override
        protected String doInBackground(String... strings) {

            com.example.myapplication.UserGet userget = retrofit.create(com.example.myapplication.UserGet.class);

            TextView loginView = findViewById(R.id.editTextTextPersonName4);
            TextView passwordView = findViewById(R.id.editTextTextPassword);


            String loginData    = loginView.getText().toString();
            String passwordData = passwordView.getText().toString();


            if (!loginData.equals("") && !passwordData.equals("")) {

                Call<UserDto> call = userget.getOne(loginData, passwordData);

                try {

                    Response<UserDto> response = call.execute();
                    UserDto result = response.body();

                    if (result != null){

                        Intent inten = new Intent(MainActivity.this, ThreeActivity.class);
                        inten.putExtra("id", result.id);
                        startActivity(inten);
                    } else {

                        Toast.makeText(com.example.myapplication.MainActivity.this, "Wrong password or login", Toast.LENGTH_SHORT);
                    }


                    runOnUiThread(() -> {

                    });


                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            }
            return null;
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button loginButton = findViewById(R.id.login1);
        position = new Position();


        loginButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {


                new GetUsserbybalance().execute("");
//                TextView loginView = findViewById(R.id.editTextTextPersonName4);
//                TextView passwordView = findViewById(R.id.editTextTextPassword);
//
//                loginView.getText().toString();
//
//                    String loginData = loginView.getText().toString();
//
//                    Log.d("smth", loginData);
//
//                    String passwordData = passwordView.getText().toString();
//                    position = new Position(1, loginData, passwordData, 0);
//
//                    if(!loginData.equals("")) {
//
//
//                        DbPositions dbPos = new DbPositions(MainActivity.this);
//                        Position pos = dbPos.getOne(loginData, passwordData);
//
//
//                        if (pos != null) {
//                            Intent inten = new Intent(MainActivity.this, ThreeActivity.class);
//
//                            inten.putExtra("login", loginData);
//                            startActivity(inten);
//
//                            Toast.makeText(getBaseContext(), "New Activity", Toast.LENGTH_SHORT).show();
//                        }
//                    }

            }
        });

        Button singButton = findViewById(R.id.Singup1);
        singButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent singup = new Intent(MainActivity.this, Singupmenu.class);
                startActivity(singup);

                Toast.makeText(getBaseContext(), "New Activity" , Toast.LENGTH_SHORT ).show();
            }
        });
    }
}
