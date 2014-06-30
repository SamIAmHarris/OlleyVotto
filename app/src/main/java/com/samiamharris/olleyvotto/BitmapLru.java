package com.samiamharris.olleyvotto;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.os.Build;
import android.util.LruCache;

import com.android.volley.toolbox.ImageLoader;

/**
 * Created by SamMyxer on 6/29/14.
 */
@TargetApi(Build.VERSION_CODES.HONEYCOMB_MR1)
public class BitmapLru extends LruCache<String, Bitmap> implements ImageLoader.ImageCache {


    /**
     * @param maxSize for caches that do not override {@link #sizeOf}, this is
     *                the maximum number of entries in the cache. For all other caches,
     *                this is the maximum sum of the sizes of the entries in this cache.
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR1)
    public BitmapLru(int maxSize) {
        super(maxSize);
    }

    @Override
    public Bitmap getBitmap(String url) {
        return get(url);
    }

    @Override
    public void putBitmap(String url, Bitmap bitmap) {
        put(url, bitmap);

    }


}
