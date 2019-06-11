package com.example.task2;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class Addapter extends FragmentPagerAdapter {

    public Addapter(FragmentManager mgr) {
        super(mgr);
    }

    @Override
    public int getCount() {
        return (Main2Activity.keys.length-1);
    }

    @Override
    public Fragment getItem(int position) {
        if(position!=0)
            return(PageFragment.newInstance(Main2Activity.keys[position+1]));
        else
            return (PageFragment.newInstance(Main2Activity.keys[1]));
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if(position!=0)
            return (Main2Activity.keys[position+1].getName());
        else
            return Main2Activity.keys[1].getName();
    }
}
