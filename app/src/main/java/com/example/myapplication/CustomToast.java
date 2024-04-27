package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class CustomToast extends AppCompatActivity {
    Button custbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_toast);
        custbtn = findViewById(R.id.custbtn);

        custbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Custom Toast", "This is checking log in the activity");
                String tag = "Custom Random toast";
                Log.d(tag,"This is dynamic log cat message");
                Toast toast = new Toast(getApplicationContext());
                View view1 = getLayoutInflater().inflate(R.layout.toastdisplay,findViewById(R.id.toastlayout));
                toast.setView(view1);
                TextView txtmsg = view1.findViewById(R.id.txtmsg);
                txtmsg.setText("Message sent Successfully....");
                toast.setDuration(Toast.LENGTH_LONG);
                toast.setGravity(Gravity.TOP,0,0);
                toast.show();
            }
        });
    }
}