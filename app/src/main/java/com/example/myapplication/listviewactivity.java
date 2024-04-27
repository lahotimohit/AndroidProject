package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class listviewactivity extends AppCompatActivity {

    ListView listView;
    ArrayList<String> arrNames = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listviewactivity);

        listView=findViewById(R.id.listview);

        arrNames.add("Mohit Lahoti");
        arrNames.add("Mohit Sankhla");
        arrNames.add("Parteek Sandhu");
        arrNames.add("Mayank Chouhan");
        arrNames.add("Ujjwal Kumar");
        arrNames.add("M.Bharath Kumar");
        arrNames.add("Mohit Lahoti");
        arrNames.add("Mohit Sankhla");
        arrNames.add("Parteek Sandhu");
        arrNames.add("Mayank Chouhan");
        arrNames.add("Ujjwal Kumar");
        arrNames.add("M.Bharath Kumar");
        arrNames.add("Mohit Lahoti");
        arrNames.add("Mohit Sankhla");
        arrNames.add("Parteek Sandhu");
        arrNames.add("Mayank Chouhan");
        arrNames.add("Ujjwal Kumar");
        arrNames.add("M.Bharath Kumar");

// add adapter here to call these arraylist
//  for adapter three things are required- context, layout, arraylist names

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1,arrNames);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Toast.makeText(listviewactivity.this, "Clicking Successful....", Toast.LENGTH_SHORT).show();
            }
        });

    }
}