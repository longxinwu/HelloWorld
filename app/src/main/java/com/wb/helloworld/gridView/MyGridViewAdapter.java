package com.wb.helloworld.gridView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.wb.helloworld.R;

public class MyGridViewAdapter extends BaseAdapter {
    private Context context;
    private LayoutInflater layoutInflater;

    public MyGridViewAdapter(Context context){
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return 10;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    static class ViewHolder{
        private ImageView mImageView;
        private TextView mTextView;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = null;
        if(view == null){
            view = layoutInflater.inflate(R.layout.layout_grid_item,null);
            holder = new ViewHolder();
            holder.mImageView = view.findViewById(R.id.imageView_grid);
            holder.mTextView = view.findViewById(R.id.tv_title);
            view.setTag(holder);
        }else{
            holder = (ViewHolder) view.getTag();
        }
        //给控件赋值
        holder.mTextView.setText("这是标题");
        Glide.with(context).load("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1564715198&di=773e058eedb1a08a2ceb3c461481ebd7&imgtype=jpg&er=1&src=http%3A%2F%2Fimg1.cache.netease.com%2Fcatchpic%2F4%2F47%2F47E5E3CA5A91B67C4D76CF2F01970A3D.jpg").into(holder.mImageView);
        return view;
    }
}
