package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;

public class miniproject extends AppCompatActivity implements View.OnClickListener {

    Button btnusersactloadusers , btnuseractquit ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnusersactloadusers = findViewById(R.id.btnusersactloadusers);
        btnuseractquit = findViewById(R.id.btnuseractquit);

        btnusersactloadusers.setOnClickListener(this);
        btnuseractquit.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnusersactloadusers){
            InputStream inputStream = getResources().openRawResource(R.raw.users);
            try {
                Toast.makeText(this, Character.toString((char) inputStream.read()), Toast.LENGTH_SHORT).show();
            }catch (IOException e) {
               e.printStackTrace();
            }
        }else if (v.getId() == R.id.btnuseractquit){

            finish();
        }
    }
}