package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;

import java.util.ArrayList;

public class usersadapter extends BaseAdapter {
    Context context;

    ArrayList<User> users;

    LayoutInflater inflater;

    public usersadapter(Context context, ArrayList<User> users) {
        this.users = users;
        this.context = context;

        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return users.size();
    }

    @Override
    public Object getItem(int position) {
        return users.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @SuppressLint("ViewHolder")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        User user = users.get(position);
        convertView = inflater.inflate(R.layout.item_user, null);

        TextView tvuserfullname = convertView.findViewById(R.id.TvuserItemFullname);
        TextView tvusercity = convertView.findViewById(R.id.Tviusercity);
        ImageButton btndetailsitem = convertView.findViewById(R.id.btnimage);

        tvuserfullname.setText(user.fullName());
        tvusercity.setText(user.getCity());
        btndetailsitem.setOnClickListener(v -> {
            Intent intent = new Intent(context, activity_details.class);
            intent.putExtra("firstname", user.getFirstName());
            intent.putExtra("lastname", user.getLastName());
            intent.putExtra("city", user.getCity());
            intent.putExtra("gender", user.getGender());
            context.startActivity(intent);
        });

        return convertView;


    }



    }


