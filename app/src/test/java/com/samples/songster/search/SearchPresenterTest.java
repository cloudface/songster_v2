package com.samples.songster.search;

import com.samples.songster.search.repository.SearchRepository;
import com.samples.songster.search.repository.dto.SearchResultDto;
import com.samples.songster.search.repository.dto.SongDto;

import org.junit.Test;

import java.util.ArrayList;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by chrisbraunschweiler1 on 02/11/15.
 */
public class SearchPresenterTest {

    @Test
    public void testPresent_when_noItems_then_showInfoMessage() {
        SearchView mockView = mock(SearchView.class);
        SearchPresenter testee = new SearchPresenter(mock(ViewModel.class), mock(SearchRepository.class), mockView);

        testee.present();

        verify(mockView).showInfoMessage();
    }

    @Test
    public void testOnSearch_when_noSearchString_then_dontSearch() {
        SearchRepository mockRepository = mock(SearchRepository.class);
        SearchPresenter testee = new SearchPresenter(mock(ViewModel.class), mockRepository, mock(SearchView.class));

        testee.onSearch("");

        verify(mockRepository, never()).search(anyString(), any(SearchRepository.SearchListener.class));
    }

    @Test
    public void testOnSearch_when_searchString_then_search() {
        String searchString = "Some string";
        SearchRepository mockRepository = mock(SearchRepository.class);
        SearchPresenter testee = new SearchPresenter(mock(ViewModel.class), mockRepository, mock(SearchView.class));

        testee.onSearch(searchString);

        verify(mockRepository).search(eq(searchString), any(SearchRepository.SearchListener.class));
    }

    @Test
    public void testOnSearch_when_searchString_then_showProgressBar() {
        SearchView mockView = mock(SearchView.class);
        SearchPresenter testee = new SearchPresenter(mock(ViewModel.class), mock(SearchRepository.class), mockView);

        testee.onSearch("Some string");

        verify(mockView).showProgressBar();
    }

    @Test
    public void testOnSearch_when_searchString_then_hideKeyboard() {
        SearchView mockView = mock(SearchView.class);
        SearchPresenter testee = new SearchPresenter(mock(ViewModel.class), mock(SearchRepository.class), mockView);

        testee.onSearch("Some string");

        verify(mockView).hideKeyboard();
    }

    @Test
    public void testOnSearchSuccess_when_noResults_then_showNoResultsMessage() {
        SearchView mockView = mock(SearchView.class);
        SearchPresenter testee = new SearchPresenter(mock(ViewModel.class), mock(SearchRepository.class), mockView);

        testee.onSearchSuccess(new SearchResultDto());

        verify(mockView).showNoResultsMessage();
    }

    @Test
    public void testOnSearchSuccess_when_results_then_createDisplayableResults() {
        SearchResultDto result = new SearchResultDto();
        result.getSongs().add(new SongDto());
        ViewModel mockViewModel = mock(ViewModel.class);
        SearchPresenter testee = new SearchPresenter(mockViewModel, mock(SearchRepository.class), mock(SearchView.class));

        testee.onSearchSuccess(result);

        verify(mockViewModel).createDisplayableResults(result);
    }

    @Test
    public void testOnSearchSuccess_when_results_then_showResults() {
        SearchResultDto result = new SearchResultDto();
        result.getSongs().add(new SongDto());
        SearchView mockView = mock(SearchView.class);
        SearchPresenter testee = new SearchPresenter(mock(ViewModel.class), mock(SearchRepository.class), mockView);

        testee.onSearchSuccess(result);

        verify(mockView).showResults();
    }

    @Test
    public void testOnAddSongToMyList_then_selectSong(){
        int selectedPosition = 2;
        ViewModel mockViewModel = mock(ViewModel.class);
        SearchRepository mockRepository = mock(SearchRepository.class);
        SearchPresenter testee = new SearchPresenter(mockViewModel, mockRepository, mock(SearchView.class));

        testee.onAddSongToMyList(selectedPosition);

        verify(mockViewModel).selectSong(selectedPosition);
    }

    @Test
    public void testOnAddSongToMyList_then_addSelectedSong(){
        int selectedPosition = 2;
        SongDto selectedSong = new SongDto();
        ViewModel mockViewModel = mock(ViewModel.class);
        SearchRepository mockRepository = mock(SearchRepository.class);
        when(mockViewModel.selectSong(selectedPosition)).thenReturn(selectedSong);
        SearchPresenter testee = new SearchPresenter(mockViewModel, mockRepository, mock(SearchView.class));

        testee.onAddSongToMyList(selectedPosition);

        verify(mockRepository).addSongToMyList(eq(selectedSong), any(SearchRepository.SearchListener.class));
    }

    //TODO testOnAddSongToMyList_then_markSelectedSongAsBeingAdded
}