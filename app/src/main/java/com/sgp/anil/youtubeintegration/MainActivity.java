package com.sgp.anil.youtubeintegration;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class MainActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {
    private String API_KEY = "AIzaSyCKJxkHVQtVjD61ULut2u50MyDjeqy-pbM";
    private String video_id = "lbngY1cPKXo";
    YouTubePlayerView youTubePlayerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        youTubePlayerView = (YouTubePlayerView) findViewById(R.id.youtube_view);
        youTubePlayerView.initialize(API_KEY, this);
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean wasRestored) {
        if (!wasRestored) {
            youTubePlayer.loadVideo(video_id);
        }
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        Toast.makeText(MainActivity.this, youTubeInitializationResult.toString(), Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onPause() {

        super.onPause();
    }
}