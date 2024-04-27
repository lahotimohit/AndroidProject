package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class Toolbar extends AppCompatActivity {

    androidx.appcompat.widget.Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toolbar);

        toolbar = findViewById(R.id.toolbar);

        //step 1
        setSupportActionBar(toolbar);

        //step 2
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Welcome to This Activity");
        //toolbar.setTitle("Welcome to This Activity");
        toolbar.setSubtitle("Jai Shree Ram");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        new MenuInflater(this).inflate(R.menu.opt_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemid = item.getItemId();
        if(itemid == R.id.newfile)
        {
            Toast.makeText(this, "New File Created.....", Toast.LENGTH_SHORT).show();
        }
        else if (itemid==R.id.openfile)
        {
            Toast.makeText(this, "File Opened", Toast.LENGTH_SHORT).show();
        }
        else if (itemid==R.id.savefile)
        {
            Toast.makeText(this, "Your file save successfully.....", Toast.LENGTH_SHORT).show();
        }
        else if (itemid==android.R.id.home)
        {
            super.onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}