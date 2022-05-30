package com.example.myapplication;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

interface UserSave {
    @FormUrlEncoded
    @POST("usermodel/save")
    Call<Boolean> save(@Field("login") String login, @Field("password") String password);
}

public class Singupmenu extends AppCompatActivity {


    private Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://192.168.72.252:8080")
            .addConverterFactory(GsonConverterFactory.create())
            .build();


    public class SaveUser extends AsyncTask<String, String, String> {

        @Override
        protected String doInBackground(String... strings) {

            com.example.myapplication.UserSave userService = retrofit.create(com.example.myapplication.UserSave.class);

            TextView loginView = findViewById(R.id.editTextTextPersonName5);
            TextView passwordView = findViewById(R.id.editTextTextPassword2);


            String loginData    = loginView.getText().toString();
            String passwordData = passwordView.getText().toString();


            if (!loginData.equals("") && !passwordData.equals("")) {

                Call<Boolean> call = userService.save(loginData, passwordData);

                try {
                    Response<Boolean> response = call.execute();
                    Boolean result = response.body();

                    runOnUiThread(() -> {

                        Toast.makeText(com.example.myapplication.Singupmenu.this, "New user has saved", Toast.LENGTH_SHORT);
                    });

                    Intent intent = new Intent(Singupmenu.this, MainActivity.class);
                    startActivity(intent);


                } catch (IOException e) {
                    e.printStackTrace();
                }
                Intent intent = new Intent(Singupmenu.this, MainActivity.class);
                startActivity(intent);

                return null;
            } else {
                Intent intent = new Intent(Singupmenu.this, MainActivity.class);
                startActivity(intent);

                Toast.makeText(com.example.myapplication.Singupmenu.this, "Error", Toast.LENGTH_SHORT);

                return null;
            }

        }

    }

//    public class GetUserReq extends AsyncTask<String, String, String> {
//
//        @Override
//        protected String doInBackground(String... strings) {
//
//            com.example.myapplication.UserService userService = retrofit.create(com.example.myapplication.UserService.class);
//
//            Call<com.example.myapplication.User> call = userService.getOne(1);
//
//            try {
//                Response<com.example.myapplication.User> response = call.execute();
//                com.example.myapplication.User user = response.body();
//
//                runOnUiThread(() -> {
//                    TextView textView = findViewById(R.id.editTextTextPersonName5);
//
//                    textView.setText(user.login);
//                });
//
//                Log.d("user", user.login);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//            return null;
//        }
//    }

    DbPositions positions;

    Position position;

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




        Button singButton = findViewById(R.id.Singup3);

        singButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                new com.example.myapplication.Singupmenu.SaveUser().execute("");
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