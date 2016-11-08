package com.miguelsportal.googleloginm;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class TrailActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
// gets the data stored in the trails.xml and then creates an adapter
        String[] trails = getResources().getStringArray(R.array.trail_list);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, trails);
//gets a reference to the list view in trail and passes it the adapter.
        ListView lv = (ListView) findViewById(R.id.listView);
        lv.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {// Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_trail, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {// everything below is just filler, none of the menu items have any functionality besides saying what you pressed, will need to expand in the future.
        int id = item.getItemId();

        switch (id)
        {
            case R.id.action_Alphanumeric:
                Toast toast = Toast.makeText(this, "You selected Alphanumeric",Toast.LENGTH_SHORT);
                toast.show();
                return true;
            case R.id.action_Rating:
                Toast toast1 = Toast.makeText(this, "You selected Rating",Toast.LENGTH_SHORT);
                toast1.show();
                return true;
            case R.id.action_Type:
                Toast toast2 = Toast.makeText(this, "You selected Type",Toast.LENGTH_SHORT);
                toast2.show();
                return true;
            case R.id.action_Difficulty:
                Toast toast3 = Toast.makeText(this, "You selected Difficulty",Toast.LENGTH_SHORT);
                toast3.show();
                return true;
            case R.id.action_Search:
                Toast toast4 = Toast.makeText(this, "You selected Search",Toast.LENGTH_SHORT);
                toast4.show();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
