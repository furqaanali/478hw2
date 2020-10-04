package com.example.carapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    protected static final String EXTRA_RES_ID = "POS";

    GridView gridView;
    ArrayList<Integer> thumbIDs = new ArrayList<>(
            Arrays.asList(R.drawable.thumb1, R.drawable.thumb2, R.drawable.thumb3, R.drawable.thumb4, R.drawable.thumb5, R.drawable.thumb6)
    );
    ArrayList<Integer> imageIDs = new ArrayList<>(
            Arrays.asList(R.drawable.image1, R.drawable.image2, R.drawable.image3, R.drawable.image4, R.drawable.image5, R.drawable.image6)
    );
    ArrayList<String> thumbStrings  = new ArrayList<>(
            Arrays.asList("Toyota Camry", "Toyota Corolla", "Toyota RAV4", "Honda Accord", "Honda Clarity Fuel Cell", "Honda CR-V")
    );
    ArrayList<String> webpages  = new ArrayList<>(
            Arrays.asList("https://www.toyota.com/camry/", "https://www.toyota.com/corolla/", "https://www.toyota.com/rav4/", "https://automobiles.honda.com/accord", "https://automobiles.honda.com/clarity-fuel-cell", "https://automobiles.honda.com/cr-v")
    );
    ArrayList<ArrayList<String>> dealers = new ArrayList<ArrayList<String>>(
            Arrays.asList(
                    new ArrayList<String>(Arrays.asList("Chicago Northside Toyota \n6042 N Western Ave", "Midtown Toyota \n2700 N Cicero Ave", "Toyota On Western \n6941 S Western Ave")),
                    new ArrayList<String>(Arrays.asList("Chicago Northside Toyota \n6042 N Western Ave", "Midtown Toyota \n2700 N Cicero Ave", "Toyota On Western \n6941 S Western Ave")),
                    new ArrayList<String>(Arrays.asList("Chicago Northside Toyota \n6042 N Western Ave", "Midtown Toyota \n2700 N Cicero Ave", "Toyota On Western \n6941 S Western Ave")),
                    new ArrayList<String>(Arrays.asList("Honda of Downtown Chicago \n1111 N Clark St #2", "McGrath City Honda \n6720 W Grand Ave.", "Honda City Chicago \n4950 S Pulaski Rd")),
                    new ArrayList<String>(Arrays.asList("Honda of Downtown Chicago \n1111 N Clark St #2", "McGrath City Honda \n6720 W Grand Ave.", "Honda City Chicago \n4950 S Pulaski Rd")),
                    new ArrayList<String>(Arrays.asList("Honda of Downtown Chicago \n1111 N Clark St #2", "McGrath City Honda \n6720 W Grand Ave.", "Honda City Chicago \n4950 S Pulaski Rd"))
            )
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = findViewById(R.id.gridView);
        gridView.setAdapter(new ViewAdapter(MainActivity.this, thumbIDs, thumbStrings));

        registerForContextMenu(gridView);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {

                //Create an Intent to start the ImageViewActivity
                Intent intent = new Intent(MainActivity.this,
                        ImageViewActivity.class);

                // Add the ID of the thumbnail to display as an Intent Extra
                intent.putExtra("imageIDs", imageIDs);
                intent.putExtra(EXTRA_RES_ID, (int) position);
                intent.putExtra("webpage", webpages.get(position));

                // Start the ImageViewActivity
                startActivity(intent);
            }
        });
    }

    // Create Context Menu
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.context_menu, menu);

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

        Intent intent;
        switch (item.getItemId()) {
            case R.id.viewImageMenuItem:
                //Create an Intent to start the ImageViewActivity
                intent = new Intent(MainActivity.this,
                        ImageViewActivity.class);

                // Add the ID of the thumbnail to display as an Intent Extra
                intent.putExtra("imageIDs", imageIDs);
                intent.putExtra(EXTRA_RES_ID, (int) info.position);
                intent.putExtra("webpage", webpages.get(info.position));

                // Start the ImageViewActivity
                startActivity(intent);
                return true;

            case R.id.viewWebpageMenuItem:
                Uri site = Uri.parse(webpages.get(info.position));
                intent = new Intent(Intent.ACTION_VIEW, site);
                startActivity(intent);
                return true;

            case R.id.viewDealershipsMenuItem:
                intent = new Intent(MainActivity.this, DealershipList.class);
                intent.putExtra("dealerships", dealers.get(info.position));
                startActivity(intent);
                return true;

            default:
                return false;
        }
    }
}