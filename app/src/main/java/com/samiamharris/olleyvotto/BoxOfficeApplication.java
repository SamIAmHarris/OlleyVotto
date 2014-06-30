package com.samiamharris.olleyvotto;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

/**
 * Created by SamMyxer on 6/29/14.
 * Top level Application
 */
public class BoxOfficeApplication extends Application {

    public static final String TAG = "VolleyPatterns";

    private static Context context;

    //Global Request Queue and ImageLoader for Volley
    private static RequestQueue requestQueue;
    private static ImageLoader imageLoader;

    private static BoxOfficeApplication appInstance;
    public BoxOfficeApplication(){
        this.appInstance = this;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        BoxOfficeApplication.context = getApplicationContext();
        imageLoader = new ImageLoader(requestQueue, new BitmapLru(64000));

    }

    public static BoxOfficeApplication getInstance(){
        return appInstance;
    }

    public static Context getAppContext(){
        return BoxOfficeApplication.context;
    }

    /**
     * Get ImageLoader instance, used for NetworkImageView.setImageUrl calls
     */
    public static ImageLoader getImageLoader() {
        return imageLoader;
    }

    public RequestQueue getRequestQueue() {

        //we create the request queue if it is null here
        //and then always return it
        if (requestQueue == null) {
            requestQueue = Volley.newRequestQueue(getApplicationContext());
        }

        return requestQueue;
    }


    //if you give it a tag it uses that tag instead of default tag as long
    //as the tag is not empty
    public <T> void addToRequestQueue(Request<T> req, String tag) {

        req.setTag(TextUtils.isEmpty(tag) ? TAG: tag);

        VolleyLog.d("Adding request to queue: %s", req.getUrl());

        getRequestQueue().add(req);
    }

    public <T> void addToRequestQueue(Request<T> req) {

        req.setTag(TAG);

        VolleyLog.d("Adding request to queue: %s", req.getUrl());

        getRequestQueue().add(req);
    }

    public void cancelPendingRequests(String tag) {

        if(requestQueue != null) {
            getRequestQueue().cancelAll(tag);
        }

    }

}

