package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

class UserDto{
    public int id;
    public String login;
    public String password;
    public int balance;
}

interface Getformindex {

    @GET("/usermodel/getformindex")
    Call<com.example.myapplication.UserDto> getfromindex(@Query("id") Integer id);
}



public class Balance extends AppCompatActivity {
    Position position;
    DbPositions dbPositions;

    private Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://192.168.72.252:8080")
            .addConverterFactory(GsonConverterFactory.create())
            .build();


    public class  RequestToServer extends AsyncTask<String, String, String> {

        @Override
        protected String doInBackground(String... strings) {

            Getformindex getformindex = retrofit.create(Getformindex.class);

            int id = ThreeActivity.id;
            Call<UserDto> call = getformindex.getfromindex(id);

            try {
                Response<UserDto> response = call.execute();
                UserDto userdto = response.body();

                TextView balance = findViewById(R.id.Balance2);

                runOnUiThread(() -> {
                    TextView textView = findViewById(R.id.Balance2);

                    balance.setText(Integer.toString(userdto.balance));

                });


            } catch (IOException e){
                e.printStackTrace();
            }


            return null;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_balance);

        Button Refresh = findViewById(R.id.refresh);


        Refresh.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                new RequestToServer().execute("");

//                TextView balance = findViewById(R.id.Balance2);
//                String login = ThreeActivity.login;
//
//                DbPositions dbPos = new DbPositions(Balance.this);
//                int newbalance = dbPos.getUserBalance(login);
//
//                if (newbalance != 0) {
//
//                    balance.setText(Integer.toString(newbalance));
//                } else {
//
//                    Toast.makeText(getBaseContext(), "No Data" , Toast.LENGTH_SHORT ).show();
//                }

            }
        });


        Button Goback = findViewById(R.id.Goback7);

        Goback.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent Balance = new Intent(Balance.this, ThreeActivity.class);
                startActivity(Balance);
            }
        });


    }
}