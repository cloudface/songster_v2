package com.samples.songster.search.repository.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chrisbraunschweiler1 on 02/11/15.
 */
public class SearchResultDto {
    private List<SongDto> songs;

    public SearchResultDto(){
        songs = new ArrayList<>();
    }

    public List<SongDto> getSongs() {
        return songs;
    }

    public void setSongs(List<SongDto> songs) {
        this.songs = songs;
    }
}
