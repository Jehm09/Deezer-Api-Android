package com.example.deezer_api.model;

public class PlayListContainer {
    private PlayList data[];

    public PlayListContainer(PlayList[] data) {
        this.data = data;
    }

    public PlayListContainer() {

    }

    public PlayList[] getData() {
        return data;
    }

    public void setData(PlayList[] data) {
        this.data = data;
    }
}
