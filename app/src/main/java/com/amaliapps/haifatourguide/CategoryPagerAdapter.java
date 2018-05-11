package com.amaliapps.haifatourguide;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class CategoryPagerAdapter extends FragmentPagerAdapter {

    CategoryPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        // Pass the selected category to the location fragment
        Bundle bundle = new Bundle();
        bundle.putInt(Constants.BUNDLE_CATEGORY_ID, Category.getCategories().get(position).getId());
        LocationsFragment locationsFragment = new LocationsFragment();
        locationsFragment.setArguments(bundle);
        return locationsFragment;
    }

    @Override
    public int getCount() {
        return Category.getCategories().size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return Category.getCategories().get(position).getTitle();
    }
}
