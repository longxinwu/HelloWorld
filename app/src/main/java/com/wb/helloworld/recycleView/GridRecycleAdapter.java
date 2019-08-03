package com.wb.helloworld.recycleView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.wb.helloworld.R;

public class GridRecycleAdapter extends RecyclerView.Adapter<GridRecycleAdapter.GridViewHolder> {

    private Context mContext;

    private OnClickItemListener mOnClickItemListener;
    public GridRecycleAdapter(Context context, OnClickItemListener listener){
        this.mContext = context;
        this.mOnClickItemListener = listener;
    }
    @NonNull
    @Override
    public GridRecycleAdapter.GridViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new GridRecycleAdapter.GridViewHolder(LayoutInflater.from(mContext).inflate(R.layout.layout_grid_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull GridRecycleAdapter.GridViewHolder holder, final int position) {
        holder.mtextView.setText("hello word!");
        Glide.with(mContext).load("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1564715198&di=773e058eedb1a08a2ceb3c461481ebd7&imgtype=jpg&er=1&src=http%3A%2F%2Fimg1.cache.netease.com%2Fcatchpic%2F4%2F47%2F47E5E3CA5A91B67C4D76CF2F01970A3D.jpg").into(holder.mImageView);
        holder.itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                //Toast.makeText(mContext, "短点击"+position, Toast.LENGTH_SHORT).show();
                mOnClickItemListener.onClick(position);
            }
        });
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Toast.makeText(mContext, "长点击"+position, Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return 20;
    }

    class GridViewHolder extends RecyclerView.ViewHolder{
        private TextView mtextView;
        private ImageView mImageView;
        //每个item的样式
        public GridViewHolder(@NonNull View itemView) {
            super(itemView);
            mtextView = (TextView) itemView.findViewById(R.id.tv_title);
            mImageView = (ImageView) itemView.findViewById(R.id.imageView_grid);
        }
    }

    public interface OnClickItemListener{
        void onClick(int pos);
    }
}
