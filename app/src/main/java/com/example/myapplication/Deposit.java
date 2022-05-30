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

interface HttpServise {
    @FormUrlEncoded
    @POST("/usermodel/edit")
    Call<Boolean> edit(@Field("id") Integer id, @Field("password") String password, @Field("balance") Integer balance);

    @GET("/usermodel/getformindex")
    Call<com.example.myapplication.UserDto> getfromindex(@Query("id") Integer id);
}

public class Deposit extends AppCompatActivity {
    Position position;

    private Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://192.168.72.252:8080")
            .addConverterFactory(GsonConverterFactory.create())
            .build();



    public class Changebalance extends AsyncTask<String, String, String> {

        @Override
        protected String doInBackground(String... strings) {

            int id = ThreeActivity.id;

            com.example.myapplication.HttpServise httpServise1 = retrofit.create(com.example.myapplication.HttpServise.class);

            Call<UserDto> call1 = httpServise1.getfromindex(id);

            try {
                Response<UserDto> response = call1.execute();
                UserDto result1 = response.body();
                TextView balance = findViewById(R.id.editCash);
                String balancedata1 = balance.getText().toString();



                int balancedata = Integer.parseInt(balancedata1);
                balancedata = balancedata + result1.balance;
                String passwordq = result1.password;
                Call<Boolean> call2 = httpServise1.edit(id, passwordq, balancedata);

                try {
                    Response<Boolean> resp = call2.execute();
                    Boolean result = resp.body();

                    runOnUiThread(() -> {

                        Toast.makeText(com.example.myapplication.Deposit.this, "Edited", Toast.LENGTH_SHORT);
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deposit);

        Button Deposit = findViewById(R.id.Deposit1);
        TextView balance = findViewById(R.id.editCash);

        Deposit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                new Changebalance().execute("");
//                String balancedata1 = balance.getText().toString();
//                if (!balancedata1.equals("")) {
//                    int balancedata = Integer.parseInt(balancedata1);
//
//                    DbPositions dbPos = new DbPositions(Deposit.this);
//                    String login = ThreeActivity.login;
//
//                    MyDBhelper myDB = new MyDBhelper(Deposit.this);
//                    int newbalance = dbPos.getUserBalance(login);
//
//                    myDB.UpdateData(String.valueOf(login), newbalance + balancedata);
//                    Toast.makeText(getBaseContext(), "Success", Toast.LENGTH_SHORT).show();
//
//                } else {
//                    if (Integer.parseInt(balancedata1) <= 0) {
//                        Toast.makeText(getBaseContext(), "Error", Toast.LENGTH_SHORT).show();
//
//                    } else {
//
//                        Toast.makeText(getBaseContext(), "No Data", Toast.LENGTH_SHORT).show();
//                    }
//                }
            }
        });


        Button Goback4 = findViewById(R.id.Goback4);

        Goback4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent goback = new Intent(Deposit.this, ThreeActivity.class);
                startActivity(goback);

            }
        });
    }
}