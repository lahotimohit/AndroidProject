package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                SharedPreferences pref = getSharedPreferences("login",MODE_PRIVATE);
                Boolean check = pref.getBoolean("flag",false);
                Intent imain;
                if(check)
                {
                    imain = new Intent(SplashScreen.this, homeactivity.class);
                }
                else
                {
                    imain = new Intent(SplashScreen.this,loginactivity.class);
                }

                startActivity(imain);
                finish();
            }
        },4000);



    }
}