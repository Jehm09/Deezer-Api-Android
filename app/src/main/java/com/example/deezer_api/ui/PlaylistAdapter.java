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
import com.example.deezer_api.model.PlayList;

public class PlaylistAdapter extends RecyclerView.Adapter<PlaylistAdapter.ViewHolderDatos> implements  View.OnClickListener{

    private MainActivity mainActivity;
    private PlayList[] playLists;
    private View.OnClickListener listener;

    public PlaylistAdapter(MainActivity mainActivity, PlayList[] playLists) {
        this.mainActivity = mainActivity;
        this.playLists = playLists;
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
        holder.setData(playLists[position]);
    }

    @Override
    public int getItemCount() {
        return playLists.length;
    }

    @Override
    public void onClick(View v) {
        if(listener != null) {
            listener.onClick(v);
        }
    }

    public MainActivity getMainActivity() {
        return mainActivity;
    }

    public void setMainActivity(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    public PlayList[] getPlayLists() {
        return playLists;
    }

    public void setPlayLists(PlayList[] playLists) {
        this.playLists = playLists;
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

        public void setData(PlayList playList) {
            TV1.setText(playList.getTitle());
            TV2.setText("User: "+ playList.getUser().getName());
            TV3.setText("Items: "+ playList.getNb_tracks());
            Glide.with(itemView).load(playList.getPicture()).centerCrop().into(image);
        }
    }
}
