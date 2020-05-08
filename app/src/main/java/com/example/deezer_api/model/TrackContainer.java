package com.example.deezer_api.model;

public class TrackContainer {
    private Track[] data;
    //private String checksum;

    public TrackContainer(Track[] data) {
        this.data = data;
        //this.checksum = checksum;
    }

    public TrackContainer() {
    }

    public Track[] getData() {
        return data;
    }

    public void setData(Track[] data) {
        this.data = data;
    }


}
