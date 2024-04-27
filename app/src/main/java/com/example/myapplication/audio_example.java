package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

public class audio_example extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio_example);

        Button play,pause,stop;

        MediaPlayer mp = new MediaPlayer();
        mp.setAudioStreamType(AudioManager.STREAM_MUSIC);

        //Audio from local raw folder access
         String path = "android.resource://" + getPackageName() + "/raw/shiv_bhajan";

        //Audio from external server resource
        //String onlineurl = "http://commondatastorage.googleapis.com/codeskulptor-demos/DDR_assets/Kangaroo_MusiQue_-_The_Neverwritten_Role_Playing_Game.mp3";



        //ya par hum uri se audio play karaynge
        //bina uri ke bhi audio play ho jayega par error ke chances bad jayenge.....


        //This uri is for local audio file that is placed in raw folder
        Uri audiouri = Uri.parse(path);

        //Uri onlineuri = Uri.parse(onlineurl);

        try {
            //this is for local audio file
            mp.setDataSource(this,audiouri);

            //this is for online audio file
            //mp.setDataSource(this,onlineuri);
            mp.prepare();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        play = findViewById(R.id.playbtn);
        pause = findViewById(R.id.pausebtn);
        stop = findViewById(R.id.stopbtn);

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.start();
            }
        });

        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.pause();
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.pause();
                mp.seekTo(0);
            }
        });

        // some also important functions of media player mp.seekTo(); mp.getDuration(); mp.getCurrentPosition();
//        Useful listener-
//        use when one song is complete and another add after them(Auto play)
//        mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
//            @Override
//            public void onCompletion(MediaPlayer mp) {
//
//            }
//        });
    }
}