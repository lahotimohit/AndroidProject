package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class callactivity extends AppCompatActivity {

    Button call, msg, mail, share;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_callactivity);

        call = findViewById(R.id.callbtn);
        msg = findViewById(R.id.msgbtn);
        mail = findViewById(R.id.mailbtn);
        share = findViewById(R.id.sharebtn);

        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Intent idial = new Intent(Intent.ACTION_DIAL);
                    idial.setData(Uri.parse("tel: +917568777573"));
                    startActivity(idial);
            }
        });
        msg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent imsg = new Intent(Intent.ACTION_SENDTO);
                imsg.setData(Uri.parse("smsto:"+Uri.encode("+917568777573")));
                imsg.putExtra("sms_body", "Please solve this issue as soon as possible");
                startActivity(imsg);
            }
        });
        mail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iemail = new Intent(Intent.ACTION_SEND);
                iemail.setType("message/rfc822");
                iemail.putExtra(Intent.EXTRA_EMAIL, new String[] {"engtechno25@gmail.com","lahotimohit25@gmail.com"});
                iemail.putExtra(Intent.EXTRA_SUBJECT,"Queries");
                iemail.putExtra(Intent.EXTRA_TEXT,"Please solve this issue as soon as possible");
                startActivity(Intent.createChooser(iemail,"Email Via"));
            }
        });
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ishare = new Intent(Intent.ACTION_SEND);
                ishare.setType("text/plain");
                ishare.putExtra(Intent.EXTRA_TEXT,"Download this amazing app, I loved so much you can also enjoy");
                startActivity(Intent.createChooser(ishare, "Share via"));
            }
        });
    }
}