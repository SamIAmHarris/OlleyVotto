package com.samiamharris.olleyvotto;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


/**
 * Created by SamMyxer on 6/29/14.
 * Should have methods in here that create requests and add them to universal queue
 */
public class ApiController {

    private static ApiController controller;

    private final String API_KEY = "wpkdap6wgwhdckwwenje5gvw";
    private final String API_BASE_URL = "http://api.rottentomatoes.com/api/public/v1.0/";

    //Need to look into this here
    public BoxOfficeFragment boxOfficeFragment = new BoxOfficeFragment();
    /**
     * @return instance of singleton MXRApiController object
     */
    public static ApiController getInstance() {

        if(controller == null) {
            controller = new ApiController();
        }
        return controller;
    }

    private String getApiUrl(String relativeUrl) {
        return API_BASE_URL + relativeUrl;
    }


    public void fetchBoxOfficeMoves() {

        // http://api.rottentomatoes.com/api/public/v1.0/lists/movies/box_office.json?apikey=<key>
        String url = getApiUrl("lists/movies/box_office.json?apikey=" + API_KEY);

        JsonObjectRequest request = new JsonObjectRequest(url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                BusProvider.getInstance().post(new BoxOfficesReceivedEvent(response));
//                JSONArray items = null;
//                try{
//                    //get the movies json array
//                    items = response.getJSONArray("movies");
//                    //Parse json array into array of model objects
//                    ArrayList<BoxOfficeMovie> movies = BoxOfficeMovie.fromJson(items);
//                    //Load model objects into the adapter
//                    for(BoxOfficeMovie movie : movies) {
//                        boxOfficeFragment.getAdapterMovies().add(movie);
//                    }
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        BoxOfficeApplication.getInstance().addToRequestQueue(request);
    }


}

