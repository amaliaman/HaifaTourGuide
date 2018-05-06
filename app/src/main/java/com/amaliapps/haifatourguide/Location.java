package com.amaliapps.haifatourguide;

import android.support.annotation.NonNull;

import java.util.ArrayList;

public class Location implements Comparable<Location> {
    private String mTitle;
    private int mImageId;
    private String mDescription;
    private int mCategoryId;
    private String mAddress;
    private String mSource;
    private String mPhone;
    private String mUrl;
    private int mId;

    private static ArrayList<Location> mLocations = new ArrayList<>();

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

    Location(int categoryId, String title, int imageId, String description, String address,
             String source, String phone) {
        this.mTitle = title;
        this.mImageId = imageId;
        this.mDescription = description;
        this.mCategoryId = categoryId;
        this.mAddress = address;
        this.mSource = source;
        this.mPhone = phone;

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

    public int getId() {
        return mLocations.indexOf(this);
    }

    public static ArrayList<Location> getLocations() {
        return mLocations;
    }

    public static Location getLocatinById(int id) {
        return mLocations.get(id);
    }

    @Override
    public int compareTo(@NonNull Location o) {
        return this.mTitle.compareTo(o.getTitle());
    }
}
