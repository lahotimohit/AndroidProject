package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

public class Spinneractivity extends AppCompatActivity {
    Spinner actspin;
    ArrayList<String> arrid = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinneractivity);

        actspin = findViewById(R.id.spin);
        arrid.add("Aadhar Card");
        arrid.add("Pan Card");
        arrid.add("Voter ID Card");
        arrid.add("Driving License");

        ArrayAdapter<String> spinadapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line,arrid);
        actspin.setAdapter(spinadapter);
    }
}