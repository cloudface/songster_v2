package com.samples.songster.details;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.samples.songster.R;

/**
 * Created by chrisbraunschweiler1 on 09/11/15.
 */
public class SongDetailsFragment extends Fragment {

    public static SongDetailsFragment getInstance() {
        SongDetailsFragment fragment = new SongDetailsFragment();
        Bundle args = new Bundle();
        //TODO pass arguments into bundle
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle args) {
        super.onCreate(args);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_song_details, container, false);
        return view;
    }
}
