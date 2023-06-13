package com.example.myapplication;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class miniproject extends AppCompatActivity implements View.OnClickListener {

    Button btnusersactloadusers , btnuseractquit ;
    RadioButton Rdmale ,Rdfemale;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnusersactloadusers = findViewById(R.id.btnusersactloadusers);
        btnuseractquit = findViewById(R.id.btnuseractquit);
        Rdfemale = findViewById(R.id.Rbfemale);
        Rdmale = findViewById(R.id.Rbmale);

        btnusersactloadusers.setOnClickListener(this);
        btnuseractquit.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnusersactloadusers) {
            try {
                InputStream inputStream = getAssets().open("users.json");
                int code;
                StringBuilder stringBuilder = new StringBuilder();
                String jsonString;

                while ((code = inputStream.read()) != -1) {
                    stringBuilder.append((char) code);
                }

                jsonString = stringBuilder.toString();
                JSONObject jsonObject = new JSONObject(jsonString);
                JSONArray jsonArray = jsonObject.getJSONArray("users");

                StringBuilder stringBuilderFullname = new StringBuilder();
                String title = null;

                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject user = jsonArray.getJSONObject(i);
                    String gender = user.getString("gender");

                    if ((gender.equals("male") && Rdmale.isChecked())  ||
                            (gender.equals("female") && Rdfemale.isChecked())) {

                        JSONObject username = user.getJSONObject("name");
                        String fullName = String.format("%s %s | %s\n",
                                username.getString("first"),
                                username.getString("last"),
                                user.getString("city"));
                        stringBuilderFullname.append(fullName);
                        title = (gender.equals("male")) ? "Male Users" : "Female Users";
                    }
                }

                AlertDialog.Builder alertDialog = new AlertDialog.Builder(miniproject.this);
                alertDialog.setTitle(title);
                alertDialog.setMessage(stringBuilderFullname.toString());
                alertDialog.show();

            } catch (IOException | JSONException e) {
                e.printStackTrace();
            }
        } else if (v.getId() == R.id.btnuseractquit) {
            finish();
        }
    }

}


