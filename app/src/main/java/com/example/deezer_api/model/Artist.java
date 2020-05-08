package com.example.deezer_api.model;

public class Artist {
    private Long id;
    private String name;

    public Artist(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Artist() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
}
