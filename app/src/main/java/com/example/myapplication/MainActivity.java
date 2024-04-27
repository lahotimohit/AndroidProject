package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button animationbtn, lanimation, listbtn, spinnerbtn, actbtn,rcycle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button bt1 = findViewById(R.id.bt1);
       animationbtn = findViewById(R.id.btnanim);
       lanimation = findViewById(R.id.lanim);
       listbtn = findViewById(R.id.btlist);
       spinnerbtn = findViewById(R.id.spinbtn);
       actbtn = findViewById(R.id.autobtn);
       rcycle = findViewById(R.id.rcycle);

        animationbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent anibtn = new Intent(MainActivity.this, animationscreen.class);
                startActivity(anibtn);
            }
        });

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inext = new Intent(MainActivity.this, secondact.class);
                inext.putExtra("title", "Home");
                inext.putExtra("roll",12);
                inext.putExtra("Studentname", "Mohit Lahoti");
                startActivity(inext);
            }
        });

        lanimation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ilanim= new Intent(MainActivity.this, Lottieanimation.class);
                startActivity(ilanim);
            }
        });

        listbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ilist = new Intent(MainActivity.this, listviewactivity.class);
                startActivity(ilist);
            }
        });

        spinnerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ispin = new Intent(MainActivity.this, Spinneractivity.class);
                startActivity(ispin);
            }
        });

        actbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iauto = new Intent(MainActivity.this, Autocomplete.class);
                startActivity(iauto);
            }
        });

        rcycle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent irecycle = new Intent(MainActivity.this, recyclerview1.class);
                startActivity(irecycle);
            }
        });

    }
}