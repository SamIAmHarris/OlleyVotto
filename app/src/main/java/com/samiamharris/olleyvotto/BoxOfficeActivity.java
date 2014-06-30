package com.samiamharris.olleyvotto;

import android.support.v4.app.Fragment;

public class BoxOfficeActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new BoxOfficeFragment();
    }
}

