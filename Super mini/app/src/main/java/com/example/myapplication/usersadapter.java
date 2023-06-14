package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

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


        tvuserfullname.setText(user.fullName());
        tvusercity.setText(user.getCity());

       convertView.setOnLongClickListener(new View.OnLongClickListener() {
           @Override
           public boolean onLongClick(View v) {
               AlertDialog.Builder builder = new AlertDialog.Builder(context);
               builder.setTitle(String.format("details of User %d" ,position +1 ))
                       .setMessage(user.toString())
                       .show();
               return false;
           }
       });

       convertView.setOnTouchListener(new View.OnTouchListener() {
           @Override
           public boolean onTouch(View v, MotionEvent event) {
               if (event.getAction() == MotionEvent.ACTION_DOWN)

                Toast.makeText(context, "down", Toast.LENGTH_SHORT).show();
               return true;
           }
       });




        return convertView;
    }

}
