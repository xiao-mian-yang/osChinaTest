package com.itheima.oschina.fragment;

import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.itheima.oschina.R;
import com.itheima.oschina.adapter.DividerItemDecoration;
import com.itheima.oschina.adapter.MyRecycleViewAdapter;
import com.itheima.oschina.bean.Blog;
import com.itheima.oschina.bean.BlogList;
import com.itheima.oschina.bean.News;
import com.itheima.oschina.bean.NewsList;
import com.itheima.oschina.util.XmlUtils;
import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/** 博客的Fragment
 * Created by 吴广东 on 2016/9/4.
 */
public class Blogfragment extends BaseFragment {

    private XRecyclerView mxrecycle;

    private View view;
    private List<Blog> list;

    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            list = (List<Blog>) msg.obj;
            mxrecycle.setAdapter(new MyRecycleViewAdapter(null));

        }
    };

    @Override
    public String getTitle() {
        return "博客";
    }

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

    @Override
    public void iniData() {
      //  initXrecyleView();
        //网络请求
        //requestData();
    }
    //下拉刷新，上拉加载
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
    //网络请求
    private void requestData() {
        OkHttpClient mok = new OkHttpClient();

        final Request request = new Request.Builder()
                .url("http://192.168.79.249:8080/oschina/list/blog/page0.xml")
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
                BlogList newbean = XmlUtils.toBean(BlogList.class, inputStream);
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
