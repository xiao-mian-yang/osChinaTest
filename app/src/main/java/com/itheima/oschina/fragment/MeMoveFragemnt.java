package com.itheima.oschina.fragment;

import android.view.View;
import android.widget.TextView;

/**
 * Created by 吴广东 on 2016/9/5.
 */
public class MeMoveFragemnt extends BaseFragment {
    @Override
    public String getTitle() {
        return "我的动弹";
    }

    @Override
    public View initView() {
        TextView text= new TextView(getContext());
        text.setText("我的动弹");
        System.out.println("~~~~~~~~~~~~~~~~~");
        return text;
    }
}
