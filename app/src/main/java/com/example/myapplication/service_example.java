package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class service_example extends AppCompatActivity {

    Button starts, stops;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_example);

        starts = findViewById(R.id.startserv);
        stops = findViewById(R.id.stopserv);

        starts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startService(new Intent(service_example.this,Music_Service.class));
            }
        });
        stops.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopService(new Intent(service_example.this,Music_Service.class));
            }
        });
    }
}