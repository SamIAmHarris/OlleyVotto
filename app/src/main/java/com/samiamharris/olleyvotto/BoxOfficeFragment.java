package com.samiamharris.olleyvotto;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.squareup.otto.Subscribe;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

/**
 * Created by SamMyxer on 6/29/14.
 */
public class BoxOfficeFragment extends Fragment {


    private ListView lvMovies;
    private static BoxOfficeMoviesAdapter adapterMovies;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        BusProvider.getInstance().register(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_box_office, container, false);  //inflates the layout
        lvMovies = (ListView) v.findViewById(R.id.lvMovies);

        ArrayList<BoxOfficeMovie> aMovies = new ArrayList<BoxOfficeMovie>();
        adapterMovies = new BoxOfficeMoviesAdapter(getActivity(), aMovies);
        lvMovies.setAdapter(adapterMovies);

        return v;
    }

    @Override
    public void onResume() {
        super.onResume();
        ApiController.getInstance().fetchBoxOfficeMoves();

    }

    public BoxOfficeMoviesAdapter getAdapterMovies() {
        return this.adapterMovies;
    }

    @Subscribe
    public void onBoxOfficesReceived(BoxOfficesReceivedEvent event) {
        Toast.makeText(getActivity(), "Received Otto event", Toast.LENGTH_LONG).show();

        JSONArray items = null;
        try{
            Toast.makeText(getActivity(), "Received Otto event", Toast.LENGTH_LONG).show();
            //get the movies json array
            items = event.boxOffices.getJSONArray("movies");
            //Parse json array into array of model objects
            ArrayList<BoxOfficeMovie> movies = BoxOfficeMovie.fromJson(items);
            //Load model objects into the adapter
            for(BoxOfficeMovie movie : movies) {
                adapterMovies.add(movie);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        BusProvider.getInstance().unregister(this);
    }
}
