package com.amaliapps.haifatourguide;

import android.content.Context;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Initializer {

    private static final int MUSEUMS_CATEGORY_ID = 1;
    private static final int LANDMARKS_CATEGORY_ID = 2;
    private static final int RESTAURANTS_CATEGORY_ID = 3;
    private static final int EVENTS_CATEGORY_ID = 4;

    public static boolean isInitialized = false;

    public static void initializeData(Context context) throws ParseException {
        // Create categories
        Category cat1 = new Category(context.getString(R.string.landmarks_label), LANDMARKS_CATEGORY_ID);
        Category cat2 = new Category(context.getString(R.string.restaurants_label), RESTAURANTS_CATEGORY_ID);
        Category cat3 = new Category(context.getString(R.string.museums_label), MUSEUMS_CATEGORY_ID);
        Category cat4 = new Category(context.getString(R.string.events_label), EVENTS_CATEGORY_ID);

        // Create locations
        Location loc1 = new Location(LANDMARKS_CATEGORY_ID, context.getString(R.string.bahai_title),
                R.drawable.bahai, context.getString(R.string.bahai_description), context.getString(R.string.bahai_address),
                context.getString(R.string.bahai_source), context.getString(R.string.bahai_phone),
                context.getString(R.string.bahai_url));

        Location loc2 = new Location(LANDMARKS_CATEGORY_ID, context.getString(R.string.carmelite_title),
                R.drawable.carmelite, context.getString(R.string.carmelite_description),
                context.getString(R.string.carmelite_address), context.getString(R.string.carmelite_source),
                context.getString(R.string.carmelite_phone), null);

        Location loc3 = new Location(MUSEUMS_CATEGORY_ID, context.getString(R.string.tikotin_title),
                R.drawable.tikotin, context.getString(R.string.tikotin_description),
                context.getString(R.string.tikotin_address), context.getString(R.string.tikotin_source),
                context.getString(R.string.tikotin_phone), context.getString(R.string.tikotin_url));

        Location loc4 = new Location(RESTAURANTS_CATEGORY_ID, context.getString(R.string.vivino_title),
                R.drawable.vivino, context.getString(R.string.vivino_description), context.getString(R.string.vivino_address),
                context.getString(R.string.vivino_source), context.getString(R.string.vivino_phone),
                context.getString(R.string.vivino_url));

        Location loc5 = new Location(MUSEUMS_CATEGORY_ID, context.getString(R.string.art_title), R.drawable.art,
                context.getString(R.string.art_description), context.getString(R.string.art_address),
                context.getString(R.string.art_source), context.getString(R.string.art_phone),
                context.getString(R.string.art_url));

        Location loc6 = new Location(MUSEUMS_CATEGORY_ID, context.getString(R.string.maritime_title), R.drawable.maritime,
                context.getString(R.string.maritime_description), context.getString(R.string.maritime_address),
                context.getString(R.string.maritime_source), context.getString(R.string.maritime_phone),
                context.getString(R.string.maritime_url));

        Location loc7 = new Location(MUSEUMS_CATEGORY_ID, context.getString(R.string.city_title), R.drawable.city,
                context.getString(R.string.city_description), context.getString(R.string.city_address),
                context.getString(R.string.city_source), context.getString(R.string.city_phone),
                context.getString(R.string.city_url));

        Location loc8 = new Location(MUSEUMS_CATEGORY_ID, context.getString(R.string.mane_title), R.drawable.mane,
                context.getString(R.string.mane_description), context.getString(R.string.mane_address),
                context.getString(R.string.mane_source), context.getString(R.string.mane_phone),
                context.getString(R.string.mane_url));

        Location loc9 = new Location(MUSEUMS_CATEGORY_ID, context.getString(R.string.struck_title), R.drawable.struck,
                context.getString(R.string.struck_description), context.getString(R.string.struck_address),
                context.getString(R.string.struck_source), context.getString(R.string.struck_phone),
                context.getString(R.string.struck_url));

        Location loc10 = new Location(RESTAURANTS_CATEGORY_ID, context.getString(R.string.hanamal_title), R.drawable.hanamal,
                context.getString(R.string.hanamal_description), context.getString(R.string.hanamal_address),
                context.getString(R.string.hanamal_source), context.getString(R.string.hanamal_phone),
                context.getString(R.string.hanamal_url));

        Location loc11 = new Location(RESTAURANTS_CATEGORY_ID, context.getString(R.string.libira_title), R.drawable.libira,
                context.getString(R.string.libira_description), context.getString(R.string.libira_address),
                context.getString(R.string.libira_source), context.getString(R.string.libira_phone),
                context.getString(R.string.libira_url));

        Location loc12 = new Location(RESTAURANTS_CATEGORY_ID, context.getString(R.string.wadi_title), R.drawable.wadi,
                context.getString(R.string.wadi_description), context.getString(R.string.wadi_address),
                context.getString(R.string.wadi_source), context.getString(R.string.wadi_phone),
                context.getString(R.string.wadi_url));

        Location loc13 = new Location(LANDMARKS_CATEGORY_ID, context.getString(R.string.german_title), R.drawable.german,
                context.getString(R.string.german_description), context.getString(R.string.german_address),
                context.getString(R.string.german_source), null, null);

        Location loc14 = new Location(LANDMARKS_CATEGORY_ID, context.getString(R.string.louis_title), R.drawable.louis,
                context.getString(R.string.louis_description), context.getString(R.string.louis_address),
                context.getString(R.string.louis_source), null, null);

        Location loc15 = new Location(EVENTS_CATEGORY_ID, context.getString(R.string.film_title), -1,
                context.getString(R.string.film_description), context.getString(R.string.film_address),
                context.getString(R.string.film_source), context.getString(R.string.film_phone),
                context.getString(R.string.film_url), getDateFromString(context, context.getString(R.string.film_date_start)),
                getDateFromString(context, context.getString(R.string.film_date_end)));

        Location loc16 = new Location(EVENTS_CATEGORY_ID, context.getString(R.string.kids_title), -1,
                context.getString(R.string.kids_description), context.getString(R.string.film_address),
                context.getString(R.string.kids_source), context.getString(R.string.kids_phone),
                context.getString(R.string.kids_url), getDateFromString(context, context.getString(R.string.kids_date_start)),
                getDateFromString(context, context.getString(R.string.kids_date_end)));

        isInitialized = true;
    }

    private static Date getDateFromString(Context context, String dateString) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat(context.getString(R.string.date_pattern), Locale.getDefault());
        return format.parse(dateString);
    }
}