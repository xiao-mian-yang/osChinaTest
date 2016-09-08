package com.itheima.oschina.fragment;

import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

/**
 * Created by 吴广东 on 2016/9/4.
 */
public class recommandFragment extends BaseFragment {
    @Override
    public String getTitle() {
        return "推荐";
    }

    @Override
    public View initView() {
        TextView mtext = new TextView(getActivity());
        mtext.setGravity(Gravity.CENTER);
        mtext.setText("推荐");
        return mtext;
    }
}
