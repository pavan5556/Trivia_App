package com.pavan.triviaapp.ui.main;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class PagerAdapter extends FragmentPagerAdapter {


    public PagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                return new Question1Fragment();
            case 1:
                return new Question2Fragment();
            default:
                return SummaryFragment.newInstance();
        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}
