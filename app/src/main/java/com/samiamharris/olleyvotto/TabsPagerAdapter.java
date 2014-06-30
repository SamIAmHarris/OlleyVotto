package com.samiamharris.olleyvotto;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

/**
 * Created by SamMyxer on 6/30/14.
 */
public class TabsPagerAdapter extends FragmentPagerAdapter {

    public TabsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new BoxOfficeFragment();
            case 1:
                return new OpeningMovieFragment();
            case 2:
                return new UpcomingMovieFragment();
        }

        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
