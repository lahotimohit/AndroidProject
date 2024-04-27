package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class bottomnavigationactivity extends AppCompatActivity {
    BottomNavigationView bnview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottomnavigationactivity);
        bnview = findViewById(R.id.bnview);

        bnview.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if(id == R.id.homemenu)
                {
                    loadfrag(new Afragment(),1);
                }
                else if(id == R.id.search)
                {
                    loadfrag(new Bfragment(),1);
                }
                else if(id == R.id.setting)
                {
                    loadfrag(new dfragment(),1);
                }
                else
                {
                    loadfrag(new Cfragment(),0);
                }
                return true;
            }
        });

        bnview.setSelectedItemId(R.id.user);
    }
    public void loadfrag (Fragment fragment, int flag)
    {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        if(flag==0)
        {
            ft.add(R.id.flayout, fragment);
        }
        else
        {
            ft.replace(R.id.flayout, fragment);
        }
        ft.commit();
    }
}