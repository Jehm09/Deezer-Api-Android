package com.example.deezer_api.ui;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import com.example.deezer_api.R;
import com.example.deezer_api.control.TrackController;

public class TrackActivity extends AppCompatActivity {

    private TrackController trackController;
    private ImageView songIV;
    private TextView nameSongTV, artistSongTV, albumSongTV, durTV;
    private Button playBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_track);

        songIV = findViewById(R.id.songIV);
        nameSongTV = findViewById(R.id.nameSongTV);
        artistSongTV = findViewById(R.id.artistSongTV);
        artistSongTV = findViewById(R.id.artistSongTV);
        albumSongTV = findViewById(R.id.albumSongTV);
        durTV = findViewById(R.id.durTV);
        playBtn = findViewById(R.id.playBtn);

        String idTrack = getIntent().getExtras().getString("url");
        trackController = new TrackController(this, idTrack);
    }

    public TrackController getTrackController() {
        return trackController;
    }

    public void setTrackController(TrackController trackController) {
        this.trackController = trackController;
    }

    public ImageView getSongIV() {
        return songIV;
    }

    public void setSongIV(ImageView songIV) {
        this.songIV = songIV;
    }

    public TextView getNameSongTV() {
        return nameSongTV;
    }

    public void setNameSongTV(TextView nameSongTV) {
        this.nameSongTV = nameSongTV;
    }

    public TextView getArtistSongTV() {
        return artistSongTV;
    }

    public void setArtistSongTV(TextView artistSongTV) {
        this.artistSongTV = artistSongTV;
    }

    public TextView getAlbumSongTV() {
        return albumSongTV;
    }

    public void setAlbumSongTV(TextView albumSongTV) {
        this.albumSongTV = albumSongTV;
    }

    public TextView getDurTV() {
        return durTV;
    }

    public void setDurTV(TextView durTV) {
        this.durTV = durTV;
    }

    public Button getPlayBtn() {
        return playBtn;
    }

    public void setPlayBtn(Button playBtn) {
        this.playBtn = playBtn;
    }
}
