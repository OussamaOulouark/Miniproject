package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class activity_details extends AppCompatActivity {

    TextView Firstname, lastname, city;
    ImageView gender;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);


        Firstname = findViewById(R.id.TVfirstname);
        lastname = findViewById(R.id.TVlastname);
        city = findViewById(R.id.TVcity);
        gender = findViewById(R.id.Imageusers);

        String firstnameString = getIntent().getStringExtra("firstname");
        String lastnameString = getIntent().getStringExtra("lastname");
        String genderString = getIntent().getStringExtra("gender");
        String cityString = getIntent().getStringExtra("city");

        Firstname.setText(firstnameString);

        lastname.setText(lastnameString);

        city.setText(cityString);

        if (genderString.equals("male")){
            gender.setImageResource(R.drawable.male);
        }    else
            gender.setImageResource(R.drawable.female);
  }
}
