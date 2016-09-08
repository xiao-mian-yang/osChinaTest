package com.itheima.oschina.fragment;

import android.content.SyncStatusObserver;
import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.itheima.oschina.R;
import com.itheima.oschina.adapter.DividerItemDecoration;
import com.itheima.oschina.adapter.MyBaseAdapter;
import com.itheima.oschina.adapter.MyRecycleViewAdapter;
import com.itheima.oschina.bean.Active;
import com.itheima.oschina.bean.News;
import com.itheima.oschina.bean.NewsList;
import com.itheima.oschina.util.XmlUtils;
import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.internal.Util;
import com.squareup.okhttp.internal.spdy.Header;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * 咨询页面的Fragment
 * Created by 吴广东 on 2016/9/4.
 */
public class Consultfragment extends BaseFragment {
    private View view;
    private ListView lisview;
    private XRecyclerView mxrecycle;
    private List<News> list;
 @Override
    public String getTitle() {
        return "咨询";
    }
    /**
     * 初始化控件
     *
     * @return
     */
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
             list = (List<News>) msg.obj;
            mxrecycle.setAdapter(new MyRecycleViewAdapter(list));

        }
    };
    @Override
    public View initView() {
        view = View.inflate(getContext(), R.layout.pull_torefresh_listview, null);
        //lisview = (ListView) view.findViewById(R.id.lisview);
        mxrecycle = (XRecyclerView) view.findViewById(R.id.lisview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mxrecycle.setLayoutManager(layoutManager);
        mxrecycle.setRefreshProgressStyle(ProgressStyle.CubeTransition);
        mxrecycle.addItemDecoration(new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL_LIST));
        return view;
    }
    /**
     * 初始化数据
     */
    @Override
    protected void iniData() {
        System.out.println("==========================================");
        // lisview.setAdapter(new MyBaseAdapter());
        initXrecyleView();
        //网络请求
        requestData();
    }
    //下拉和上啦刷新
    private void initXrecyleView() {
        mxrecycle.setLoadingListener(
                new XRecyclerView.LoadingListener() {

                    @Override
                    public void onRefresh() {
                        mxrecycle.refreshComplete();
                    }

                    @Override
                    public void onLoadMore() {
                        mxrecycle.loadMoreComplete();
                        Toast.makeText(getContext(), "土司", Toast.LENGTH_SHORT).show();
                    }
                }
        );
    }
    //网络请求数据
    private void requestData() {
        OkHttpClient mok = new OkHttpClient();

        final Request request = new Request.Builder()
                .url("http://192.168.79.249:8080/oschina/list/news/page0.xml")
                .build();
        Call call = mok.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                System.out.println("链接失败");

            }
            @Override
            public void onResponse(Response response) throws IOException {
                System.out.println("链接成功");
                InputStream inputStream = response.body().byteStream();
                NewsList newbean = XmlUtils.toBean(NewsList.class, inputStream);
                list = newbean.getList();
                System.out.println(newbean.getList().size());
                System.out.println(newbean.getList().get(0).getAuthor());
                Message message = new Message();
                message.obj = list;
                handler.sendMessage(message);
            }
        });


    }


}
