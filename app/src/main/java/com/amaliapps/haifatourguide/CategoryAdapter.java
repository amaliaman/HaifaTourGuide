package com.amaliapps.haifatourguide;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class CategoryAdapter extends FragmentPagerAdapter {
    CategoryAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return new LocationsFragment();
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
