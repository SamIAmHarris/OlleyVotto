package com.samiamharris.olleyvotto;

import android.os.Handler;
import android.os.Looper;

import com.squareup.otto.Bus;

/**
 * Created by SamMyxer on 6/30/14.
 * Otto bus that enforces bus messages posted on the main thread
 * Adapted from: http://stackoverflow.com/questions/15431768/how-to-send-event-from-service-to-activity-with-otto-event-bus
 */
public class MainThreadBus extends Bus {

    private final Bus mBus;
    private final Handler mHandler = new Handler(Looper.getMainLooper());

    public MainThreadBus(final Bus bus) {
        if (bus == null) {
            throw new NullPointerException("bus must not be null");
        }
        mBus = bus;
    }

    @Override public void register(Object obj) {
        mBus.register(obj);
    }

    @Override public void unregister(Object obj) {
        mBus.unregister(obj);
    }

    @Override public void post(final Object event) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            mBus.post(event);
        } else {
            mHandler.post(new Runnable() {
                @Override public void run() {
                    mBus.post(event);
                }
            });
        }
    }
}
