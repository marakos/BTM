package com.example.app1;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.support.v7.app.AppCompatActivity;
import android.widget.VideoView;

public class GameAnalysis extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_analysis);

        VideoView mVideoView = (VideoView) findViewById(R.id.videoView2);
        String vidAddress = "https://archive.org/download/ksnn_compilation_master_the_internet/ksnn_compilation_master_the_internet_512kb.mp4";
        Uri vidUri = Uri.parse(vidAddress);
        mVideoView.setVideoURI(vidUri);
        mVideoView.requestFocus();
        mVideoView.start();
        MediaController vidControl = new MediaController(this);
        vidControl.setAnchorView(mVideoView);
        mVideoView.setMediaController(vidControl);



    }


}






