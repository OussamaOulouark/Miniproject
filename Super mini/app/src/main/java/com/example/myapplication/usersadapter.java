package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class usersadapter extends BaseAdapter {
    ArrayList<User> users;
    LayoutInflater inflater;

    public usersadapter(Context context, ArrayList<User> users) {
        this.users = users;

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
        return position;
    }

    @SuppressLint({"ViewHolder", "DefaultLocale"})
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(R.layout.item_user, null);

        TextView tvuserfullname = convertView.findViewById(R.id.TvuserItemFullname);
        TextView tvusercity = convertView.findViewById(R.id.Tviusercity);
        TextView tvusergender = convertView.findViewById(R.id.Tvusergender);

        tvuserfullname.setText(users.get(position).fullName());
        tvusercity.setText(users.get(position).getCity());
        tvusergender.setText(String.format("#%d",getItemId(position +1)));

        String gender = users.get(position).getGender();

        if (gender.equals("male")) {
            convertView.setBackgroundColor(convertView.getResources().getColor(R.color.blue)); // Set blue color for male
        } else if (gender.equals("female")) {
            convertView.setBackgroundColor(convertView.getResources().getColor(R.color.pink)); // Set pink color for female
        }


        return convertView;
    }

}
