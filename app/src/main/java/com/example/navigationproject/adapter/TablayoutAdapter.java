package com.example.navigationproject.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by xsianj on 2017/5/24.
 */

public class TablayoutAdapter extends FragmentPagerAdapter {
    private List<Fragment>mFragments;
    private List<String>mTitles;
    public TablayoutAdapter(FragmentManager fm, List<Fragment>mFragments, List<String>mTitles) {
        super(fm);
        this.mFragments=mFragments;
        this.mTitles=mTitles;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments==null?0:mFragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles.get(position);
    }
}
