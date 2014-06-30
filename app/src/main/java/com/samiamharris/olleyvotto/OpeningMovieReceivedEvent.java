package com.samiamharris.olleyvotto;

import org.json.JSONObject;


/**
 * Created by SamMyxer on 6/30/14.
 */
public class OpeningMovieReceivedEvent {

    public JSONObject opening;

    public OpeningMovieReceivedEvent(JSONObject opening){
        this.opening = opening;
    }
}
