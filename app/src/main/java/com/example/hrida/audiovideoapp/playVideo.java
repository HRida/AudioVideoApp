package com.example.hrida.audiovideoapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class playVideo extends AppCompatActivity {

    private VideoView mV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_video);

        mV = findViewById(R.id.videoView);

        mV.setVideoURI(Uri.parse("android.resource://"+ getPackageName() + "/" + R.raw.a2sprechen));

        mV.setMediaController(new MediaController(this));

        mV.requestFocus();

        Button back;

        back = findViewById(R.id.btnBack);

        back.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                backToMain();
            }
        });
    }

    public void backToMain() {

        Intent j = new Intent(this, MainActivity.class);
        startActivity(j);
    }
}
