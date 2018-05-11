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

    public int getId() {
        return mId;
    }

    /**
     * Get all created categories
     *
     * @return a list of all created categories
     */
    public static ArrayList<Category> getCategories() {
        return mCategories;
    }

    /**
     * Get locations for a given Category
     *
     * @param categoryId the requested category
     * @return a list of locations for a given Category
     */
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