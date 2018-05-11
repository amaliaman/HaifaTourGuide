package com.amaliapps.haifatourguide;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.Date;

public class Location implements Comparable<Location> {
    private String mTitle;
    private int mImageId;
    private String mDescription;
    private int mCategoryId;
    private String mAddress;
    private String mSource;
    private String mPhone;
    private String mUrl;
    private Date mStartDate;
    private Date mEndDate;

    private static ArrayList<Location> mLocations = new ArrayList<>();

    // Constructor without dates (non-events)
    Location(int categoryId, String title, int imageId, String description, String address,
             String source, String phone, String url) {
        this.mTitle = title;
        this.mImageId = imageId;
        this.mDescription = description;
        this.mCategoryId = categoryId;
        this.mAddress = address;
        this.mSource = source;
        this.mPhone = phone;
        this.mUrl = url;

        mLocations.add(this);
    }

    // Constructor with dates (events)
    Location(int categoryId, String title, int imageId, String description, String address,
             String source, String phone, String url, Date startDate, Date endDate) {
        this.mTitle = title;
        this.mImageId = imageId;
        this.mDescription = description;
        this.mCategoryId = categoryId;
        this.mAddress = address;
        this.mSource = source;
        this.mPhone = phone;
        this.mUrl = url;
        this.mStartDate = startDate;
        this.mEndDate = endDate;

        mLocations.add(this);
    }

    public String getAddress() {
        return mAddress;
    }

    public String getPhone() {
        return mPhone;
    }

    public String getSource() {
        return mSource;
    }

    public String getTitle() {
        return mTitle;
    }

    public int getImageId() {
        return mImageId;
    }

    public String getDescription() {
        return mDescription;
    }

    public int getCategoryId() {
        return mCategoryId;
    }

    public String getUrl() {
        return mUrl;
    }

    public Date getStartDate() {
        return mStartDate;
    }

    public Date getEndDate() {
        return mEndDate;
    }

    public int getIndex() {
        return mLocations.indexOf(this);
    }

    public static ArrayList<Location> getLocations() {
        return mLocations;
    }

    /**
     * Get a location by its index
     * @param index index in the list
     * @return the location
     */
    public static Location getLocationByIndex(int index) {
        return mLocations.get(index);
    }

    @Override
    public int compareTo(@NonNull Location o) {
        return this.mTitle.compareTo(o.getTitle());
    }
}
