package com.example.carapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

public class ImageViewActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        // Get the Intent used to start this Activity
        final Intent intent = getIntent();

        // Make a new ImageView
        // Example of programmatic layout definition
        ImageView imageView = new ImageView(getApplicationContext());

        // Get the ID of the image to display and set it as the image for this ImageView
        ArrayList<Integer> imageIDs = intent.getIntegerArrayListExtra("imageIDs");
        imageView.setImageResource(imageIDs.get(intent.getIntExtra(MainActivity.EXTRA_RES_ID, 0)));
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri site = Uri.parse(intent.getStringExtra("webpage"));
                Intent intent = new Intent(Intent.ACTION_VIEW, site);
                startActivity(intent);
            }
        });

        setContentView(imageView);
    }

}