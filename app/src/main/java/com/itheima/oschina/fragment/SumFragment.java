package com.itheima.oschina.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.itheima.oschina.R;
import com.itheima.oschina.adapter.MyFrgmentAdapter;
import com.itheima.oschina.adapter.MyPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**综合的Fragment
 * Created by 吴广东 on 2016/9/4.
 */
public class SumFragment extends Fragment{

    private View view;
    private List<BaseFragment> mpagers;

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
        mpagers = new ArrayList<BaseFragment>();
        mpagers.add(new Consultfragment());
        mpagers.add(new HotFragment());
        mpagers.add(new Blogfragment());
        mpagers.add(new recommandFragment());

        TabLayout mTabLayout = (TabLayout) view.findViewById(R.id.tabs);
        ViewPager mViewpager = (ViewPager) view.findViewById(R.id.content_vp);
        MyFrgmentAdapter adapter = new MyFrgmentAdapter(getChildFragmentManager(),mpagers);
        mViewpager.setAdapter(adapter);
//        MyPagerAdapter Adapter =  new MyPagerAdapter(4,mpagers);
//        mViewpager.setAdapter(Adapter);
        mTabLayout.setupWithViewPager(mViewpager);
    }


}
