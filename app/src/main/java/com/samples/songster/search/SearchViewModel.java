package com.samples.songster.search;

import com.samples.songster.search.repository.dto.SearchResultDto;
import com.samples.songster.search.repository.dto.SongDto;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chrisbraunschweiler1 on 04/11/15.
 */
public class SearchViewModel implements ViewModel {

    private List<SearchItemModel> mItems;

    public SearchViewModel() {
        mItems = new ArrayList<>();
    }

    @Override
    public void createDisplayableResults(SearchResultDto result) {
        addHeaderItem();
        addSearchResults(result);
    }

    private void addHeaderItem() {
        SearchItemModel headerItem = new SearchItemModel();
        headerItem.setType(SearchItemModel.ItemType.HEADER);
        mItems.add(headerItem);
    }

    private void addSearchResults(SearchResultDto result) {
        for (SongDto songDto : result.getSongs()) {
            SearchItemModel resultItem = new SearchItemModel();
            resultItem.setType(SearchItemModel.ItemType.RESULT);
            resultItem.setSong(songDto);
            mItems.add(resultItem);
        }
    }

    public List<SearchItemModel> getItems() {
        return mItems;
    }

    @Override
    public SongDto selectSong(int position) {
        SongDto selectedSong = null;
        int index = 0;
        for (SearchItemModel searchItem : mItems) {
            if (index == position) {
                if (searchItem.getSong() != null) {
                    selectedSong = searchItem.getSong();
                    searchItem.setAdded(true);
                }
            }
            index++;
        }
        return selectedSong;
    }
}

class SearchItemModel {

    private SongDto mSong;
    private ItemType mType;
    private boolean mAdded;

    public SongDto getSong() {
        return mSong;
    }

    public void setSong(SongDto song) {
        this.mSong = song;
    }

    public ItemType getType() {
        return mType;
    }

    public void setType(ItemType type) {
        this.mType = type;
    }

    public boolean isAdded() {
        return mAdded;
    }

    public void setAdded(boolean added) {
        this.mAdded = added;
    }

    public enum ItemType {
        HEADER,
        RESULT
    }
}
