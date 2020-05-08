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

public class TrackAdapter extends RecyclerView.Adapter<TrackAdapter.ViewHolderDatos> {

    private PlayListActivity playListActivity;
    private ArrayList<Track> tracks;

    public TrackAdapter(PlayListActivity playListActivity, ArrayList<Track> tracks) {
        this.playListActivity = playListActivity;
        this.tracks = tracks;
    }

    @NonNull
    @Override
    public ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler, null, false);
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

           /* itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(playListActivity, PlayListActivity.class);
                    i.putExtra("playList", playList);
                    mainActivity.startActivity(i);
                }
            });*/
        }
    }
}
