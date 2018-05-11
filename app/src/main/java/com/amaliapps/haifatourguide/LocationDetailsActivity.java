package com.amaliapps.haifatourguide;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class LocationDetailsActivity extends AppCompatActivity {
    TextView titleTextView;
    TextView titleNoImageTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_details);

        // Get location id from intent
        int locationId = getIntent().getIntExtra(Constants.INTENT_EXTRA_ID, 0);
        final Location location = Location.getLocationByIndex(locationId);

        setTitle(location.getTitle());

        // Set the current location's thumbnail
        ImageView thumb = findViewById(R.id.location_thumbnail);
        if (location.getImageId() > 0) {
            thumb.setImageResource(location.getImageId());
            thumb.setVisibility(View.VISIBLE);
            // Set the current location's title
            titleTextView = findViewById(R.id.location_title);
            titleTextView.setText(location.getTitle());
            titleTextView.setVisibility(View.VISIBLE);
        } else {
            // Set the current location's title
            titleNoImageTextView = findViewById(R.id.location_no_image_title);
            titleNoImageTextView.setText(location.getTitle());
            titleNoImageTextView.setVisibility(View.VISIBLE);
        }


        // Set the current location's address + link to map
        TextView addressTextView = findViewById(R.id.location_address);
        addressTextView.setText(Html.fromHtml("<a href='#'>" + location.getAddress() + "</a>"));
        addressTextView.setMovementMethod(LinkMovementMethod.getInstance());
        addressTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent geoIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(String.format("%s%s",
                        getString(R.string.geo_intent), location.getAddress())));
                startActivity(geoIntent);
            }
        });

        // Set the current location's phone
        TextView phoneTextView = findViewById(R.id.location_phone);
        if (location.getPhone() != null) {
            phoneTextView.setText(location.getPhone());
            phoneTextView.setVisibility(View.VISIBLE);
        }

        // Set the current location's url
        TextView urlTextView = findViewById(R.id.location_url);
        if (location.getUrl() != null) {
            urlTextView.setText(location.getUrl());
            urlTextView.setVisibility(View.VISIBLE);
        }

        // Set the current location's dates (for events)
        TextView eventTextView = findViewById(R.id.location_dates);
        if (location.getStartDate() != null) {
            eventTextView.setText(String.format("%s - %s", getStringFromDate(location.getStartDate()),
                    getStringFromDate(location.getEndDate())));
            eventTextView.setVisibility(View.VISIBLE);
        }

        // Set the current location's description
        TextView descriptionTextView = findViewById(R.id.location_description);
        descriptionTextView.setText(location.getDescription());

        // Set the current location's source
        TextView sourceTextView = findViewById(R.id.location_source);
        sourceTextView.setText(String.format("%s %s", getString(R.string.source), location.getSource()));
    }

    private String getStringFromDate(Date startDate) {
        DateFormat dateFormatter = DateFormat.getDateInstance(DateFormat.DEFAULT, Locale.getDefault());
        return dateFormatter.format(startDate);
    }
}

