package com.amaliapps.haifatourguide;

import java.util.ArrayList;
import java.util.Collections;

public class Category {

    private int mId;
    private String mTitle;
    private static ArrayList<Category> mCategories = new ArrayList<>();

    Category(String title, int id) {
        this.mTitle = title;
        this.mId = id;
        mCategories.add(this);
    }

    public String getTitle() {
        return mTitle;
    }

    public static ArrayList<Category> getCategories() {
        return mCategories;
    }

    public int getId() {
        return mId;
    }

    public static ArrayList<Location> getLocationsByCategory(int categoryId) {
        ArrayList<Location> locations = new ArrayList<>();
        for (Location location : Location.getLocations()) {
            if (location.getCategoryId() == categoryId) {
                locations.add(location);
            }
        }
        Collections.sort(locations);
        return locations;
    }
}