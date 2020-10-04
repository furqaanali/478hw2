package com.example.carapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
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

        // Create a new Adapter containing a list of colors
        // Set the adapter on this ListActivity's built-in ListView
        setListAdapter(new ArrayAdapter<String>(this, R.layout.activity_dealership_list,
                x));

        ListView lv = getListView();

        // Enable filtering when the user types in the virtual keyboard
        lv.setTextFilterEnabled(true);

        // Set an setOnItemClickListener on the ListView
//		lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//			public void onItemClick(AdapterView<?> parent, View view,
//					int position, long id) {
//
//				// Display a Toast message indicting the selected item
//				Toast.makeText(getApplicationContext(),
//						((TextView) view).getText(), Toast.LENGTH_SHORT).show();
//			}
//		});
    }

    // Method onListItemClick() is an alternative to lv.setOnItemClickListener() in ListActivity
    // instances.  To switch methods, comment this method and uncomment the code above.  The
    // behavior of the app should not change.
    public void onListItemClick(ListView parent, View view,
                                int position, long id) {

        // Display a Toast message indicting the selected item
        Toast.makeText(getApplicationContext(),
                ((TextView) view).getText(), Toast.LENGTH_SHORT).show();
    }
}