package com.samiamharris.olleyvotto;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;

/**
 * Created by SamMyxer on 6/29/14.
 */
public class BoxOfficeMoviesAdapter extends ArrayAdapter<BoxOfficeMovie> {


    public BoxOfficeMoviesAdapter(Context context, ArrayList<BoxOfficeMovie> aMovies) {
        super(context, 0, aMovies);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //TODO: complete the definition of the view for each movie

        String NA = "N/A";
        //get the data item for this position
        BoxOfficeMovie movie = getItem(position);
        //Check if an existing view is being reused, otherwise inflate the view
        if(convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_box_office_movie, parent, false);
        }

        //Lookup views within the item layout
        TextView tvTitle = (TextView) convertView.findViewById(R.id.tvTitle);
        TextView tvCriticsScore = (TextView) convertView.findViewById(R.id.tvCriticsScore);
        TextView tvCast = (TextView) convertView.findViewById(R.id.tvCast);
        ImageView ivPosterImage = (ImageView) convertView.findViewById(R.id.ivPosterImage);
        //populate the data into the template view using the data object
        tvTitle.setText(movie.getTitle());
        if (movie.getCriticsScore() == -1) {
            tvCriticsScore.setText(NA);
        } else {
            tvCriticsScore.setText(movie.getCriticsScore() + "%");

        }
        tvCast.setText(movie.getCastList());
        Picasso.with(getContext()).load(movie.getPosterUrl()).resize(135, 200).into(ivPosterImage);
        //Return the completed view to render on screen

        return convertView;
    }
}
