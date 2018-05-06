package com.amaliapps.haifatourguide;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class LocationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);

        // Get location id from intent
        int locationId = getIntent().getIntExtra(Constants.INTENT_EXTRA_ID, 0);
        final Location location = Location.getLocatinById(locationId);

        setTitle(location.getTitle());

        // Set the current location's thumbnail
        ImageView thumb = findViewById(R.id.location_thumbnail);
        thumb.setImageResource(location.getImageId());

        // Set the current location's title
        TextView titleTextView = findViewById(R.id.location_title);
        titleTextView.setText(location.getTitle());

        // Set the current location's address
        TextView addressTextView = findViewById(R.id.location_address);
        addressTextView.setText(location.getAddress());

        // Set the current location's phone
        TextView phoneTextView = findViewById(R.id.location_phone);
        phoneTextView.setText(location.getPhone());

        // Set the current location's url
        TextView urlTextView = findViewById(R.id.location_url);
        if (location.getUrl() != null) {
            urlTextView.setText(location.getUrl());
            urlTextView.setVisibility(View.VISIBLE);
        }

        // Set the current location's description
        TextView descriptionTextView = findViewById(R.id.location_description);
        descriptionTextView.setText(location.getDescription());

        // Set the current location's source
        TextView sourceTextView = findViewById(R.id.location_source);
        sourceTextView.setText(location.getSource());
    }
}

