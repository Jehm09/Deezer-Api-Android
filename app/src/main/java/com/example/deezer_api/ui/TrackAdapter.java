package com.example.deezer_api.ui;



import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.deezer_api.R;

import com.example.deezer_api.model.Track;

import java.util.ArrayList;

public class TrackAdapter extends RecyclerView.Adapter<TrackAdapter.ViewHolderDatos> implements View.OnClickListener{

    private PlayListActivity playListActivity;
    private ArrayList<Track> tracks;
    private View.OnClickListener listener;

    public TrackAdapter(PlayListActivity playListActivity, ArrayList<Track> tracks) {
        this.playListActivity = playListActivity;
        this.tracks = tracks;
    }

    @NonNull
    @Override
    public ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler, null, false);
        view.setOnClickListener(this);
        return new ViewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderDatos holder, int position) {
        holder.setData(tracks.get(position));
    }

    @Override
    public int getItemCount() {
        return tracks.size();
    }

    @Override
    public void onClick(View v) {
        if(listener != null) {
            listener.onClick(v);
        }
    }

    public PlayListActivity getPlayListActivity() {
        return playListActivity;
    }

    public void setPlayListActivity(PlayListActivity playListActivity) {
        this.playListActivity = playListActivity;
    }

    public ArrayList<Track> getTracks() {
        return tracks;
    }

    public void setTracks(ArrayList<Track> tracks) {
        this.tracks = tracks;
    }

    public View.OnClickListener getListener() {
        return listener;
    }

    public void setListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder {
        private ImageView image;
        private TextView TV1, TV2, TV3;

        public ViewHolderDatos(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            TV1 = itemView.findViewById(R.id.TV1);
            TV2 = itemView.findViewById(R.id.TV2);
            TV3 = itemView.findViewById(R.id.TV3);

        }

        public void setData(Track track) {
            TV1.setText(track.getTitle());
            TV2.setText("Artist: "+ track.getArtist().getName());
            TV3.setText("Date: "+ track.getRelease_date());
            Glide.with(itemView).load(track.getAlbum().getCover()).centerCrop().into(image);
        }
    }
}
