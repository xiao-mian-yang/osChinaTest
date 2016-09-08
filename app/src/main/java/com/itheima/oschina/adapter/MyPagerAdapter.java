package com.itheima.oschina.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.itheima.oschina.R;
import com.itheima.oschina.fragment.BaseFragment;

import java.util.List;

/**
 * Created by 吴广东 on 2016/9/4.
 */
public class MyPagerAdapter extends PagerAdapter {
    private final List<BaseFragment> mpager;
    private  int index;
    String [] Tabnames;



    public MyPagerAdapter(int i, List<BaseFragment> mpagers) {
        this.index = i;
        this.mpager = mpagers;
        if (index ==3){

            Tabnames = new String[]{"最新动弹","热门动弹","我的动弹"};
        }else if(index == 4){
            Tabnames = new String[]{"咨询","热门","博客","推荐"};
        }
    }

    @Override
    public int getCount() {
        return Tabnames.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
        //super.destroyItem(container, position, object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
//        TextView mtext = new TextView(container.getContext());
//        mtext.setText("页面1");
//        container.addView(mtext);
        View listview = View.inflate(container.getContext(),R.layout.pull_torefresh_listview, null);
        container.addView(listview);

        return listview;
    }

    @Override
    public CharSequence getPageTitle(int position) {

        return Tabnames[position];
    }
}
