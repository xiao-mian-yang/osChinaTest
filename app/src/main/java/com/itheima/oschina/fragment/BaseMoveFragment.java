package com.itheima.oschina.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by 吴广东 on 2016/9/5.
 */
public abstract class BaseMoveFragment extends Fragment {

    public abstract String getTitle();
    public abstract View initView();
    protected View mView = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if(mView == null){

            mView =  initView();

        }
        ViewGroup parent = (ViewGroup) mView.getParent();


            if(parent != null){

                parent.removeView(mView);

        }


        return mView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    public void  initData(){

    }

}
