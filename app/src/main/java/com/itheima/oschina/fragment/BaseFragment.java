package com.itheima.oschina.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by 吴广东 on 2016/9/4.
 */
public abstract class BaseFragment extends Fragment {

    protected Context context;

    public abstract String getTitle();
    public abstract View initView();
    protected View mView = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        context = getActivity();
        if(mView == null){

            mView =  initView();
        }else{

            ViewGroup parent = (ViewGroup) mView.getParent();
            if(parent != null){

               parent.removeAllViews();
            }
        }


        return mView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        iniData();
    }

    protected  void iniData(){

    }
}
