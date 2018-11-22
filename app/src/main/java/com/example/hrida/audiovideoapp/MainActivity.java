package com.example.hrida.audiovideoapp;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mp;

    /*To create an Audio and Video app we need to add new directory under the "res" file and we name it "raw"*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setVolumeControlStream(AudioManager.STREAM_MUSIC);
        Button button1 = findViewById(R.id.audioButton);
        button1.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                playMusic();
            }
        });

        Button button2 = findViewById(R.id.videoButton);
        button2.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                playVideo();
            }
        });
    }

    public void playVideo(){
        if (mp != null){
            mp.release();
        }

        Intent i = new Intent(this, playVideo.class);
        startActivity(i);
    }

    public void playMusic() {
        // Release any resources from previous MediaPlayer
        if (mp != null){
            mp.release();
        }
        // Create a new MediaPlayer to play this sound
        mp = MediaPlayer.create(this, R.raw.diamonds);
        mp.start();
    }
}
