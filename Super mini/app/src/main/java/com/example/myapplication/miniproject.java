package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class miniproject extends AppCompatActivity implements View.OnClickListener {

    Button btnusersactloadusers  ;
    TextView  TVuseractquit;
    ListView lvusers ;



    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnusersactloadusers = findViewById(R.id.btnusersactloadusers);
        TVuseractquit = findViewById(R.id.TVuseractquit);
        lvusers = findViewById(R.id.Lvusers);


        btnusersactloadusers.setOnClickListener(this);
        TVuseractquit.setOnClickListener(this);


        TVuseractquit.setOnTouchListener(new OnSwipTouchListner(this) {
            @Override
            public void swipeLeft() {
                finish();

            }

            @Override
            public void swipeRight() {
                Toast.makeText(miniproject.this, "This action is not yet implemented, if you want to quit the app. please swipe left !!!", Toast.LENGTH_SHORT).show();

            }
        });
    }


        ArrayList<String> names = new ArrayList<>();

//        names.add("kal");
//        names.add("lok");
//        names.add("fill");
//        names.add("kal");
//        names.add("lok");
//        names.add("fill");
//        names.add("kal");
//        names.add("lok");
//        names.add("fill");
//        names.add("kal");
//        names.add("lok");
//        names.add("fill");
//
//        ArrayAdapter<String> adapter = new ArrayAdapter<>(this , android.R.layout.simple_list_item_1,names);
//
//        lvusers.setAdapter(adapter);


//        try {
//            InputStream inputStream = getAssets().open("users.json");
//            int code ;
//            StringBuilder stringBuilder = new StringBuilder();
//            String jsonstring ;
//            code = inputStream.read();
//            while (code != -1){
//                stringBuilder.append((char) code);
//                code = inputStream.read();
//            }
//            jsonstring = stringBuilder.toString();
//            Toast.makeText(this, jsonstring, Toast.LENGTH_SHORT).show();
//
//
//        }catch (IOException e) {
//            e.printStackTrace();
//        }
//    }else if (v.getId() == R.id.btnuseractquit){
//
//        finish();
//    }
//}
//    }



    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnusersactloadusers) {
//            ArrayAdapter<User> adapter = new ArrayAdapter<>(
//                    this,
//                    android.R.layout.simple_list_item_1,
//                    getUsers());
            usersadapter adapter = new usersadapter(this , getUsers());

            lvusers.setAdapter(adapter);
        }
    }
    private ArrayList<User> getUsers() {
        ArrayList<User> usersFullNames = new ArrayList<>();
        try {
            InputStream inputStream = getAssets().open("users.json");
            int code;
            StringBuilder stringBuilder = new StringBuilder();
            String jsonString;
            code = inputStream.read();
            while (code != -1) {
                stringBuilder.append((char) code);
                code = inputStream.read();
            }
            jsonString = stringBuilder.toString();
            JSONObject jsonObject = new JSONObject(jsonString);
            JSONArray jsonArray = jsonObject.getJSONArray("users");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject user = jsonArray.getJSONObject(i);
                JSONObject userName = user.getJSONObject("name");
                usersFullNames.add(new User(
                        userName.getString("first"),
                        userName.getString("last"),
                        user.getString("gender"),
                        user.getString("city")));
            }
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
        return usersFullNames;

        //nice
    }
}
