package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class tablayout extends AppCompatActivity {

    TabLayout tl;
    ViewPager vp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tablayout);

        tl = findViewById(R.id.tlayout);
        vp = findViewById(R.id.viewpager);

        viewpagerchatadapter adapter = new viewpagerchatadapter(getSupportFragmentManager());
        vp.setAdapter(adapter);

        //change simultaneously or synchronizly tab as well as viewpager
        tl.setupWithViewPager(vp);

    }
}