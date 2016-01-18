package com.samples.songster.search;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.samples.songster.R;
import com.samples.songster.search.repository.dto.SongDto;

import java.util.List;

/**
 * Created by chrisbraunschweiler1 on 26/10/15.
 */
public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.ViewHolder> {

    private List<SearchItemModel> mItems;
    private SearchAdapterListener mListener;

    public SearchAdapter(List<SearchItemModel> songs, SearchAdapterListener listener){
        mItems = songs;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v;
        SearchItemModel.ItemType itemType = SearchItemModel.ItemType.values()[viewType];
        switch(itemType){
            case HEADER:
                v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_search_header, parent, false);
                break;
            default:
                v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_search_result, parent, false);
                break;
        }
        return new ViewHolder(v, mListener);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        SearchItemModel item = mItems.get(position);

        if(SearchItemModel.ItemType.RESULT == item.getType()) {
            SongDto song = item.getSong();
            holder.mSongNameText.setText(song.getName());
            holder.mArtistNameText.setText(song.getArtist());
            holder.mAlbumNameText.setText(song.getAlbum());
            holder.mCheckmark.setVisibility(View.GONE);
            if(item.isAdded()){
                holder.mCheckmark.setVisibility(View.VISIBLE);
            }
        }
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public int getItemViewType(int position){
        SearchItemModel item = mItems.get(position);
        return item.getType().ordinal();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView mSongNameText;
        private final TextView mArtistNameText;
        private final TextView mAlbumNameText;
        private final ImageView mCheckmark;
        private SearchAdapterListener mListener;

        public ViewHolder(View itemView, SearchAdapterListener listener) {
            super(itemView);
            mListener = listener;
            mSongNameText = (TextView) itemView.findViewById(R.id.songNameText);
            mArtistNameText = (TextView) itemView.findViewById(R.id.artistNameText);
            mAlbumNameText = (TextView) itemView.findViewById(R.id.albumNameText);
            mCheckmark = (ImageView) itemView.findViewById(R.id.checkmark);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mListener.onSelectedItem(getAdapterPosition());
                }
            });
        }
    }

    public interface SearchAdapterListener {

        void onSelectedItem(int position);
    }
}
