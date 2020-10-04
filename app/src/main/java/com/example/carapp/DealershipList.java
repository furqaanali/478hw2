package com.example.carapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class DealershipList extends ListActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ArrayList<String> x = new ArrayList<>(
                Arrays.asList("Hello", "Hi")
        );

        final Intent intent = getIntent();
        ArrayList<String> dealerships = intent.getStringArrayListExtra("dealerships");

        // Create a new Adapter containing a list of colors
        // Set the adapter on this ListActivity's built-in ListView
        setListAdapter(new ArrayAdapter<String>(this, R.layout.activity_dealership_list, dealerships));

        ListView lv = getListView();

        // Enable filtering when the user types in the virtual keyboard
        lv.setTextFilterEnabled(true);

    }

}