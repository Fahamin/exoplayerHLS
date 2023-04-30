package com.convert.usd.aud.exoplayerhls;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.source.hls.HlsMediaSource;
import com.google.android.exoplayer2.ui.StyledPlayerView;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultHttpDataSource;

public class MainActivity extends AppCompatActivity {
    String lv = "https://d2q8p4pe5spbak.cloudfront.net/bpk-tv/9XM/9XM.isml/index.m3u8";


    private boolean playWhenReady = true;
    private int currentWindow = 0;
    private long playbackPosition = 0;
    protected ExoPlayer player;
    protected StyledPlayerView playerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        playerView = findViewById(R.id.mPlayerView);

        // Create a data source factory.
        DataSource.Factory dataSourceFactory = new DefaultHttpDataSource.Factory();
// Create a HLS media source pointing to a playlist uri.
        HlsMediaSource hlsMediaSource =
                new HlsMediaSource.Factory(dataSourceFactory)
                        .setAllowChunklessPreparation(false)
                        .createMediaSource(MediaItem.fromUri(lv));
// Create a player instance.
        player = new ExoPlayer.Builder(this).build();
// Set the media source to be played.
        player.setMediaSource(hlsMediaSource);

// Prepare the player.
        player.prepare();
        player.play();
        playerView.setPlayer(player);

    }
}