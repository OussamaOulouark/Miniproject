package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

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
        convertView = inflater.inflate(R.layout.item_user, null);

        TextView tvuserfullname = convertView.findViewById(R.id.TvuserItemFullname);
        TextView tvusercity = convertView.findViewById(R.id.Tviusercity);
        Button btndetailsitem = convertView.findViewById(R.id.btndetailsitem);

        tvuserfullname.setText(users.get(position).fullName());
        tvusercity.setText(users.get(position).getCity());
        btndetailsitem.setOnClickListener(v ->{

        });


        return convertView;
    }

}
