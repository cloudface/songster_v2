package com.samples.songster.search;

import com.samples.songster.search.repository.SearchRepository;
import com.samples.songster.search.repository.dto.SearchResultDto;
import com.samples.songster.search.repository.dto.SongDto;

/**
 * Created by chrisbraunschweiler1 on 02/11/15.
 */
public class SearchPresenter implements SearchRepository.SearchListener {

    private ViewModel mViewModel;
    private SearchRepository mSearchRepository;
    private SearchView mSearchView;

    public SearchPresenter(ViewModel viewModel, SearchRepository searchRepository, SearchView searchView){
        this.mViewModel = viewModel;
        mSearchRepository = searchRepository;
        mSearchView = searchView;
    }

    public void onSearch(String searchString) {
        if(searchString != null && !searchString.isEmpty()){
            mSearchView.showProgressBar();
            mSearchView.hideKeyboard();
            mSearchRepository.search(searchString, this);
        }
    }

    @Override
    public void onSearchSuccess(SearchResultDto result) {
        if(result != null && result.getSongs().size() > 0){
            mViewModel.createDisplayableResults(result);
            mSearchView.showResults();
        } else {
            mSearchView.showNoResultsMessage();
        }
    }

    @Override
    public void onAddSongSuccess(SongDto addedSong) {

    }

    public void present() {
        if(mViewModel != null){
            if(mViewModel.getItems().size() > 0) {
                mSearchView.showResults();
            } else {
                mSearchView.showInfoMessage();
            }
        } else {
            mSearchView.showInfoMessage();
        }
    }

    public void onAddSongToMyList(int position) {
        SongDto selectedSong = mViewModel.selectSong(position);
        mSearchRepository.addSongToMyList(selectedSong, this);
        mSearchView.updateResults();
    }
}
