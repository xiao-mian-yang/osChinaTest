package com.itheima.oschina.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.itheima.oschina.R;
import com.itheima.oschina.bean.News;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by 吴广东 on 2016/9/5.
 */
public class MyRecycleViewAdapter extends RecyclerView.Adapter<MyRecycleViewAdapter.MyViewHolder> {


    private final List<News> mlist;

    public MyRecycleViewAdapter(List<News> list) {
        this.mlist = list;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder holder = new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.litview_item, parent, false));

        return holder;
    }

    @Override
    public void onBindViewHolder(MyRecycleViewAdapter.MyViewHolder holder, int position) {
        holder.text1.setText(mlist.get(position).getTitle());
        holder.text2.setText(mlist.get(position).getBody());
        holder.text3.setText(mlist.get(position).getPubDate());
        holder.name1.setText(mlist.get(position).getAuthor());
        holder.number.setText(mlist.get(position).getCommentCount()+"");
    // holder.text.setText("文本");

    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }


    static class MyViewHolder extends RecyclerView.ViewHolder {
       // private final TextView text;
        @InjectView(R.id.text1)
        TextView text1;
        @InjectView(R.id.text2)
        TextView text2;
        @InjectView(R.id.name1)
        TextView name1;
        @InjectView(R.id.text3)
        TextView text3;
        @InjectView(R.id.number)
        TextView number;

        MyViewHolder(View view) {
            super(view);
            ButterKnife.inject(this, view);
            //text = (TextView) view.findViewById(R.id.text1);
        }
    }

}
