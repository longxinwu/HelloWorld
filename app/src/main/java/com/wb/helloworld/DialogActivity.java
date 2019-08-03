package com.wb.helloworld;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.wb.helloworld.util.ToastUtil;

public class DialogActivity extends AppCompatActivity {

    private Button btnDialog1,btnDialog2,btnDialog3,btnDialog4,btnDialog5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
        btnDialog1 = findViewById(R.id.btn_dg1);
        btnDialog2 = findViewById(R.id.btn_dg2);
        btnDialog3 = findViewById(R.id.btn_dg3);
        btnDialog4 = findViewById(R.id.btn_dg4);
        btnDialog5 = findViewById(R.id.btn_dg5);

        DialogOnclick DOnClick = new DialogOnclick();

        btnDialog1.setOnClickListener(DOnClick);
        btnDialog2.setOnClickListener(DOnClick);
        btnDialog3.setOnClickListener(DOnClick);
        btnDialog4.setOnClickListener(DOnClick);
        btnDialog5.setOnClickListener(DOnClick);
    }


    class DialogOnclick implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.btn_dg1:
                    AlertDialog.Builder builder = new AlertDialog.Builder(DialogActivity.this);
                    builder.setTitle("请回答").setMessage("课程怎么样？");
                    builder.setIcon(R.drawable.user);
                    builder.setPositiveButton("棒", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            ToastUtil.showMsg(DialogActivity.this, "你说的对呀");
                        }
                    });
                    builder.setNegativeButton("差", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            ToastUtil.showMsg(DialogActivity.this, "睁眼说瞎话");
                        }
                    });
                    builder.show();
                    break;
                case R.id.btn_dg2:
                    final String[] ary2 = new String[]{"男", "女"};
                    AlertDialog.Builder builder2 = new AlertDialog.Builder(DialogActivity.this);
                    builder2.setTitle("选择性别").setItems(ary2, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            ToastUtil.showMsg(DialogActivity.this, ary2[i]);
                        }
                    });
                    builder2.show();
                case R.id.btn_3:
                    final String[] ary3 = new String[]{"男", "女"};
                    AlertDialog.Builder builder3 = new AlertDialog.Builder(DialogActivity.this);
                    builder3.setTitle("选择性别").setSingleChoiceItems(ary3, 0, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            ToastUtil.showMsg(DialogActivity.this, ary3[i]);
                            dialogInterface.dismiss();
                        }
                    }).setCancelable(false).show();
                    break;
                case R.id.btn_4:
                    final String[] ary4 = new String[]{"唱歌", "跳舞", "写代码"};
                    final boolean[] isSelected = new boolean[]{false, false, true};
                    AlertDialog.Builder builder4 = new AlertDialog.Builder(DialogActivity.this);
                    builder4.setTitle("兴趣爱好").setMultiChoiceItems(ary4, isSelected, new DialogInterface.OnMultiChoiceClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                                    ToastUtil.showMsg(DialogActivity.this, ary4[i]+":"+b);
                                }
                            }
                    ).show();
                    builder4.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            //
                        }
                    });
                    builder4.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            //
                        }
                    });
                    builder4.show();
                    break;
                case R.id.btn_dg5:
                    AlertDialog.Builder builder5 = new AlertDialog.Builder(DialogActivity.this);
                    View view5 = LayoutInflater.from(DialogActivity.this).inflate(R.layout.layout_toast, null);
                    ImageView imageView = view5.findViewById(R.id.iv_toast);
                    TextView textView = view5.findViewById(R.id.tv_toast);
                    imageView.setImageResource(R.drawable.user);
                    textView.setText("自定义dialog");

                    builder5.setView(view5).show();
                    break;
            }
        }
    }
}
