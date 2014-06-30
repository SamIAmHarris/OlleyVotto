package com.samiamharris.olleyvotto;

import android.text.TextUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by SamMyxer on 6/29/14.
 */
public class BoxOfficeMovie {

    private String title;
    private int year;
    private String synopsis;
    private String posterUrl;
    private int criticsScore;
    private ArrayList<String> castList;

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public String getPosterUrl() {
        return posterUrl;
    }

    public int getCriticsScore() {
        return criticsScore;
    }

    public String getCastList() {
        return TextUtils.join(", ", castList);
    }

    //Returns a BoxOfficeMovie given the expected JSON
    //BoxOfficeMovie.fromJson(movieJsonDictionary)
    //Stores the title, year, synopsis, poster, and criticsScore
    public static BoxOfficeMovie fromJson(JSONObject jsonObject) {
        BoxOfficeMovie b = new BoxOfficeMovie();

        try {
            //Deserialize json into object fields
            b.title = jsonObject.getString("title");
            b.year = jsonObject.getInt("year");
            b.synopsis = jsonObject.getString("synopsis");
            b.posterUrl = jsonObject.getJSONObject("posters").getString("profile");
            b.criticsScore = jsonObject.getJSONObject("ratings").getInt("critics_score");
            //Construct simple array of cast names
            b.castList = new ArrayList<String>();
            JSONArray abridgedCast = jsonObject.getJSONArray("abridged_cast");
            for (int i = 0; i < abridgedCast.length(); i++) {
                b.castList.add(abridgedCast.getJSONObject(i).getString("name"));
            }
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
        return b;
    }

    //Decodes array of box office movie json results into business model objects
    //BoxOfficeMovie.fromJson(jsonArrayOfMovies)
    public static ArrayList<BoxOfficeMovie> fromJson(JSONArray jsonArray) {

        ArrayList<BoxOfficeMovie> businesses = new ArrayList<BoxOfficeMovie>(jsonArray.length());

        //process each result in json array, decode and convert to business object
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject businessJson = null;
            try{
                businessJson = jsonArray.getJSONObject(i);
            } catch (JSONException e) {
                e.printStackTrace();
                continue;
            }
            BoxOfficeMovie business = BoxOfficeMovie.fromJson(businessJson);
            if(business != null) {
                businesses.add(business);
            }
        }

        return businesses;
    }
}
