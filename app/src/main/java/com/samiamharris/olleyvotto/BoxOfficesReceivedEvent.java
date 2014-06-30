package com.samiamharris.olleyvotto;

import org.json.JSONObject;

/**
 * Created by SamMyxer on 6/30/14.
 */
public class BoxOfficesReceivedEvent {

    public JSONObject boxOffices;

    public BoxOfficesReceivedEvent(JSONObject boxOffices){
        this.boxOffices = boxOffices;
    }
}
