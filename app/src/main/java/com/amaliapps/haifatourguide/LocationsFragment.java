package com.amaliapps.haifatourguide;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class LocationsFragment extends Fragment {


    public LocationsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_locations, container, false);

        // Get locations for current category
        ArrayList<Location> locations = new ArrayList<>();
        if (getArguments() != null) {
            locations = Category.getLocationsByCategory(getArguments().getInt(Constants.BUNDLE_CATEGORY_ID));
        }

        LocationArrayAdapter itemsAdapter = new LocationArrayAdapter(getActivity(), locations);
        ListView listView = rootView.findViewById(R.id.list);
        if (listView != null) {
            // Attach array adapter to list view
            listView.setAdapter(itemsAdapter);

            // Navigate to location details screen on item click
            final ArrayList<Location> finalLocations = locations;
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent locationIntent = new Intent(getContext(), LocationDetailsActivity.class);
                    locationIntent.putExtra(Constants.INTENT_EXTRA_ID, finalLocations.get(position).getIndex());
                    startActivity(locationIntent);
                }
            });
        }

        return rootView;
    }
}
