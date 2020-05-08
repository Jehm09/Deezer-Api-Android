package com.example.deezer_api.control;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.util.Log;
import android.view.View;

import com.bumptech.glide.Glide;
import com.example.deezer_api.R;
import com.example.deezer_api.model.Track;
import com.example.deezer_api.ui.TrackActivity;
import com.example.deezer_api.util.Constants;
import com.example.deezer_api.util.HTTPSWebUtilDomi;
import com.google.gson.Gson;

import java.io.IOException;

public class TrackController implements HTTPSWebUtilDomi.OnResponseListener, View.OnClickListener {
    private String idSong;
    private TrackActivity trackActivity;

    private HTTPSWebUtilDomi util;
    private Track track;

    private MediaPlayer mediaPlayer;

    public TrackController(TrackActivity trackActivity, String idSong) {
        this.idSong = idSong;
        this.trackActivity = trackActivity;
        this.util = new HTTPSWebUtilDomi();
        this.util.setListener(this);
        this.mediaPlayer = new MediaPlayer();

        //Loads the track
        new Thread(
                () -> {
                    util.GETrequest(Constants.TRACK_CALLBACK, "https://api.deezer.com/track/" + idSong);
                }
        ).start();

        trackActivity.getPlayBtn().setOnClickListener(this);
    }

    public String getIdSong() {
        return idSong;
    }

    public void setIdSong(String idSong) {
        this.idSong = idSong;
    }

    public TrackActivity getTrackActivity() {
        return trackActivity;
    }

    public void setTrackActivity(TrackActivity trackActivity) {
        this.trackActivity = trackActivity;
    }

    public HTTPSWebUtilDomi getUtil() {
        return util;
    }

    public void setUtil(HTTPSWebUtilDomi util) {
        this.util = util;
    }

    public Track getTrack() {
        return track;
    }

    public void setTrack(Track track) {
        this.track = track;
    }

    @Override
    public void onResponse(int callbackID, String response) {
        if (callbackID == Constants.TRACK_CALLBACK) {
            Gson gson = new Gson();
            Track track = gson.fromJson(response, Track.class);
            trackActivity.runOnUiThread(
                    () -> {
                        Glide.with(trackActivity).load(track.getAlbum().getCover_big()).centerCrop().into(trackActivity.getSongIV());
                        trackActivity.getNameSongTV().setText(track.getTitle());
                        trackActivity.getArtistSongTV().setText(track.getArtist().getName());
                        trackActivity.getAlbumSongTV().setText(track.getAlbum().getTitle());
                        trackActivity.getDurTV().setText(track.getDuration() + "");

                    }
            );

            try {
                mediaPlayer.setDataSource(track.getPreview());
                mediaPlayer.prepare();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.playBtn) {
            if (mediaPlayer.isPlaying()) {
                mediaPlayer.pause();
            } else {
                mediaPlayer.start();
            }
        }

    }
}
