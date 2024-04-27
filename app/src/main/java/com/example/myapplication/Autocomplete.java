package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import java.util.ArrayList;

public class Autocomplete extends AppCompatActivity {
    AutoCompleteTextView actxt;
    ArrayList<String> languages = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_autocomplete);
        actxt = findViewById(R.id.autoctxt);

        languages.add("C");
        languages.add("C++");
        languages.add("Java");
        languages.add("JavaScript");
        languages.add("Python");
        languages.add("Flutter");
        languages.add("MySql");
        languages.add("CShell");

        ArrayAdapter<String> autoadapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, languages);
        actxt.setAdapter(autoadapter);
        actxt.setThreshold(1);
    }
}