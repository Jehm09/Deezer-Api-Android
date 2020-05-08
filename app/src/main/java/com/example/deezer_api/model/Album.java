package com.example.deezer_api.model;

public class Album {

    private Long id;
    private String title, cover, cover_big;

    public Album(Long id, String title, String cover, String cover_big) {
        this.id = id;
        this.title = title;
        this.cover = cover;
        this.cover_big = cover_big;
    }

    public Album() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getCover_big() {
        return cover_big;
    }

    public void setCover_big(String cover_big) {
        this.cover_big = cover_big;
    }
}
