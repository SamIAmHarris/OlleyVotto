package com.samiamharris.olleyvotto;

import org.json.JSONObject;

/**
 * Created by SamMyxer on 6/30/14.
 */
public class UpcomingMovieReceivedEvent {


    public JSONObject upcoming;

    public UpcomingMovieReceivedEvent(JSONObject upcoming){
        this.upcoming = upcoming;
    }
}
