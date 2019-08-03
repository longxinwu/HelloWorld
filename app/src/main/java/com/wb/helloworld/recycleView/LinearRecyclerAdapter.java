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

import com.wb.helloworld.R;

public class LinearRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;

    private OnClickItemListener mOnClickItemListener;

    public LinearRecyclerAdapter (Context context, OnClickItemListener listener){
        this.mContext = context;
        this.mOnClickItemListener = listener;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        if(viewType == 0){
            return new LinearViewHolder(LayoutInflater.from(mContext).inflate(R.layout.layout_linear_item,parent,false));
        }else{
            return new LinearViewHolder2(LayoutInflater.from(mContext).inflate(R.layout.layout_linear_item_2,parent,false));
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        if(getItemViewType(position) ==0){

            ((LinearViewHolder)holder).mtextView.setText("hello word!");
        }else {
            ((LinearViewHolder2)holder).mtextView.setText("hello");
        }
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

    @Override
    public int getItemViewType(int position) {
        if(position % 2 == 0){
            return 0;
        }else{
            return 1;
        }
    }

    class LinearViewHolder extends RecyclerView.ViewHolder{
        private TextView mtextView;
        //每个item的样式
        public LinearViewHolder(@NonNull View itemView) {
            super(itemView);
            mtextView = (TextView) itemView.findViewById(R.id.tv_title);
        }
    }

    class LinearViewHolder2 extends RecyclerView.ViewHolder{
        private TextView mtextView;
        private ImageView mImageView;
        //每个item的样式
        public LinearViewHolder2(@NonNull View itemView) {
            super(itemView);
            mtextView = (TextView) itemView.findViewById(R.id.tv_title);
            mImageView = (ImageView) itemView.findViewById(R.id.iv_image);
        }
    }

    public interface OnClickItemListener{
        void onClick(int pos);
    }
}
