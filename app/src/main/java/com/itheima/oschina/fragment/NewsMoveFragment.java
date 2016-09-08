package com.itheima.oschina.fragment;

import android.view.View;
import android.widget.TextView;

/**
 * Created by 吴广东 on 2016/9/5.
 */
public class NewsMoveFragment extends BaseFragment {
    @Override
    public String getTitle() {
        return "最新动弹";
    }

    @Override
    public View initView() {
        TextView textView = new TextView(getActivity());
        textView.setText("最新动弹");
        System.out.println("+++++++++++++++++++++++++++++++");
        return textView;
    }
}
