package com.samiamharris.olleyvotto;

import com.squareup.otto.Bus;

/**
 * Created by SamMyxer on 6/30/14.
 */
public class BusProvider {

    private static MainThreadBus BUS;

    private BusProvider() {};

    public static Bus getInstance() {

        if(BUS == null) {
            BUS = new MainThreadBus(new Bus());
        }
        return BUS;
    }
}
