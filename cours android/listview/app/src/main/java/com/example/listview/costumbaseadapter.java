package com.example.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class costumbaseadapter extends BaseAdapter {
    Context context;
    String [] gunlist;
    int [] gunimage;

    LayoutInflater inflater;

    public costumbaseadapter(Context ctx, String [] gunlist, int[] gunimage) {
        this.context = ctx;
        this.gunlist = gunlist;
        this.gunimage = gunimage;
        this.inflater = LayoutInflater.from(ctx);
    }

    @Override
    public int getCount() {
        return gunlist.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertview, ViewGroup parent) {
        convertview = inflater.inflate(R.layout.activity_costumlistview,null);
        TextView textView = (TextView) convertview.findViewById(R.id.textview);
        ImageView gunicon =(ImageView) convertview.findViewById(R.id.imageicon);
        textView.setText(gunlist[position]);
        gunicon.setImageResource(gunimage[position]);

        return convertview;
    }

}
