package com.example.deezer_api.model;

import java.io.Serializable;

public class PlayList {

    private long id;
    private String title;
    private String description;
    private long nb_tracks;
    private long fans;
    private String link;
    private String picture;
    private String picture_big;
    private String creation_date;

    private User user;
    private TrackContainer tracks;

    public PlayList(long id, String title, String description, long nb_tracks, long fans, String link, String picture, String picture_big, String creation_date, User user, TrackContainer tracks) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.nb_tracks = nb_tracks;
        this.fans = fans;
        this.link = link;
        this.picture = picture;
        this.picture_big = picture_big;
        this.creation_date = creation_date;
        this.user = user;
        this.tracks = tracks;
    }

    public PlayList() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getNb_tracks() {
        return nb_tracks;
    }

    public void setNb_tracks(long nb_tracks) {
        this.nb_tracks = nb_tracks;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getPicture_big() {
        return picture_big;
    }

    public void setPicture_big(String picture_big) {
        this.picture_big = picture_big;
    }

    public String getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(String creation_date) {
        this.creation_date = creation_date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public TrackContainer getTracks() {
        return tracks;
    }

    public void setTracks(TrackContainer tracks) {
        this.tracks = tracks;
    }

    public long getFans() {
        return fans;
    }

    public void setFans(long fans) {
        this.fans = fans;
    }
}
