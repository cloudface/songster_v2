package com.samples.songster.search.repository.dto;

/**
 * Created by chrisbraunschweiler1 on 02/11/15.
 */
public class SongDto {
    private String artist;
    private String name;
    private String album;

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }
}
