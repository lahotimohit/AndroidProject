package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class BannerAds extends AppCompatActivity {
    AdView ban_ad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banner_ads);
        ban_ad = findViewById(R.id.bannerad);

        //Step1 Initialize Mobile ads
        MobileAds.initialize(this);

        //Step 2
        AdRequest adRequest = new AdRequest.Builder().build();

        //Step 3
        ban_ad.loadAd(adRequest);
    }
}