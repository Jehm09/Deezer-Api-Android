package com.example.deezer_api.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.deezer_api.R;
import com.example.deezer_api.control.*;

public class MainActivity extends AppCompatActivity {

    private  MainController mainController;
    private EditText input_search;
    private Button searchBtn;
    private RecyclerView playlistRecycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.input_search = findViewById(R.id.input_search);
        this.searchBtn = findViewById(R.id.searchBtn);

        this.mainController = new MainController(this);

        playlistRecycler = findViewById(R.id.playlistRecycler);
        playlistRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));

    }

    public MainController getMainController() {
        return mainController;
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    public EditText getInput_search() {
        return input_search;
    }

    public void setInput_search(EditText input_search) {
        this.input_search = input_search;
    }

    public Button getSearchBtn() {
        return searchBtn;
    }

    public void setSearchBtn(Button searchBtn) {
        this.searchBtn = searchBtn;
    }

    public RecyclerView getPlaylistRecycler() {
        return playlistRecycler;
    }

    public void setPlaylistRecycler(RecyclerView playlistRecycler) {
        this.playlistRecycler = playlistRecycler;
    }
}
