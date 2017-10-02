package com.example.abiduzair.tabbed;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.abiduzair.tabbed.complete;
import com.example.abiduzair.tabbed.current;

/**
 * Created by AbidUzair on 01-10-2017.
 */

public class PagerAdapter extends FragmentStatePagerAdapter {
    int mNoOfTabs;
    public  PagerAdapter(FragmentManager fm, int noOftabs)
    {
        super(fm);
        this.mNoOfTabs=noOftabs;
    }
    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0:
                current tab1=new current();
                return tab1;
            case 1:
                complete tab2=new complete();
                return tab2;
            default:
                return null;


        }

    }

    @Override
    public int getCount() {
        return mNoOfTabs;
    }
}
