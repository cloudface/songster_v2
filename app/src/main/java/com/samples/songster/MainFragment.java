package com.samples.songster;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by chrisbraunschweiler1 on 11/11/15.
 */
public class MainFragment extends Fragment {

    private ViewPager mViewPager;

    public static MainFragment getInstance() {
        MainFragment fragment = new MainFragment();
        Bundle args = new Bundle();
        //TODO pass arguments into bundle
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle args) {
        super.onCreate(args);
        //TODO retrieve arguments from bundle

    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        mViewPager = (ViewPager) view.findViewById(R.id.viewPager);
        mViewPager.setAdapter(new MainPagerAdapter(getChildFragmentManager()));
        return view;
    }

}
