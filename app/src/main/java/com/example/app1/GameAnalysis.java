package com.example.app1;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Path;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import android.view.ViewGroup.LayoutParams;
import android.widget.Toolbar;
import android.widget.VideoView;

import com.suyati.telvin.drawingboard.DrawingBoard;

import java.util.ArrayList;
import java.util.Calendar;

public class GameAnalysis extends AppCompatActivity {
    DrawingBoard drawingBoard;

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






