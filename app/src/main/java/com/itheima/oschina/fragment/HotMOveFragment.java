package com.itheima.oschina.fragment;

import android.view.View;
import android.widget.TextView;

/**
 * Created by 吴广东 on 2016/9/5.
 */
public class HotMOveFragment extends BaseFragment {
    @Override
    public String getTitle() {
        return "热门动弹";
    }

    @Override
    public View initView() {
        TextView text= new TextView(getContext());
        text.setText("热门动弹");
        return text;
    }
}
