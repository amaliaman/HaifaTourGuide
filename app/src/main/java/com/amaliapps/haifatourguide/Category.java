package com.amaliapps.haifatourguide;

import java.util.ArrayList;

public class Category {
    private String mTitle;
    private static ArrayList<Category> mCategories = new ArrayList<>();

    Category(String title) {
        this.mTitle = title;
        mCategories.add(this);
    }

    public String getTitle() {
        return mTitle;
    }

    public static ArrayList<Category> getCategories() {
        return mCategories;
    }
}