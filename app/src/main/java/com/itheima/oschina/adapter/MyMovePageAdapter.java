package com.itheima.oschina.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.itheima.oschina.fragment.BaseMoveFragment;

import java.util.List;

/**
 * Created by 吴广东 on 2016/9/5.
 */
public class MyMovePageAdapter extends FragmentPagerAdapter {
    private final List<BaseMoveFragment> mpager;

    public MyMovePageAdapter(FragmentManager fm, List<BaseMoveFragment> mpager) {
        super(fm);
        this.mpager = mpager;
    }

    @Override
    public Fragment getItem(int position) {
        return mpager.get(position);
    }

    @Override
    public int getCount() {
        return mpager.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mpager.get(position).getTitle();
    }
}
