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

public class Cashout extends AppCompatActivity {

    Position position;
    DbPositions dbPositions;

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
                TextView balance = findViewById(R.id.Cashout2);
                String balancedata1 = balance.getText().toString();



                int balancedata = Integer.parseInt(balancedata1);

                balancedata = result1.balance - balancedata;
                String passwordq = result1.password;
                Call<Boolean> call2 = httpServise1.edit(id, passwordq, balancedata);

                try {
                    Response<Boolean> resp = call2.execute();
                    Boolean result = resp.body();
                    runOnUiThread(() -> {

                        Toast.makeText(com.example.myapplication.Cashout.this, "Edited", Toast.LENGTH_SHORT);

                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }  catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cashout);

        Button Goback = findViewById(R.id.Goback6);
        dbPositions = new DbPositions(this);

        Goback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Goback = new Intent(Cashout.this, ThreeActivity.class);
                startActivity(Goback);
            }
        });

        TextView balance = findViewById(R.id.Cashout2);
        Button Cashout = findViewById(R.id.Cashout3);

        Cashout.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                new Changebalance().execute("");
//                String balancedata1 = balance.getText().toString();
//
//                if (!balancedata1.equals("")) {
//                    int balancedata = Integer.parseInt(balancedata1);
//
//                    DbPositions dbPos = new DbPositions(Cashout.this);
//                    String login = ThreeActivity.login;
//
//                    MyDBhelper myDB = new MyDBhelper(Cashout.this);
//                    int newbalance = dbPos.getUserBalance(login);
//                    myDB.UpdateData(String.valueOf(login), newbalance - balancedata);
//
//                    Toast.makeText(getBaseContext(), "Success" , Toast.LENGTH_SHORT ).show();
//                } else {
//
//                    if (Integer.parseInt(balancedata1) <= 0) {
//                        Toast.makeText(getBaseContext(), "Error", Toast.LENGTH_SHORT).show();
//                    } else {
//                        Toast.makeText(getBaseContext(), "No Data", Toast.LENGTH_SHORT).show();
//                    }
//                }
//

            }
        });
    }
}