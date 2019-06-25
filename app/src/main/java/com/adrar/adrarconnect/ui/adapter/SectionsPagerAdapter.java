package com.adrar.adrarconnect.ui.adapter;

//
// Created by FERRARIS Philippe on 13/06/2019 for adrarConnect.
//

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.adrar.adrarconnect.R;
import com.adrar.adrarconnect.ui.fragment.JobSearcherFragment;
import com.adrar.adrarconnect.ui.fragment.SalaryFragment;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    private static final int FRAMENT_SALARY_POS = 0;
    private static final int FRAMENT_JOB_SEARCH_POS = 1;

    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.salarie, R.string.chomeur};
    private final Context mContext;

    public SectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {

        if (position == FRAMENT_SALARY_POS) {
            return SalaryFragment.newInstance();
        } else if (position == FRAMENT_JOB_SEARCH_POS) {
            return JobSearcherFragment.newInstance();
        } else {
            //En cas d'erreur je retourne le 1er
            return SalaryFragment.newInstance();
        }
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }

    @Override
    public int getCount() {
        // Show 2 total pages.
        return 2;
    }
}