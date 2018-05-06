package com.amaliapps.haifatourguide;

import android.content.Context;

public class Initializer {

    private static final int MUSEUMS_CATEGORY_ID = 1;
    private static final int LANDMARKS_CATEGORY_ID = 2;
    private static final int RESTAURANTS_CATEGORY_ID = 3;
    private static final int EVENTS_CATEGORY_ID = 4;

    public static boolean isInitialized = false;

    public static void initializeData(Context context) {
        // Create categories
        Category cat1 = new Category("Landmarks", LANDMARKS_CATEGORY_ID);
        Category cat2 = new Category("Restaurants", RESTAURANTS_CATEGORY_ID);
        Category cat3 = new Category("Museums", MUSEUMS_CATEGORY_ID);
        Category cat4 = new Category("Events", EVENTS_CATEGORY_ID);

        // Create locations
        Location loc1 = new Location(LANDMARKS_CATEGORY_ID, context.getString(R.string.bahai_title),
                R.drawable.bahai, context.getString(R.string.bahai_description), context.getString(R.string.bahai_address),
                context.getString(R.string.bahai_source), context.getString(R.string.bahai_phone), context.getString(R.string.bahai_url));
        Location loc2 = new Location(LANDMARKS_CATEGORY_ID, context.getString(R.string.carmelite_title),
                R.drawable.carmelite, context.getString(R.string.carmelite_description),
                context.getString(R.string.carmelite_address), context.getString(R.string.carmelite_source), context.getString(R.string.carmelite_phone));

        isInitialized = true;
    }
}