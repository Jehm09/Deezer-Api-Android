package com.example.deezer_api.control;

import android.util.Log;

import com.bumptech.glide.Glide;
import com.example.deezer_api.model.PlayList;
import com.example.deezer_api.model.Track;
import com.example.deezer_api.ui.PlayListActivity;
import com.example.deezer_api.ui.TrackAdapter;
import com.example.deezer_api.util.Constants;
import com.example.deezer_api.util.HTTPSWebUtilDomi;
import com.google.gson.Gson;

import java.util.ArrayList;

public class PlaylistController implements HTTPSWebUtilDomi.OnResponseListener {

    private PlayListActivity playListActivity;
    private HTTPSWebUtilDomi util;
    private PlayList playList;
    private ArrayList<Track> trackList;
    private int flag;

    private TrackAdapter trackAdapter;
    private String idPlaylist;

    public PlaylistController(PlayListActivity playListActivity, String idPlaylist) {
        this.idPlaylist = idPlaylist;
        this.playListActivity = playListActivity;
        this.util = new HTTPSWebUtilDomi();
        this.util.setListener(this);
        trackList = new ArrayList<>();

        //Loads the playlist
        new Thread(
                () -> {
                    util.GETrequest(Constants.PLAYLIST_CALLBACK, "https://api.deezer.com/playlist/" + idPlaylist);
                }
        ).start();
    }

    public String getIdPlaylist() {
        return idPlaylist;
    }

    public void setIdPlaylist(String idPlaylist) {
        this.idPlaylist = idPlaylist;
    }

    @Override
    public void onResponse(int callbackID, String response) {
        if (callbackID == Constants.PLAYLIST_CALLBACK) {
            Gson gson = new Gson();
            this.playList = gson.fromJson(response, PlayList.class);
            //Loads the view
            playListActivity.runOnUiThread(
                    () -> {
                        Glide.with(playListActivity).load(playList.getPicture_big()).fitCenter().into(playListActivity.getCoverIV());
                        playListActivity.getNamePlaylist().setText(playList.getTitle());
                        playListActivity.getDescription().setText("Description: " + playList.getDescription());
                        playListActivity.getNumCanciones().setText("# Songs: " + playList.getNb_tracks());
                        playListActivity.getNumFans().setText("# Fans: " + playList.getFans());
                    }
            );
            loadTracks(playList.getTracks().getData());
            Log.e(">>>>>", "Cantidad: " + playList.getTracks().getData().length);
        } else if (callbackID == Constants.TRACK_CALLBACK) {
            Gson gson = new Gson();
            Track track = gson.fromJson(response, Track.class);
            trackList.add(track);

            if (trackList.size() == playList.getTracks().getData().length) {
                playListActivity.runOnUiThread(
                        () -> {
                            trackAdapter = new TrackAdapter(playListActivity, trackList);
                            playListActivity.getTracksRecycler().setAdapter(trackAdapter);
                        }
                );
            }
            //Log.e(">>>>>>>>>", track.getTitle());
            //Log.e(">>>>>>>>>", trackList.get(0).getTitle() + "");

        }
    }

    public void loadTrack(long id) {
        new Thread(
                () -> {
                    util.GETrequest(Constants.TRACK_CALLBACK, "https://api.deezer.com/track/" + id);
                }
        ).start();
    }

    public void loadTracks(Track[] data) {
        for (int i = 0; i < data.length; i++) {
            if (data[i] != null) {
                loadTrack(data[i].getId());
            }
        }

    }
}
