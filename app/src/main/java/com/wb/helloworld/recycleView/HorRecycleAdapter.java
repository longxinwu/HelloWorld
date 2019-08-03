package com.wb.helloworld.recycleView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.wb.helloworld.R;

public class HorRecycleAdapter extends RecyclerView.Adapter<HorRecycleAdapter.HorViewHolder> {

    private Context mContext;

    private OnClickItemListener mOnClickItemListener;
    public HorRecycleAdapter (Context context, OnClickItemListener listener){
        this.mContext = context;
        this.mOnClickItemListener = listener;
    }
    @NonNull
    @Override
    public HorRecycleAdapter.HorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new HorRecycleAdapter.HorViewHolder(LayoutInflater.from(mContext).inflate(R.layout.layout_hor_recycle_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull HorRecycleAdapter.HorViewHolder holder, final int position) {
        holder.mtextView.setText("hello word!");
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

    class HorViewHolder extends RecyclerView.ViewHolder{
        private TextView mtextView;
        //每个item的样式
        public HorViewHolder(@NonNull View itemView) {
            super(itemView);
            mtextView = (TextView) itemView.findViewById(R.id.tv_title);
        }
    }

    public interface OnClickItemListener{
        void onClick(int pos);
    }
}
