package com.samiamharris.olleyvotto;

import android.support.v4.app.Fragment;

/**
 * this branch is a simple single frag setup that can be used to reference
 * the simple architecture
 */

public class BoxOfficeActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new BoxOfficeFragment();
    }
}

