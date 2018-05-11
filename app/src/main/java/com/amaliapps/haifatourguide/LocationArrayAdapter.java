package com.amaliapps.haifatourguide;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class LocationArrayAdapter extends ArrayAdapter<Location> {

    LocationArrayAdapter(@NonNull Activity context, ArrayList<Location> locations) {
        super(context, 0, locations);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }
        // Get the {@link Location} object located at this position in the list
        final Location currentLocation = getItem(position);

        if (currentLocation != null) {
            // Set the current location's thumbnail
            ImageView thumb = listItemView.findViewById(R.id.location_thumbnail);
            if (currentLocation.getImageId() > 0) {
                thumb.setImageResource(currentLocation.getImageId());
                thumb.setVisibility(View.VISIBLE);
            }

            // Set the current location's title
            TextView titleTextView = listItemView.findViewById(R.id.location_title);
            titleTextView.setText(currentLocation.getTitle());

            // Set the current location's address + link to geo activity
            TextView addressTextView = listItemView.findViewById(R.id.location_address);
            addressTextView.setText(currentLocation.getAddress());
            addressTextView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent geoIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(String.format("%s%s",
                            getContext().getString(R.string.geo_intent), currentLocation.getAddress())));
                    getContext().startActivity(geoIntent);
                }
            });
        }

        return listItemView;
    }
}
