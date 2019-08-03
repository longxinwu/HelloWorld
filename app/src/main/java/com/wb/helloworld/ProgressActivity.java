package com.wb.helloworld;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.CircularProgressDrawable;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.wb.helloworld.util.ToastUtil;

public class ProgressActivity extends AppCompatActivity {


    private ProgressBar mProgressbarStart3;
    private Button btnStart,btnPgDialog1,btnPgDialog2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);
        mProgressbarStart3 = findViewById(R.id.pb_3);
        btnStart = findViewById(R.id.btn_start);
        btnPgDialog1 = findViewById(R.id.btn_progress_dialog1);
        btnPgDialog2 = findViewById(R.id.btn_progress_dialog2);
        btnStart.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                handler.sendEmptyMessage(0);
            }
        });
        btnPgDialog1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder1 = new AlertDialog.Builder(ProgressActivity.this);
                View view1 = LayoutInflater.from(ProgressActivity.this).inflate(R.layout.layout_progress_item,null);
                ProgressBar mPgBar = view1.findViewById(R.id.pgBar1);
                TextView mTv = view1.findViewById(R.id.pgText1);
                mTv.setText("加载中...");
                builder1.setView(view1).show();
            }
        });
        btnPgDialog2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder2 = new AlertDialog.Builder(ProgressActivity.this);
                View view2 = LayoutInflater.from(ProgressActivity.this).inflate(R.layout.layout_progress_item1,null);
                ProgressBar mPgBar = view2.findViewById(R.id.pgBar2);
                TextView mTv = view2.findViewById(R.id.pgText2);
                mPgBar.setProgress(50);
                mTv.setText("加载中...");
                builder2.setPositiveButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        ToastUtil.showMsg(ProgressActivity.this,"取消成功");
                    }
                });
                builder2.setView(view2).show();
            }
        });

    }

    Handler handler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            if(mProgressbarStart3.getProgress() < 100){
                handler.postDelayed(runnable,500);
            }else{
                ToastUtil.showMsg(ProgressActivity.this, "加载完成");
            }
        }
    };

    Runnable runnable = new Runnable(){
        @Override
        public void run() {
            mProgressbarStart3.setProgress(mProgressbarStart3.getProgress()+3);
            handler.sendEmptyMessage(0);
        }
    };
}
