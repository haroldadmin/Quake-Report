package com.example.android.quakereport;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.text.DecimalFormat;
import android.graphics.drawable.GradientDrawable;

import java.util.ArrayList;

/**
 * Created by kshitijchauhan on 22/03/18.
 */

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {

    private String mCity;
    private String mArea;
    private String mPlace;
    private DecimalFormat mDecimalFormatter = new DecimalFormat("0.0");

    public EarthquakeAdapter(Context context, ArrayList<Earthquake> earthquakes) {
        super(context, 0, earthquakes);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }
        Earthquake earthquake = getItem(position);

        mPlace = earthquake.getPlace();
        int i = mPlace.indexOf(" of ");
        if (i!=-1) {
            mArea = mPlace.substring(0, i+4);
            mCity = mPlace.substring(i+4, mPlace.length() - 1);
        }
        else {
            mArea = "Near the";
            mCity = mPlace;
        }

        TextView mMagnitudeView = (TextView) listItemView.findViewById(R.id.magnitude);
        TextView mAreaView = (TextView) listItemView.findViewById(R.id.location_offset);
        TextView mCityView = (TextView) listItemView.findViewById(R.id.primary_location);
        TextView mDateView = (TextView) listItemView.findViewById(R.id.date);
        TextView mTimeView = (TextView) listItemView.findViewById(R.id.time);

        GradientDrawable magnitudeCircle = (GradientDrawable) mMagnitudeView.getBackground();
        int magnitudeColor =  ContextCompat.getColor(getContext(), getMagnitudeColor(Double.parseDouble(earthquake.getMagnitude())));
        magnitudeCircle.setColor(magnitudeColor);

        mMagnitudeView.setText(mDecimalFormatter.format(Double.parseDouble(earthquake.getMagnitude())));
        mAreaView.setText(mArea);
        mCityView.setText(mCity);
        mDateView.setText(earthquake.getDate());
        mTimeView.setText(earthquake.getTime().toString());

        return listItemView;
    }

    private int getMagnitudeColor(double magnitude) {
        int magnitudeColorResourceId;
        int mag = (int) Math.floor(magnitude);
        switch(mag)
        {
            case 1:
                magnitudeColorResourceId = R.color.magnitude1;
                break;
            case 2:
                magnitudeColorResourceId = R.color.magnitude2;
                break;
            case 3:
                magnitudeColorResourceId = R.color.magnitude3;
                break;
            case 4:
                magnitudeColorResourceId = R.color.magnitude4;
                break;
            case 5:
                magnitudeColorResourceId = R.color.magnitude5;
                break;
            case 6:
                magnitudeColorResourceId = R.color.magnitude6;
                break;
            case 7:
                magnitudeColorResourceId = R.color.magnitude7;
                break;
            case 8:
                magnitudeColorResourceId = R.color.magnitude8;
                break;
            case 9:
                magnitudeColorResourceId = R.color.magnitude9;
                break;
            default:
                magnitudeColorResourceId = R.color.magnitude10plus;
                break;
        }
        return magnitudeColorResourceId;
    }
}
