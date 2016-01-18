package com.samples.songster.search;

import com.samples.songster.search.repository.dto.SearchResultDto;
import com.samples.songster.search.repository.dto.SongDto;

import java.util.List;

/**
 * Created by chrisbraunschweiler1 on 04/11/15.
 */
public interface ViewModel {
    void createDisplayableResults(SearchResultDto result);

    List<SearchItemModel> getItems();

    SongDto selectSong(int position);
}
