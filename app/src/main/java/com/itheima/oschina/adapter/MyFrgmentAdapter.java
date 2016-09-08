package com.itheima.oschina.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.itheima.oschina.fragment.BaseFragment;
import com.itheima.oschina.fragment.FragmentFactory;

import java.util.List;

/**
 * Created by 吴广东 on 2016/9/4.
 */
public class MyFrgmentAdapter extends FragmentPagerAdapter {
    private final List<BaseFragment> mpagers;

    public MyFrgmentAdapter(FragmentManager fm, List<BaseFragment> mpagers) {
        super(fm);
        this.mpagers = mpagers;
    }

    @Override
    public Fragment getItem(int position) {
        return mpagers.get(position);
    }

    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }

    @Override
    public int getCount() {
        return mpagers.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {

        return mpagers.get(position).getTitle();
    }
}
