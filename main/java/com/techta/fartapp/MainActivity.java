package com.techta.fartapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageButton pooBtn;
    private Animation zoomOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        zoomOut = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_out);

        pooBtn = findViewById(R.id.imageButtonPoo);
        pooBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int[] sounds = {R.raw.fart1, R.raw.fart2, R.raw.fart3};

                pooBtn.startAnimation(zoomOut);

                Random random = new Random();
                int res = random.nextInt(2);
                MediaPlayer fart = MediaPlayer.create(getApplicationContext(), sounds[res]);
                fart.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        mediaPlayer.reset();
                        mediaPlayer.release();
                        mediaPlayer = null;
                    }
                });
                fart.start();
            }
        });

    }
}