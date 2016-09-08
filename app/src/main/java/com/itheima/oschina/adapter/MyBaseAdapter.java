package com.itheima.oschina.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.itheima.oschina.R;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by 吴广东 on 2016/9/5.
 */
public class MyBaseAdapter extends BaseAdapter {
    @Override
    public int getCount() {
        return 20;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = View.inflate(parent.getContext(), R.layout.litview_item, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }
        else {
           holder = (ViewHolder) convertView.getTag();

        }


        return convertView;
    }

    static class ViewHolder {
        @InjectView(R.id.text1)
        TextView text1;
        @InjectView(R.id.text2)
        TextView text2;
        @InjectView(R.id.name1)
        TextView name1;
        @InjectView(R.id.image1)
        ImageView image1;
        @InjectView(R.id.text3)
        TextView text3;
        @InjectView(R.id.image2)
        ImageView image2;
        @InjectView(R.id.number)
        TextView number;

        ViewHolder(View view) {
            ButterKnife.inject(this, view);
        }
    }
}
