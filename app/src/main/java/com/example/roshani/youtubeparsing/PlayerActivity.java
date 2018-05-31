package com.example.roshani.youtubeparsing;

import android.os.Bundle;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class PlayerActivity extends YouTubeBaseActivity{
    YouTubePlayerView player;
    String videoid;
    String apikey = "AIzaSyAJ7XL6febb9L2PNpiiIrmrG-dJNOGfZ9g";

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.playerlayout);
        player=findViewById(R.id.player);
        videoid=getIntent().getStringExtra("id");
        player.initialize(apikey, new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.loadVideo(videoid);
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        });

    }
}
