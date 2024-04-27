package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Customdialog extends AppCompatActivity {
    Button order;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customdialog);
        order = findViewById(R.id.orderbtn);
        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog = new Dialog(Customdialog.this);
                dialog.setContentView(R.layout.customdialogdesign);
                dialog.show();

                //the following operation makes dialog box non cancelable when tap outside its surface area....
                dialog.setCancelable(false);

                Button okay = dialog.findViewById(R.id.okaybtn);
                okay.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(Customdialog.this, "Cancel", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                });
            }
        });
    }
}