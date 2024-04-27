package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class secondact extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondact);

        Intent fromact = getIntent();
        String title= fromact.getStringExtra("title");
        String sname = fromact.getStringExtra("Studentname");
        int roll=fromact.getIntExtra("roll",0);

        TextView text = findViewById(R.id.t1);

        text.setText("Name: "+sname+"   Roll No. : "+roll);
        getSupportActionBar().setTitle(title);
    }
}