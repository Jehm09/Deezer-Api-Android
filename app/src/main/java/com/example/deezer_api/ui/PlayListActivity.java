package com.example.deezer_api.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.deezer_api.R;
import com.example.deezer_api.control.PlaylistController;



public class PlayListActivity extends AppCompatActivity {

    private PlaylistController playlistController;

    private RecyclerView tracksRecycler;
    private ImageView coverIV;
    private TextView namePlaylist, description, numCanciones, numFans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlist);

        this.tracksRecycler = findViewById(R.id.tracksRecycler);
        tracksRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));

        this.coverIV =  findViewById(R.id.coverIV);
        this.namePlaylist =  findViewById(R.id.namePlaylist);
        this.namePlaylist =  findViewById(R.id.namePlaylist);
        this.description =  findViewById(R.id.description);
        this.numCanciones =  findViewById(R.id.numCanciones);
        this.numFans =  findViewById(R.id.numFans);

        String idPlaylist = getIntent().getExtras().getString("url");
        this.playlistController = new PlaylistController(this, idPlaylist);
    }

    public PlaylistController getPlaylistController() {
        return playlistController;
    }

    public void setPlaylistController(PlaylistController playlistController) {
        this.playlistController = playlistController;
    }

    public RecyclerView getTracksRecycler() {
        return tracksRecycler;
    }

    public void setTracksRecycler(RecyclerView tracksRecycler) {
        this.tracksRecycler = tracksRecycler;
    }

    public ImageView getCoverIV() {
        return coverIV;
    }

    public void setCoverIV(ImageView coverIV) {
        this.coverIV = coverIV;
    }

    public TextView getNamePlaylist() {
        return namePlaylist;
    }

    public void setNamePlaylist(TextView namePlaylist) {
        this.namePlaylist = namePlaylist;
    }

    public TextView getDescription() {
        return description;
    }

    public void setDescription(TextView description) {
        this.description = description;
    }

    public TextView getNumCanciones() {
        return numCanciones;
    }

    public void setNumCanciones(TextView numCanciones) {
        this.numCanciones = numCanciones;
    }

    public TextView getNumFans() {
        return numFans;
    }

    public void setNumFans(TextView numFans) {
        this.numFans = numFans;
    }
}
