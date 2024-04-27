package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Alertdialog extends AppCompatActivity {
    Button alertone, deletebtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alertdialog);

        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertone = findViewById(R.id.onebtn);
        deletebtn = findViewById(R.id.deletebtn);
        alertDialog.setTitle("Terms & Conditions");
        alertDialog.setIcon(R.drawable.baseline_info_24);
        alertDialog.setMessage("Shall We Proceed?");
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL,"Yess", new DialogInterface.OnClickListener()
        {

            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(Alertdialog.this, "Successfull....", Toast.LENGTH_SHORT).show();
            }
        });
        alertone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.show();
            }
        });

        AlertDialog.Builder deletedialog = new AlertDialog.Builder(this);
        deletedialog.setTitle("Delete");
        deletedialog.setIcon(R.drawable.baseline_delete_24);
        deletedialog.setMessage("Are you sure want to delete?");
        deletedialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(Alertdialog.this, "Item deleted successfully...", Toast.LENGTH_SHORT).show();
            }
        });
        deletedialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(Alertdialog.this, "Not delete", Toast.LENGTH_SHORT).show();
            }
        });
        deletebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deletedialog.show();
            }
        });
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder exitbuilder = new AlertDialog.Builder(this);
        exitbuilder.setTitle("Exit");
        exitbuilder.setIcon(R.drawable.baseline_exit_to_app_24);
        exitbuilder.setMessage("Are you sure want to delete?");
        exitbuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Alertdialog.super.onBackPressed();
            }
        });
        exitbuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(Alertdialog.this, "Welcome Back to app....", Toast.LENGTH_SHORT).show();
            }
        });
        exitbuilder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(Alertdialog.this, "Operation Terminated", Toast.LENGTH_SHORT).show();
            }
        });
        exitbuilder.show();
    }
}