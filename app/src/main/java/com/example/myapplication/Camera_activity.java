package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Camera_activity extends AppCompatActivity {
    ImageView cameraimg;

    private final int CAMERA_REQ_CODE = 100;
    private final int GALLERY_REQ_CODE = 200;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);

        cameraimg = findViewById(R.id.imgcamera);
        Button btncamera = findViewById(R.id.camerabtn);
        Button btngallery = findViewById(R.id.gallbtn);

        btncamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent icamera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(icamera,CAMERA_REQ_CODE);
            }
        });
        btngallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent igallery = new Intent(Intent.ACTION_PICK);
                igallery.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(igallery,GALLERY_REQ_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(resultCode==RESULT_OK)
        {
            if(requestCode==CAMERA_REQ_CODE)
            {
                Bitmap imgbit = (Bitmap)(data.getExtras().get("data"));
                cameraimg.setImageBitmap(imgbit);
            }
            else if(requestCode==GALLERY_REQ_CODE)
            {
                cameraimg.setImageURI(data.getData());
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}