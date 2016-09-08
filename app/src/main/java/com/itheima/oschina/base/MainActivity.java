package com.itheima.oschina.base;

import android.app.Dialog;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;


import com.itheima.oschina.R;
import com.itheima.oschina.adapter.MyFrgmentAdapter;
import com.itheima.oschina.fragment.FoundFragment;
import com.itheima.oschina.fragment.MeFragment;
import com.itheima.oschina.fragment.MoveFragment;
import com.itheima.oschina.fragment.SumFragment;

import butterknife.OnClick;

public class MainActivity extends AppCompatActivity  {
    private Toolbar mToolbar;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mtoogle;
    private ViewPager mViewpager;
    private TabLayout mTabs;
    private RadioGroup mRadiogroup;
    private ImageView iv_cloase;
    private Button btShare;
    //    private Context mContext;
    private LinearLayout btWeixin;
    private LinearLayout btWeibo;
    private LinearLayout btPengyouquan;
    private RadioButton radiobtn3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initToolsAndDrawLayout();
       // initViewPagerAndIndcator();
        initRadioGroup();
        mRadiogroup.check(R.id.radiobtn1);

        //getSupportFragmentManager().beginTransaction().replace(R.id.content_fragment,new SumFragment()).commit();

    }



    private void initView() {
       // mTabs = (TabLayout) findViewById(R.id.tabs);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
       // mViewpager = (ViewPager) findViewById(R.id.content_vp);



    }


    /**
     * 初始化界面
     */
    private void initToolsAndDrawLayout() {

        //toolbar.setLogo(R.drawable.actionbar_back_icon_normal);
        mToolbar.setTitleTextColor(Color.WHITE);
        //mToolbar.setNavigationIcon(R.drawable.actionbar_back_icon_normal);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mtoogle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mtoogle.syncState();
        mDrawerLayout.setDrawerListener(mtoogle);

    }

    /**
     * 初始化indcator和ViewPager
     */
//    private void initViewPagerAndIndcator() {
//        MyFrgmentAdapter adapter = new MyFrgmentAdapter(getSupportFragmentManager(),);
//        mViewpager.setAdapter(adapter);
//        mTabs.setupWithViewPager(mViewpager);
//
//
//
//    }

    /**
     * 初始化RadioButton的方法
     */
    private void initRadioGroup() {
        mRadiogroup = (RadioGroup) findViewById(R.id.radiogroup);
        radiobtn3 = (RadioButton) findViewById(R.id.radiobtn3);
        mRadiogroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                //获取变更后的选中的id
                switch (checkedId){

                    case R.id.radiobtn1:
                      getSupportFragmentManager().beginTransaction().replace(R.id.content_fragment,new SumFragment()).commit();
                        break;
                    case R.id.radiobtn2:
                        getSupportFragmentManager().beginTransaction().replace(R.id.content_fragment,new MoveFragment()).commit();
                        break;
                    case R.id.radiobtn4:
                        getSupportFragmentManager().beginTransaction().replace(R.id.content_fragment,new FoundFragment()).commit();
                        break;
                    case R.id.radiobtn5:
                        getSupportFragmentManager().beginTransaction().replace(R.id.content_fragment,new MeFragment()).commit();
                        break;
                    case R.id.radiobtn3:
                        btnclick();
                        break;


                }
            }
        });


    }
    //点击按钮3
    private void btnclick() {
        final Dialog dialog = new Dialog(this, R.style.Theme_Light_Dialog);
        View dialogView = LayoutInflater.from(this).inflate(R.layout.dialog, null);
        //获得dialog的window窗口
        Window window = dialog.getWindow();
        //设置dialog在屏幕底部
        window.setGravity(Gravity.BOTTOM);
        //设置dialog弹出时的动画效果，从屏幕底部向上弹出
        window.setWindowAnimations(R.style.dialogStyle);
        window.getDecorView().setPadding(0, 0, 0, 0);
        dialog.setCanceledOnTouchOutside(false);
        dialog.setCancelable(true);
        //获得window窗口的属性
        android.view.WindowManager.LayoutParams lp = window.getAttributes();
        //设置窗口宽度为充满全屏
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        //设置窗口高度为包裹内容
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        //将设置好的属性set回去
        window.setAttributes(lp);
        //将自定义布局加载到dialog上
        dialog.setContentView(dialogView);
        btWeixin = (LinearLayout) dialogView.findViewById(R.id.bt_weixin);
        btWeibo = (LinearLayout) dialogView.findViewById(R.id.bt_weibo);
        btPengyouquan = (LinearLayout) dialogView.findViewById(R.id.bt_pengyouquan);
        iv_cloase = (ImageView) dialogView.findViewById(R.id.iv_close);
        dialog.show();
        btWeixin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
        btWeibo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
        btPengyouquan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
        iv_cloase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //点击取消的操作
                dialog.cancel();
                radiobtn3.setChecked(false);
            }
        });
    }



    }
