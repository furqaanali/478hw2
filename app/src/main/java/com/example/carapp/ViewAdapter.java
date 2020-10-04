package com.example.carapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ViewAdapter extends BaseAdapter {


    Context mContext;
    ArrayList<Integer> thumbIDs;
    ArrayList<String> thumbStrings;

    public ViewAdapter(Context mContext, ArrayList<Integer> thumbIDs, ArrayList<String> thumbStrings) {
        this.mContext = mContext;
        this.thumbIDs = thumbIDs;
        this.thumbStrings = thumbStrings;
    }

    @Override
    public int getCount() {
        return thumbIDs.size();
    }

    @Override
    public Object getItem(int i) {
        return thumbIDs.get(i);
    }

    @Override
    public long getItemId(int i) {
        return thumbIDs.get(i);
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        View imageWithText;
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (view == null) {
            imageWithText = new View(mContext);
            imageWithText = inflater.inflate(R.layout.image_with_text, null);
            ImageView imageView = imageWithText.findViewById(R.id.gridImage);
            TextView textView = imageWithText.findViewById(R.id.gridText);
            imageView.setImageResource(thumbIDs.get(i));
            textView.setText(thumbStrings.get(i));
        }
        else {
            imageWithText = (View) view;
        }

        return imageWithText;
    }
}
