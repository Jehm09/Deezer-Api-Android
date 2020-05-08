package com.example.deezer_api.control;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.deezer_api.R;

import com.example.deezer_api.model.PlayListContainer;
import com.example.deezer_api.ui.PlayListActivity;
import com.example.deezer_api.ui.PlaylistAdapter;
import com.example.deezer_api.ui.MainActivity;
import com.example.deezer_api.util.Constants;
import com.example.deezer_api.util.HTTPSWebUtilDomi;
import com.google.gson.Gson;

public class MainController implements View.OnClickListener, HTTPSWebUtilDomi.OnResponseListener {

    private MainActivity mainActivity;
    private HTTPSWebUtilDomi util;
    private PlaylistAdapter playlistAdapter;

    public MainController(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
        this.util = new HTTPSWebUtilDomi();
        this.util.setListener(this);
        mainActivity.getSearchBtn().setOnClickListener(this);
    }

    public void addEventPlaylistAdapter() {
        playlistAdapter.setListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(mainActivity, PlayListActivity.class);
                long id = playlistAdapter.getPlayLists()[mainActivity.getPlaylistRecycler().getChildAdapterPosition(v)].getId();
                i.putExtra("url", id+"");
                mainActivity.startActivity(i);
                Log.e(">>>>>>", "ID: " + id);
            }
        });
    }


    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.searchBtn){
            String nameList = mainActivity.getInput_search().getText().toString();
            new Thread(
                    () -> {
                        util.GETrequest(Constants.SEARCH_CALLBACK, "https://api.deezer.com/search/playlist?q=" + nameList);
                    }
            ).start();
        }
    }

    @Override
    public void onResponse(int callbackID, String response) {
        if(callbackID == Constants.SEARCH_CALLBACK){
            Gson gson = new Gson();
            PlayListContainer playListContainer = gson.fromJson(response, PlayListContainer.class);
            if (playListContainer.getData() != null) {
                mainActivity.runOnUiThread(
                        () -> {
                            playlistAdapter = new PlaylistAdapter(mainActivity, playListContainer.getData());
                            mainActivity.getPlaylistRecycler().setAdapter(playlistAdapter);
                            addEventPlaylistAdapter();
                        }
                );
            }
        }
    }
}
