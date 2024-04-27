package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class Video_Implement extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_implement);

        VideoView bvideo = findViewById(R.id.bhajanvideo);

        String vpath = "android.resource://" + getPackageName() + "/raw/shyam_bhajan";

        Uri vuri = Uri.parse(vpath);
        bvideo.setVideoURI(vuri);
        bvideo.start();

        MediaController mc = new MediaController(this);
        bvideo.setMediaController(mc);
        mc.setAnchorView(bvideo);
    }
}