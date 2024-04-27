package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

public class animationscreen extends AppCompatActivity {
    TextView txt1;
    Button b1,b2,b3,b4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animascreen);

        txt1=findViewById(R.id.txt1);

        b1=findViewById(R.id.btn1);
        b2=findViewById(R.id.btn2);
        b3=findViewById(R.id.btn3);
        b4=findViewById(R.id.btn4);

        Animation translate = AnimationUtils.loadAnimation(this,R.anim.move);
        Animation rotation = AnimationUtils.loadAnimation(this,R.anim.rotation);
        Animation alpha = AnimationUtils.loadAnimation(this,R.anim.alpha);
        Animation scale = AnimationUtils.loadAnimation(this,R.anim.scale);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt1.startAnimation(translate);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt1.startAnimation(rotation);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt1.startAnimation(alpha);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt1.startAnimation(scale);
            }
        });
    }
}