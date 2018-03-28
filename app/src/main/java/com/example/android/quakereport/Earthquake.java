package com.example.android.quakereport;

/**
 * Created by kshitijchauhan on 22/03/18.
 */

public class Earthquake {

    private String mMagnitude;
    private String mPlace;
    private String mTime;
    private String mDate;
    private String mUrl;

    public Earthquake(String magnitude, String place, String time, String date, String url)
    {
        mMagnitude = magnitude;
        mPlace = place;
        mTime = time;
        mDate = date;
        mUrl = url;
    }

    public String getMagnitude() {
        return mMagnitude;
    }

    public String getPlace() {
        return mPlace;
    }

    public String getTime() {
        return mTime;
    }

    public String getDate() {
        return mDate;
    }

    public String getUrl() {
        return mUrl;
    }
}
