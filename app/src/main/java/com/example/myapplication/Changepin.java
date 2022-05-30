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


public class Changepin extends AppCompatActivity {

    private Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://192.168.72.252:8080")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public class Changepinserver extends AsyncTask<String, String, String> {

        @Override
        protected String doInBackground(String... strings) {

            int id = ThreeActivity.id;

            com.example.myapplication.HttpServise httpServise1 = retrofit.create(com.example.myapplication.HttpServise.class);

            Call<UserDto> call1 = httpServise1.getfromindex(id);

            try {
                Response<UserDto> response = call1.execute();
                UserDto result1 = response.body();
                if (!(result1.login.equals(""))){
                TextView password = findViewById(R.id.editTextTextPersonName);
                String passworddata1 = password.getText().toString();


                int balancedata = result1.balance;
                Call<Boolean> call2 = httpServise1.edit(id, passworddata1, balancedata);

                try {
                    Response<Boolean> resp = call2.execute();
                    Boolean result = resp.body();

                    runOnUiThread(() -> {

                        Toast.makeText(com.example.myapplication.Changepin.this, "Edited", Toast.LENGTH_SHORT);
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }

            } }catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_changepin);

        Button Changepin = findViewById(R.id.Change);
        TextView newpin = findViewById(R.id.editTextTextPersonName);

        Changepin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {


                new Changepinserver().execute("");
//                DbPositions dbPos = new DbPositions(Changepin.this);
//                String newpin1 = newpin.getText().toString();
//
//                if (!newpin1.equals("")) {
//                    String login = ThreeActivity.login;
//
//                    MyDBhelper myDB = new MyDBhelper(Changepin.this);
//                    myDB.UpdatePin(String.valueOf(login), newpin1);
//
//                    Toast.makeText(getBaseContext(), "Success" , Toast.LENGTH_SHORT ).show();
//                } else {
//
//                    Toast.makeText(getBaseContext(), "ERROR: Empty pin code" , Toast.LENGTH_SHORT ).show();
//                }

            }
        });
        Button Goback = findViewById(R.id.Goback5);

        Goback.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent Goback = new Intent(Changepin.this, ThreeActivity.class);
                startActivity(Goback);

            }
        });
    }
}