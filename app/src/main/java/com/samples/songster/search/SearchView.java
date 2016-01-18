package com.samples.songster.search;

import com.samples.songster.search.repository.dto.SongDto;

import java.util.List;

/**
 * Created by chrisbraunschweiler1 on 02/11/15.
 */
public interface SearchView {
    void showProgressBar();

    void showResults();

    void showNoResultsMessage();

    void showInfoMessage();

    void hideKeyboard();

    void updateResults();
}
