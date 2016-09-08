package com.itheima.oschina.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.itheima.oschina.R;
import com.itheima.oschina.adapter.MyFrgmentAdapter;
import com.itheima.oschina.adapter.MyMovePageAdapter;
import com.itheima.oschina.adapter.MyPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 吴广东 on 2016/9/4.
 */
public class MoveFragment extends Fragment {

    private View rootview;
    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.sum_fragment,null);
        initView();

        return view;
    }

    /**
     * 初始化控件
     */
    private void initView() {
        List<BaseFragment> mpager = new ArrayList<>();
        mpager.add(new NewsMoveFragment());
        mpager.add(new HotMOveFragment());
        mpager.add(new MeMoveFragemnt());


        TabLayout mTabLayout = (TabLayout) view.findViewById(R.id.tabs);
        ViewPager mViewpager = (ViewPager) view.findViewById(R.id.content_vp);
        MyFrgmentAdapter adapter = new MyFrgmentAdapter(getChildFragmentManager(),mpager);
       //MyMovePageAdapter adapter = new MyMovePageAdapter(getFragmentManager(), mpagers);
        mViewpager.setAdapter(adapter);
//        MyPagerAdapter Adapter = new MyPagerAdapter(3,mpagers);
//        mViewpager.setAdapter(Adapter);
        mTabLayout.setupWithViewPager(mViewpager);

    }

}
