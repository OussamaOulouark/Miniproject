package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class miniproject extends AppCompatActivity implements View.OnClickListener {

    Button btnusersactloadusers , btnuseractquit ;
    ListView lvusers ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnusersactloadusers = findViewById(R.id.btnusersactloadusers);
        btnuseractquit = findViewById(R.id.btnuseractquit);
        lvusers = findViewById(R.id.Lvusers);


        btnusersactloadusers.setOnClickListener(this);
        btnuseractquit.setOnClickListener(this);

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


}
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnusersactloadusers) {
            ArrayAdapter<String> adapter = null;
            try {
                InputStream inputStream = getAssets().open("users.json");
                int code;
                StringBuilder stringBuilder = new StringBuilder();
                String jsonString;
                adapter = new ArrayAdapter<>(
                        this,
                        android.R.layout.simple_list_item_1,
                        getUsers());

                code = inputStream.read();
                while (code != -1) {
                    stringBuilder.append((char) code);

                    code = inputStream.read();
                }
                jsonString = stringBuilder.toString();

                JSONObject jsonObject = new JSONObject(jsonString);
//                JSONArray jsonArray = (JSONArray) jsonObject.get("users");
                JSONArray jsonArray = jsonObject.getJSONArray("users");
                StringBuilder stringBuilderFullNames = new StringBuilder();
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject user = jsonArray.getJSONObject(i);
                    JSONObject userName = user.getJSONObject("name");
                    String fullName = String.format("%s %s\n", userName.get("first"), userName.get("last"));

                    stringBuilderFullNames.append(fullName);
                }

                Toast.makeText(this, stringBuilderFullNames, Toast.LENGTH_SHORT).show();
            } catch (IOException | JSONException e) {
                e.printStackTrace();
            }
            lvusers.setAdapter(adapter);
        } else if (v.getId() == R.id.btnuseractquit) {
            finish();
        }
    }

    private ArrayList<String> getUsers() {
        ArrayList<String> usersFullNames = new ArrayList<>();

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

                usersFullNames.add(String.format("%s %s\n", userName.get("first"), userName.get("last")));
            }
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }

        return usersFullNames;
        //display json data in a list view
    }
}
