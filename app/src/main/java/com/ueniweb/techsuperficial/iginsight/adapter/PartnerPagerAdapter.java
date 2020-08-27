package com.ueniweb.techsuperficial.iginsight.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.ueniweb.techsuperficial.iginsight.fragments.AgeRangeChartFragment;
import com.ueniweb.techsuperficial.iginsight.fragments.LocationChartFrament;
import com.ueniweb.techsuperficial.iginsight.fragments.PieChartFragment;

public class PartnerPagerAdapter extends FragmentStatePagerAdapter {



    public PartnerPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new PieChartFragment();
            case 1:
                return new LocationChartFrament();
            case 2:
                return new AgeRangeChartFragment();
            default: return null;

        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}
