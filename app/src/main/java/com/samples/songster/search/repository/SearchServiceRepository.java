package com.samples.songster.search.repository;

import com.samples.songster.search.repository.dto.SearchResultDto;
import com.samples.songster.search.repository.dto.SongDto;

/**
 * Created by chrisbraunschweiler1 on 02/11/15.
 */
public class SearchServiceRepository implements SearchRepository {
    @Override
    public void search(String searchString, SearchListener listener) {
        //TODO Return mock data
        SearchResultDto resultDto = new SearchResultDto();
        SongDto song1 = new SongDto();
        song1.setAlbum("Album 1");
        song1.setArtist("Artist 1");
        song1.setName("Song 1");
        resultDto.getSongs().add(song1);

        SongDto song2 = new SongDto();
        song2.setAlbum("Album 2");
        song2.setArtist("Artist 2");
        song2.setName("Song 2");
        resultDto.getSongs().add(song2);

        SongDto song3 = new SongDto();
        song3.setAlbum("Album 3");
        song3.setArtist("Artist 3");
        song3.setName("Song 3");
        resultDto.getSongs().add(song3);

        SongDto song4 = new SongDto();
        song4.setAlbum("Album 4");
        song4.setArtist("Artist 4");
        song4.setName("Song 4");
        resultDto.getSongs().add(song4);

        SongDto song5 = new SongDto();
        song5.setAlbum("Album 5");
        song5.setArtist("Artist 5");
        song5.setName("Song 5");
        resultDto.getSongs().add(song5);

        listener.onSearchSuccess(resultDto);
    }

    @Override
    public void addSongToMyList(SongDto song, SearchListener listener) {

    }
}
