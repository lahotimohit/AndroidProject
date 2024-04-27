package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class recyclerview1 extends AppCompatActivity {

    RecyclerView recycle;
    FloatingActionButton fabtn;
    ArrayList<contactmodel> arrcontact = new ArrayList<>();
    RecyclerContactAdapter rcadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview1);

        recycle = findViewById(R.id.rcycleview);
        fabtn = findViewById(R.id.fbtn);
        recycle.setLayoutManager(new LinearLayoutManager(this));

        arrcontact.add(new contactmodel(R.drawable.a,"Mohit Lahoti","7568777573"));
        arrcontact.add(new contactmodel(R.drawable.b,"Siddharth Lahoti","7584123698"));
        arrcontact.add(new contactmodel(R.drawable.c,"Mohit Lahoti","7568777573"));
        arrcontact.add(new contactmodel(R.drawable.d,"Siddharth Lahoti","7584123698"));
        arrcontact.add(new contactmodel(R.drawable.e,"Mohit Lahoti","7568777573"));
        arrcontact.add(new contactmodel(R.drawable.f,"Siddharth Lahoti","7584123698"));
        arrcontact.add(new contactmodel(R.drawable.g,"Mohit Lahoti","7568777573"));
        arrcontact.add(new contactmodel(R.drawable.h,"Siddharth Lahoti","7584123698"));
        arrcontact.add(new contactmodel(R.drawable.a,"Mohit Lahoti","7568777573"));
        arrcontact.add(new contactmodel(R.drawable.b,"Siddharth Lahoti","7584123698"));
        arrcontact.add(new contactmodel(R.drawable.c,"Mohit Lahoti","7568777573"));
        arrcontact.add(new contactmodel(R.drawable.d,"Siddharth Lahoti","7584123698"));
        arrcontact.add(new contactmodel(R.drawable.e,"Mohit Lahoti","7568777573"));
        arrcontact.add(new contactmodel(R.drawable.f,"Siddharth Lahoti","7584123698"));
        arrcontact.add(new contactmodel(R.drawable.g,"Mohit Lahoti","7568777573"));
        arrcontact.add(new contactmodel(R.drawable.h,"Siddharth Lahoti","7584123698"));

        rcadapter = new RecyclerContactAdapter(this,arrcontact);
        recycle.setAdapter(rcadapter);

        fabtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog = new Dialog(recyclerview1.this);
                dialog.setContentView(R.layout.addupdatelay);

                EditText editname = dialog.findViewById(R.id.editname);
                EditText editnumber = dialog.findViewById(R.id.editnumber);
                Button add = dialog.findViewById(R.id.btnadd);

                add.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String name="", number="";
                        if(!editname.getText().toString().equals(""))
                        {
                            name=editname.getText().toString();
                        }
                        else
                        {
                            Toast.makeText(recyclerview1.this, "Please Enter Name.....", Toast.LENGTH_SHORT).show();
                        }
                        if(!editnumber.getText().toString().equals(""))
                        {
                            number=editnumber.getText().toString();
                        }
                        else
                        {
                            Toast.makeText(recyclerview1.this, "Please Enter Number.....", Toast.LENGTH_SHORT).show();
                        }
                        arrcontact.add(new contactmodel(R.drawable.g,name, number));
                        rcadapter.notifyItemInserted(arrcontact.size()-1);
                        recycle.scrollToPosition(arrcontact.size()-1);
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });

    }
}